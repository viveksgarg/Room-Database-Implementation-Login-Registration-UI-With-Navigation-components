package com.example.roomdatabaseimplementation.LoginUI

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabaseimplementation.UserEntity
import com.example.roomdatabaseimplementation.UserRepository

class LoginViewModel (private val userRepository: UserRepository) : ViewModel() {

    fun readAllData(email: String, password: String): LiveData<UserEntity> {
        return  userRepository.readAllData(email, password)

    }


}