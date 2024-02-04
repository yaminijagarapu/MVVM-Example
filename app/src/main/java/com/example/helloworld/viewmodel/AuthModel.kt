package com.example.helloworld.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.helloworld.data.repository.UserRepository

class AuthModel: ViewModel() {
    var username: String? = null
    var password: String? = null
    var authlistener: AuthListener? = null
    fun onLogin(view: View){
        Log.d("AuthModel","The activity Login username is " +username+ " and password is "+password)
      /*  if(username.isNullOrEmpty() || password.isNullOrEmpty()){
            authlistener?.onFailure("Values are empty")
            return
        }*/
       // val userResponse = UserRepository().UserRepos()
        //Success
        authlistener?.onSuccess()

    }

}