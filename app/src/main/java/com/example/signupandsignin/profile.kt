package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class profile : AppCompatActivity() {

    lateinit var signOut: Button
    lateinit var tv1: TextView
    lateinit var tv2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        signOut = findViewById(R.id.signOut)
        tv1 = findViewById(R.id.tV1)
        tv2 = findViewById(R.id.tV2)
        var dbh = DBHelper(applicationContext)
        val name = intent.getStringExtra("name")

        tv1.text= "Welcome " + name
        val info = name?.let { dbh.Retrieve(it) }
        tv2.text = "your details are : \n \n " + info

        signOut.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}