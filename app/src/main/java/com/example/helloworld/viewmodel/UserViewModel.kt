package com.example.helloworld.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.helloworld.data.repository.UserRepository

class UserViewModel(private val repository: UserRepository):ViewModel() {

    var TAG = "UserViewModel"
    var userDataListener: UserDataListener? = null
  //  val userList = MutableLiveData<List<Users>>()
  //  val errorMessage = MutableLiveData<String>()
    fun onLoadUsers(view: View) {
        Log.d(TAG, "OnLoad Users")
        val response = repository.UserRepos()
        Log.d(TAG, "OnLoad Users Completed")
        userDataListener?.onSuccess(response)
/*        MyApi().getUsers()
            .enqueue(object : Callback<List<Users>> {
                override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                    Log.d(TAG, "On Response Success:" + response)
                    userList.postValue(response.body())
                }

                override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                    Log.d(TAG, "onFailure" + t.message)
                    errorMessage.postValue(t.message)
                }

            })*/
    }
}