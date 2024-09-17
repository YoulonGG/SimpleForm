package com.example.simpleform

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val txtUsername = findViewById<TextView>(R.id.txtUsername2)
        val txtAge = findViewById<TextView>(R.id.txtAge2)
        val txtJob = findViewById<TextView>(R.id.txtJob2)
        val txtEmail = findViewById<TextView>(R.id.txtEmail2)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val gender = findViewById<TextView>(R.id.txtGender)
        val dateOfBirth = findViewById<TextView>(R.id.txtDateOfBirth)

        //Get value from first Activity using key_word and getStringExtra function
        val getUsername = intent.getStringExtra("username_key")
        txtUsername.text = getUsername

        val getEmail = intent.getStringExtra("email_key")
        txtEmail.text = getEmail

        val getAge = intent.getStringExtra("age_key")
        txtAge.text = getAge

        val getGender = intent.getStringExtra("gender_key")
        gender.text = getGender

        val getDOB = intent.getStringExtra("dob_key")
        dateOfBirth.text = getDOB

        val getJob = intent.getStringExtra("job_key")
        txtJob.text = getJob

        btnBack.setOnClickListener {
            //go back to the last screen
            finish()
        }

    }



}