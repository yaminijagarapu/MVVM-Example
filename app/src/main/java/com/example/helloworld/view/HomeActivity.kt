package com.example.helloworld.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.helloworld.R
import com.example.helloworld.Util

class HomeActivity : AppCompatActivity() {
    private val TAG = "HomeActivity"
    val objectClass = Util()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val sharePreference = getSharedPreferences(objectClass.sharedPref_tag, MODE_PRIVATE)
        val uname = sharePreference.getString("USERNAME", "").toString()
        val pword = sharePreference.getString("PASSWORD", "").toString()
        val tvDisplayText = findViewById<TextView>(R.id.tvDisplay)
        tvDisplayText.text ="WELCOME to USER: $uname whose password is $pword"
        Log.d(TAG, "You are in Home Activity")
    }
}