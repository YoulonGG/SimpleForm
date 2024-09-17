package com.example.simpleform

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val  txtUsername = findViewById<EditText>(R.id.txtUsername)
        val txtAge = findViewById<EditText>(R.id.txtAge)
        val txtJob = findViewById<EditText>(R.id.txtJob)

        btnSubmit.setOnClickListener {

            val userName = txtUsername.text.toString()
            val age = txtAge.text.toString()
            val job = txtJob.text.toString()

            when {
                //Check if username input text is empty
                txtUsername.text.toString().isEmpty() -> txtUsername.error = "Enter your username"

                //let user input not less 4 and not more than 10
                txtUsername.text.toString().length !in 4..10 -> { txtUsername.error = "Enter between 4 and 10 characters" }

                //check if age input text is empty
                txtAge.text.toString().isEmpty() -> txtAge.error = "Enter your age"

                //Let user input age only between 18 and 99
                txtAge.text.toString().toIntOrNull() !in 18..99-> txtAge.error = "Your age must between 18 and 99 years old"

                //Check if job input text is empty
                txtJob.text.toString().isEmpty() -> { txtJob.error = "Enter your job"}
                else -> {
                    val intent = Intent(this, SecondActivity::class.java)

                    //Give value to Another Activity using putExtra() with key_word
                    intent.putExtra("username_key", userName)
                    intent.putExtra("age_key", age)
                    intent.putExtra("job_key", job)
                    startActivity(intent)
                }
            }
        }
    }
}