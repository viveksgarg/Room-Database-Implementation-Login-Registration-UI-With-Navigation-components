package com.example.roomdatabaseimplementation

import com.example.roomdatabaseimplementation.LoginUI.LoginFragmentTest
import com.example.roomdatabaseimplementation.RegistartionUI.RegistrationFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    LoginFragmentTest::class,
    NavigationTest::class,
    RegistrationFragmentTest::class
)
class TestSuite