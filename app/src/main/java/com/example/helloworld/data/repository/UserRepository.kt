package com.example.helloworld.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.helloworld.data.db.AppDatabase
import com.example.helloworld.data.db.entities.Users
import com.example.helloworld.data.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository (
    private val api: MyApi,
    private val db: AppDatabase
    ){
    private var TAG = "UserRepository"

    fun UserRepos(): LiveData<List<Users>> {
        Log.d(TAG,"UserRepos")

        val responseUsersList = MutableLiveData<List<Users>>()

        api.getUsers()
            .enqueue(object : Callback<List<Users>> {
                override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                    Log.d(TAG, "OnResponse -> Body "+ response.body())
                    responseUsersList.value = response.body()
                    Log.d(TAG, "OnResponse Store Data ")
                  //  db.getusersDao().upsert(response.body()!!)
                }

                override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                    Log.d(TAG, "onFailure  "+ t.message)
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