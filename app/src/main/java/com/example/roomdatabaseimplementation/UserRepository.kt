package com.example.roomdatabaseimplementation

import androidx.lifecycle.LiveData

class UserRepository (private val userDAO: UserDAO) {


    fun getAllUsers() : LiveData<List<UserEntity>>{
        return userDAO.getAllUsers()
    }

    suspend fun insertUser (userEntity: UserEntity){
        userDAO.insertUser(userEntity)
    }

    suspend fun deleteUser (userEntity: UserEntity){
        userDAO.deleteUser(userEntity)
    }

    fun readAllData(email: String, password: String) : LiveData<UserEntity> {

        return userDAO.readAllData(email, password)
    }
}