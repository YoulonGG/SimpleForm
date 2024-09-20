package com.example.simpleform

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val  txtUsername = findViewById<EditText>(R.id.txtUsername)
        val txtAge = findViewById<EditText>(R.id.txtAge)
        val txtJob = findViewById<EditText>(R.id.txtJob)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val gender = findViewById<Spinner>(R.id.genderSelection)
        val datePicker = findViewById<EditText>(R.id.datePicker)

        // Set value to spinner
        val items = listOf("Male", "Female")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        gender.adapter = adapter

        //Function to date picker
        fun showDatePickerDialog() {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                datePicker.setText(selectedDate)
            }, year, month, day)

            datePickerDialog.show()
        }

        // Function for email need to be valid as email address
        fun String.isEmailValid(): Boolean {
            val emailRegex = "^[A-Za-z](.*)(@)(.+)(\\.)(.+)"
            return emailRegex.toRegex().matches(this)
        }

        //Show date picker when user clicked
        datePicker.setOnClickListener {
            showDatePickerDialog()
        }

        btnSubmit.setOnClickListener {

            //set values to string so we can pass values to other activity
            val userName = txtUsername.text.toString()
            val age = txtAge.text.toString()
            val job = txtJob.text.toString()
            val email = txtEmail.text.toString()
            val selectedGender = gender.selectedItem.toString()
            val dateOfBirth = datePicker.text.toString()



            when {
                //Check if username input text is empty
                txtUsername.text.toString().isEmpty() -> txtUsername.error = "Enter your username"
                //let user input not less 4 and not more than 10
                txtUsername.text.toString().length !in 4..10 -> { txtUsername.error = "Enter between 4 and 10 characters" }

                //Check if email input text is empty
                txtEmail.text.toString().isEmpty() -> txtEmail.error = "Enter your email"
                //Check if email is valid
                !txtEmail.text.toString().isEmailValid() -> txtEmail.error = "Enter your email correctly"

                //check if age input text is empty
                txtAge.text.toString().isEmpty() -> txtAge.error = "Enter your age"
                //Let user input age only between 18 and 99
                txtAge.text.toString().toIntOrNull() !in 18..99-> txtAge.error = "Your age must between 18 and 99 years old"

                //Check if date of birth is empty
                datePicker.text.toString().isEmpty() -> datePicker.error = "Your date of birth is missing!"

                //Check if job input text is empty
                txtJob.text.toString().isEmpty() -> { txtJob.error = "Enter your job"}
                else -> {
                    val intent = Intent(this, SecondActivity::class.java)

                    //Give value to Another Activity using putExtra() with key_word
//                    intent.putExtra("username_key", userName)
//                    intent.putExtra("email_key", email)
//                    intent.putExtra("age_key", age)
//                    intent.putExtra("gender_key", selectedGender)
//                    intent.putExtra("dob_key", dateOfBirth)
//                    intent.putExtra("job_key", job)
//                    startActivity(intent)

                    //Use apply from Scope Function instead
                    intent.apply {
                        putExtra("username_key", userName)
                        putExtra("email_key", email)
                        putExtra("age_key", age)
                        putExtra("gender_key", selectedGender)
                        putExtra("dob_key", dateOfBirth)
                        putExtra("job_key", job)
                        startActivity(intent)
                    }

                }
            }
        }

    }
}