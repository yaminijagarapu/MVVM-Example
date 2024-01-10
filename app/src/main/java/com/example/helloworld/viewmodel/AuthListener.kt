package com.example.helloworld.viewmodel

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message:String)
}