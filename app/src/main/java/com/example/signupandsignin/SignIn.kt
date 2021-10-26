package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.IOException

class SignIn : AppCompatActivity() {


    lateinit var signIn: Button
    lateinit var edName: EditText
    lateinit var pass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        signIn = findViewById(R.id.signIn1)
        edName = findViewById(R.id.edUname)
        pass = findViewById(R.id.edpass)

        var dbh = DBHelper(applicationContext)

        signIn.setOnClickListener {

            val name = edName.text.toString()
            val pass = pass.text.toString()

            if(name.isNotEmpty() && pass.isNotEmpty()){

                    val check = dbh.userPresent(name,pass)

                    if( check ){
                        val intent = Intent(this, profile::class.java)
                        intent.putExtra("name" , name )
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "user not found " , Toast.LENGTH_SHORT).show()
                    }

            }else {

                Toast.makeText(this, " please fill all the information " , Toast.LENGTH_SHORT).show()
            }
        }

    }
}