package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var signIn: Button
    lateinit var signUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signIn =findViewById(R.id.signIn)
        signUp =findViewById(R.id.signUp)

        signIn.setOnClickListener {

            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        signUp.setOnClickListener {

            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)

        }

    }
}