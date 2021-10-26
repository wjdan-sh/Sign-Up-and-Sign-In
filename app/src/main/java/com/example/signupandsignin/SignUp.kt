package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {

    lateinit var signUp: Button
    lateinit var edName: EditText
    lateinit var edMobile: EditText
    lateinit var edlocation: EditText
    lateinit var edpassword1: EditText
    lateinit var edpassword2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUp = findViewById(R.id.signUp1)
        edName = findViewById(R.id.edName)
        edMobile = findViewById(R.id.edmobil)
        edlocation = findViewById(R.id.edloc)
        edpassword1 = findViewById(R.id.edpass1)
        edpassword2 = findViewById(R.id.edpass2)

        var dbh = DBHelper(applicationContext)

        signUp.setOnClickListener {
            val name = edName.text.toString()
            val mobile = edMobile.text.toString()
            val location = edlocation.text.toString()
            val pass1 = edpassword1.text.toString()
            val pass2 = edpassword2.text.toString()

                if(name.isNotEmpty() && mobile.isNotEmpty() && location.isNotEmpty() && pass1.isNotEmpty()&&pass2.isNotEmpty()){
                    if (!dbh.exists(name)) {
                        if (pass1 == pass2) {

                            var status = dbh.save(name, mobile, location, pass1)

                            Toast.makeText(this, "data saved! " + status, Toast.LENGTH_SHORT).show()

                            val intent = Intent(this, profile::class.java)
                            intent.putExtra("name", name)
                            startActivity(intent)

                        } else {

                            Toast.makeText(this, " passwords do not match ", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }else{

                        Toast.makeText(this, " user name is used ", Toast.LENGTH_SHORT)
                            .show()
                    }
                }else {

                    Toast.makeText(this, " please fill all the information " , Toast.LENGTH_SHORT).show()
                }


        }
    }
}