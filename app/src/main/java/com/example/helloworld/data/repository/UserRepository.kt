package com.example.helloworld.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.helloworld.data.Users
import com.example.helloworld.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun UserRepos(): LiveData<List<Users>> {
        //val responseUsersRepos = MutableLiveData<String>()

        val responseUsersList = MutableLiveData<List<Users>>()
        Log.d("User Repos 1 ", "User Repos")

        MyApi().getUsers()
            .enqueue(object : Callback<List<Users>> {
                override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                    Log.d("UserRepos 2", "OnResponse -> Message "+ response.raw())
                   // Log.d("UserRepos 4", "OnResponse -> Body "+ response.body()?.String())
                    Log.d("UserRepos 3", "OnResponse -> Body  "+ response.body())
                }

                override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                    Log.d("UserRepos 4", "onFailure  "+ t.message)
                }

            })

        return responseUsersList
        /*  MyApi().getUsers()
            .enqueue(object: Callback<ResponseBody>{
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful){
                        responseUsersRepos.value = response.body()?.toString()

                        Log.d("UserRepos 3", "OnResponse -> Message "+ response.raw())
                        Log.d("UserRepos 4", "OnResponse -> Body "+ response.body()?.string())
                        Log.d("UserRepos 5", "OnResponse -> Code  "+ response.code())
                    }
                    else {
                        responseUsersRepos.value = response.errorBody()?.toString()
                        Log.d("UserRepos 6", "Fail OnResponse "+ response)
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    responseUsersRepos.value = t.message
                    Log.d("UserRepos 7", "OnFailure  ")
                }

            })
     Log.d("UserRepository 2", "Final UserRepo "+ responseUsersRepos.toString())
        return responseUsersRepos

       */
    }

}