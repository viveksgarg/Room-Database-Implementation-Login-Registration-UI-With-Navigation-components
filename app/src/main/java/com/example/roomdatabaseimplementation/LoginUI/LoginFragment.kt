package com.example.roomdatabaseimplementation.LoginUI

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.roomdatabaseimplementation.R
import com.example.roomdatabaseimplementation.RegistartionUI.RegistrationFragment
import com.example.roomdatabaseimplementation.UserDatabase
import com.example.roomdatabaseimplementation.UserRepository
import com.example.roomdatabaseimplementation.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    lateinit var loginViewModel: LoginViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val view = binding.root

//        binding.tvDontHaveAnAccount.setOnClickListener{
//            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registrationFragment)
//        }

        binding.tvDontHaveAnAccount.setOnClickListener{
            val registrationFragment = RegistrationFragment()
            val transaction : FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,registrationFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


        val dao = UserDatabase.getDatabase(requireContext()).userDao()
        val userRepository = UserRepository(dao)
        loginViewModel = ViewModelProvider(
            this,
            LoginViewModelFactory(userRepository)
        )[LoginViewModel::class.java]
        return view
    }
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSignin.setOnClickListener{

            val email = binding.etLoginEmail.text.toString()
            val password = binding.etLoginPassword.text.toString()

            loginViewModel.readAllData(email,password).observe(
                this.viewLifecycleOwner,
                Observer {
                    if (it == null) {
                        binding.tvSuccessFailure.text = getString(R.string.failure)
                        Toast.makeText(activity,"Failed",Toast.LENGTH_LONG).show()

//                        binding.tvSuccessFailure.text = ""
                    }
                    else {
                        binding.tvSuccessFailure.text = getString(R.string.success)

                        Log.d("Vivek","Valid")
                        Toast.makeText(activity,"Success",Toast.LENGTH_LONG).show()
//
//                        binding.tvSuccessFailure.text = ""


                    }
                }
            )
        }

    }

}