package com.example.helloworld.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(var name: String? = null,
                 var username: String? = null,
                 var phone: String? = null,
                 var email: String? = null,
                 var website: String? = null)
{
    @PrimaryKey(autoGenerate = false)
    var id: Int? = null
}
