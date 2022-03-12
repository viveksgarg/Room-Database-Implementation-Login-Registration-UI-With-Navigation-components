package com.example.roomdatabaseimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import com.example.roomdatabaseimplementation.LoginUI.LoginFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.commit {
            // Instantiate a new instance before adding
            val loginFragment = LoginFragment()
            add(R.id.fragmentContainer, loginFragment)
            setReorderingAllowed(true)
        }
    }
}