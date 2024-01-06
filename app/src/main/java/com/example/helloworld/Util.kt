package com.example.helloworld
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.EditText
import android.widget.Toast

class Util {
    val sharedPref_tag = "MY_PREF"

    }


fun editText_initialize(){
     lateinit var edit_uname: EditText
     lateinit var edit_pword: EditText
     lateinit var edit_email: EditText
     lateinit var edit_pnumber: EditText
}
fun Context.goToActivity(mcont: Activity, mcont2: Class<*>){
    val intent = Intent(mcont, mcont2)
    startActivity(intent)
}

fun toast_Message(activity: Activity, str: String,time: Int ){
 Toast.makeText(activity, str, time).show()
}

