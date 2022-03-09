package com.example.roomdatabaseimplementation.RegistartionUI

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabaseimplementation.UserEntity
import com.example.roomdatabaseimplementation.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun getAllUsers() : LiveData<List<UserEntity>>{
        return userRepository.getAllUsers()
    }

     fun insertUser (userEntity: UserEntity) {
         viewModelScope.launch(Dispatchers.IO) {
             userRepository.insertUser(userEntity)
     }
    }

     fun deleteUser (userEntity: UserEntity) {
         viewModelScope.launch(Dispatchers.IO)
         {
             userRepository.deleteUser(userEntity)
         }
     }

}