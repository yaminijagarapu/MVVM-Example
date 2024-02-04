package com.example.helloworld.viewmodel

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.data.db.entities.Users
import com.example.helloworld.databinding.LayoutUserItemBinding

class UserAdapter: RecyclerView.Adapter<UserViewHolder>() {
    var userList = mutableListOf<Users>()
    val TAG ="UserAdapter"
    fun setUsers( userList: List<Users>){
        this.userList = userList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutUserItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.idTvName.text = "Name: "+ user.name
        holder.binding.idTvEmail.text = "Name: "+ user.email
        Log.d(TAG, "The users "+ user+ "is at position "+ position)

    }


}
class UserViewHolder (val binding: LayoutUserItemBinding): RecyclerView.ViewHolder(binding.root)