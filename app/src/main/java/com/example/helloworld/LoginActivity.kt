package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.helloworld.View.HomeActivity
import com.example.helloworld.View.RegisterActivity
import com.example.helloworld.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    val TAG = "LOGIN"
    val objectClass = Util()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding
        setContentView(R.layout.activity_login)
        var edit_userName = findViewById<EditText>(R.id.username_login)
        var edit_password = findViewById<EditText>(R.id.password_login)
        var btnLogin = findViewById<Button>(R.id.login_button)
        val btnSignup = findViewById<Button>(R.id.signup_button)
        Log.d(TAG, "You are in login activity")

        btnLogin.setOnClickListener{
            val sharePreference = getSharedPreferences(objectClass.sharedPref_tag, MODE_PRIVATE)
            val uname = sharePreference.getString("USERNAME", "")
            val pword = sharePreference.getString("PASSWORD", "")
            val username = edit_userName.text.toString()
            val password = edit_password.text.toString()

            if(username.length>1 || password.length>1){
                if(uname!!.equals(username) && pword!!.equals(password)){
                    goToActivity(this@LoginActivity, HomeActivity::class.java)
                    //val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    //startActivity(intent)
                }
                else if(!uname!!.equals(username) || !pword!!.equals(password)){
                    toast_Message(this@LoginActivity, "Register the User", Toast.LENGTH_SHORT)
                    //Toast.makeText(this@LoginActivity, "Register the User", Toast.LENGTH_SHORT).show()
                }

            }
            else {
                toast_Message(this@LoginActivity, "Please Enter Username and Password", Toast.LENGTH_SHORT)
                //Toast.makeText(this@LoginActivity, "Please Enter Username and Password", Toast.LENGTH_SHORT).show()
            }
        }
        btnSignup.setOnClickListener{
            Log.d(TAG, "You are in login activity going to register")
             goToActivity(this@LoginActivity, RegisterActivity::class.java)
          //  val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
         //   startActivity(intent)
        }
        //adb shell -s <SerialNumber> install <appname.apk>  --> installs apk onto the physical device
        //adb shell -s <SerialNumber> install <appname.apk>  --> installs apk onto the physical device

    }
}