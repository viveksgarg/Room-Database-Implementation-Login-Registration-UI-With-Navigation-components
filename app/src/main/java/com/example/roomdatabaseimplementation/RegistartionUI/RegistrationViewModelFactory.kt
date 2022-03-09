package com.example.roomdatabaseimplementation.RegistartionUI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabaseimplementation.UserRepository

class RegistrationViewModelFactory (private val userRepository: UserRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegistrationViewModel(userRepository) as T
    }

}