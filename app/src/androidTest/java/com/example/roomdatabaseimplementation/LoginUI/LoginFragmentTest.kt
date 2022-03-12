package com.example.roomdatabaseimplementation.LoginUI

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.accessibility.AccessibilityChecks
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.roomdatabaseimplementation.R
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginFragmentTest
{

//    init{
//
//        AccessibilityChecks.enable().setRunChecksFromRootView(true)
//    }

        @Test
        fun checkIfLoginFragmentIsVisible() {

            val scenario = launchFragmentInContainer<LoginFragment>()

            onView(withId(R.id.login))
                .check(matches(isDisplayed()))
        }

        @Test
        fun checkIfAllTheWidgetsAreVisible() {

            val scenario = launchFragmentInContainer<LoginFragment>()

            onView(withId(R.id.tvHello)).check(matches(isDisplayed()))
            onView(withId(R.id.tvSignInAccount)).check(matches(isDisplayed()))
            onView(withId(R.id.etLoginEmail)).check(matches(isDisplayed()))
            onView(withId(R.id.etLoginPassword)).check(matches(isDisplayed()))
            onView(withId(R.id.tvForgotYourPassword)).check(matches(isDisplayed()))
            onView(withId(R.id.tvSignin)).check(matches(isDisplayed()))
//        onView(withId(R.id.ivForwardArrow)).check(matches(isDisplayed()))
            onView(withId(R.id.tvDontHaveAnAccount)).check(matches(isDisplayed()))

        }

        @Test
        fun checkIfAllTheTextsInWidgetsAreCorrect() {

            val scenario = launchFragmentInContainer<LoginFragment>()

            //Create Variables here

            onView(withId(R.id.tvHello)).check(matches(withText(R.string.hello)))
            onView(withId(R.id.tvSignInAccount)).check(matches(withText(R.string.sign_in_to_your_account)))
            onView(withId(R.id.etLoginEmail)).check(matches(withHint(R.string.e_mail)))
            onView(withId(R.id.etLoginPassword)).check(matches(withHint(R.string.password)))
            onView(withId(R.id.tvForgotYourPassword)).check(matches(withText(R.string.forgot_your_password)))
            onView(withId(R.id.tvSignin)).check(matches(withText(R.string.sign_in)))
//        onView(withId(R.id.ivForwardArrow)).check(matches(withDrawable()))
            onView(withId(R.id.tvDontHaveAnAccount)).check(matches(withText(R.string.don_t_have_an_account_create)))

        }


}
