package com.example.helloworld.data.network

import com.example.helloworld.data.db.entities.Users
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {
    @GET("users")
   // fun getUsers(): Call<ResponseBody>
    fun getUsers(): Call<List<Users>>
    companion object {

        operator fun invoke() : MyApi{

            return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}