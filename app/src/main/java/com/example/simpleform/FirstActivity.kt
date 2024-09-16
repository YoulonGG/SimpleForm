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

            if (txtUsername.text.isNotEmpty() && txtAge.text.isNotEmpty() && txtJob.text.isNotEmpty() ) {
                val intent = Intent(this, SecondActivity::class.java)
                //Give value to Another Activity using putExtra() with key_word
                intent.putExtra("username_key", userName)
                intent.putExtra("age_key", age)
                intent.putExtra("job_key", job)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter the form correctly!!", Toast.LENGTH_SHORT).show()
            }

        }


    }
}