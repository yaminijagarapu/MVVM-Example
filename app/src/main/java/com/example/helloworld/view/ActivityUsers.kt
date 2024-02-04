package com.example.helloworld.view

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.databinding.adapters.LinearLayoutBindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.helloworld.data.db.AppDatabase
import com.example.helloworld.data.db.entities.Users
import com.example.helloworld.data.network.MyApi
import com.example.helloworld.data.repository.UserRepository
import com.example.helloworld.databinding.LayoutUsersBinding
import com.example.helloworld.viewmodel.UserAdapter
import com.example.helloworld.viewmodel.UserDataListener
import com.example.helloworld.viewmodel.UserViewModel

class ActivityUsers: ComponentActivity(), UserDataListener {

    private val TAG = "ActivityUsers"
    private lateinit var mUserBinding : LayoutUsersBinding
    private lateinit var mUserViewModel: UserViewModel
    val adpater= UserAdapter()
    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = AppDatabase(this)
        val api = MyApi()
        val repository = UserRepository(api, db )
        val factory = UserViewModelFactory(repository)

        mUserBinding = LayoutUsersBinding.inflate(layoutInflater)
        setContentView(mUserBinding.root)
        mUserViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        mUserBinding.userviewmodel = mUserViewModel
        mUserViewModel.userDataListener = this
        mUserBinding.recycleview.adapter = adpater
        val lm = LinearLayoutManager(this)
        lm.orientation= LinearLayoutManager.VERTICAL
        mUserBinding.recycleview.layoutManager = lm
    //   val gm = GridLayoutManager(this, 2)
     //   mUserBinding.recycleview.layoutManager = gm

    }

    override fun onStarted() {
        Log.d(TAG, "onStarted")
    }

    override fun onFailure(data: String) {
        Log.d(TAG, "onFailure" + data)
    }

    override fun onSuccess(data: LiveData<List<Users>>) {
        Log.d(TAG, "onSuccess" + data)
        data.observe(this, Observer {
            Log.d(TAG, "OnSuccess Loaded--" +data)
            adpater.setUsers(it)

          //  db.getusersDao().upsert(it)
        })
    }

}
