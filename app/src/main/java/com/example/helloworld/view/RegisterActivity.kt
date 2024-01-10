package com.example.helloworld.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.helloworld.*


class RegisterActivity : AppCompatActivity() {
    val objectClass = Util()
    private val TAG = "RegisterActivity"
    lateinit var edit_uname: EditText
    lateinit var edit_pword: EditText
    lateinit var edit_email: EditText
    lateinit var edit_pnumber: EditText
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        edit_uname = findViewById<EditText>(R.id.username_register)
        edit_pword = findViewById<EditText>(R.id.password_register)
        edit_email = findViewById<EditText>(R.id.email_register)
        edit_pnumber = findViewById<EditText>(R.id.phone_register)

        var btnRegister = findViewById<Button>(R.id.register_button)
        btnRegister.setOnClickListener{
            val username = edit_uname.text.toString()
            val password = edit_pword.text.toString()
            val email = edit_email.text.toString()
            val phone = edit_pnumber.text.toString()


            val sharePreference = getSharedPreferences(objectClass.sharedPref_tag, MODE_PRIVATE)
            val editor = sharePreference.edit()
            editor.putString("USERNAME", username)
            editor.putString("PASSWORD", password)
            editor.putString("EMAIL", email)
            editor.putString("PHONE", phone)
            editor.apply()
            Log.d(TAG, "You are tapping to Login Activity")

            toast_Message(this@RegisterActivity, "User Registered", Toast.LENGTH_SHORT)
           // Toast.makeText(this@RegisterActivity, "User Registered", Toast.LENGTH_SHORT).show()
            goToActivity(this@RegisterActivity, LoginActivity::class.java)
           // val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
           // startActivity(intent)
        }
        var btnCancel = findViewById<Button>(R.id.cancel_button)
        btnCancel.setOnClickListener{
            Log.d(TAG, "You are in register and cancelling text")
            emptyFields()
            goToActivity(this@RegisterActivity, LoginActivity::class.java)
        }
    }

fun emptyFields(){
    edit_uname.setText("")
    edit_pword.setText("")
    edit_email.setText("")
    edit_pnumber.setText("")
}
}