package com.example.roomdatabaseimplementation.RegistartionUI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.roomdatabaseimplementation.LoginUI.LoginFragment
import com.example.roomdatabaseimplementation.R
import com.example.roomdatabaseimplementation.UserDatabase
import com.example.roomdatabaseimplementation.UserEntity
import com.example.roomdatabaseimplementation.UserRepository
import com.example.roomdatabaseimplementation.databinding.FragmentRegistrationBinding


class RegistrationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentRegistrationBinding
    lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val view = binding.root

//        binding.ivBackArrowRegistrationScreen.setOnClickListener{
//            Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment)
//        }

        binding.ivBackArrowRegistrationScreen.setOnClickListener{
            val loginFragment = LoginFragment()
            val transaction : FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,loginFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


        val dao = UserDatabase.getDatabase(requireContext()).userDao()
        val userRepository = UserRepository(dao)

        registrationViewModel = ViewModelProvider(this,RegistrationViewModelFactory(userRepository))[RegistrationViewModel::class.java]

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tvCreate.setOnClickListener{

            val userName = binding.etRegisterUserName.text.toString()
            val email = binding.etRegisterEmail.text.toString()
            val password = binding.etRegisterPassword.text.toString()
            val mobile = binding.etRegisterPhone.text.toString()


            val user = UserEntity(0,userName,email,password,mobile)
            registrationViewModel.insertUser(user)

//            Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment)

            val loginFragment = LoginFragment()
            val transaction : FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,loginFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }
}