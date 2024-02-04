package com.example.helloworld.viewmodel

import androidx.lifecycle.LiveData
import com.example.helloworld.data.db.entities.Users

interface UserDataListener {
    fun onStarted()

    fun onFailure(data: String)

    fun onSuccess(data: LiveData<List<Users>>)
}
