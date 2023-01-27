package com.example.ukl

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnLogin:Button
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)

        btnLogin=findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)
    }
    override fun onClick(v:View){
        var emptyEmail: Boolean = false
        var emptyPassword: Boolean = false


        if(edtEmail.text.toString().trim().length == 0){
            edtEmail.error = "Email harus diisi"
            emptyEmail = true
        }
        if(edtPassword.text.toString().trim().length == 0){
            edtPassword.error = "Password harus diisi"
            emptyPassword = true
        }

        if (!emptyEmail && !emptyPassword){
            val dataRecieved = Intent(this@MainActivity, LoggedAhay::class.java)
            val email = edtEmail.text.toString()
            dataRecieved.putExtra("String",email)
            startActivity(dataRecieved)
        }

    }
}