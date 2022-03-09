package com.example.roomdatabaseimplementation

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "UserTable")
data class UserEntity
    (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val username : String,
    val email : String,
    val password : String,
    val mobile : String
            )