package com.example.roomdatabaseimplementation

import android.view.View
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.accessibility.AccessibilityChecks
import androidx.test.espresso.action.ScrollToAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.roomdatabaseimplementation.LoginUI.LoginFragment
import com.example.roomdatabaseimplementation.RegistartionUI.RegistrationFragment
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class NavigationTest {

    private val fakeUsername = "chike"
    private val fakePassword = "password"

    private val name ="vivek"
    private val realUsername = "v@g"
    private val realPassword = "as"
    private val phone ="890"

//    companion object {
//        @BeforeClass
//        @JvmStatic
//        fun enableAccessibilityChecks() {
//            AccessibilityChecks.enable().setRunChecksFromRootView(true)
//        }
//    }

    @Test
    fun testNavigationOfLoginFragmentAndRegisterFragment(){

        //Setup
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        //PerformTheClick
        onView(withId(R.id.tvDontHaveAnAccount))
            .perform(click())

        //CheckIfNavigatedToRegisterFragment
        onView(withId(R.id.registration)).check(matches(isDisplayed()))

        //perform
        pressBack()

        onView(withId(R.id.main)).check(matches(isDisplayed()))



    }

    @Test
    fun checkIfUserRegistrationIsWorking(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        //PerformTheClick
        onView(withId(R.id.tvDontHaveAnAccount))
            .perform(click())

        //CheckIfNavigatedToRegisterFragment
        onView(withId(R.id.registration)).check(matches(isDisplayed()))


        //TypeFakeLoginCredentials
        onView(withId(R.id.etRegisterUserName)).perform(ViewActions.typeText(name))
        onView(withId(R.id.etRegisterEmail)).perform(ViewActions.typeText(realUsername))
        onView(withId(R.id.etRegisterPassword)).perform(ViewActions.typeText(realPassword))
        onView(withId(R.id.etRegisterPhone)).perform(ViewActions.typeText(phone))


        //Create Account
        onView(withId(R.id.tvCreate))
            .perform(ViewActions.scrollTo(),click())

        //Verify

        onView(withId(R.id.main))
            .check(matches(isDisplayed()))


    }

    @Test
    fun checkIfLoginCredentialsAreVerifyingProperly(){

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//
        //verify
        onView(withId(R.id.login)).check(matches(isDisplayed()))

        //LoginCredentialsVerification

        //TypeFakeLoginCredentials
        onView(withId(R.id.etLoginEmail)).perform(ViewActions.typeText(fakeUsername))
        onView(withId(R.id.etLoginPassword)).perform(ViewActions.typeText(fakePassword))


        //TryToSignIn
        onView(withId(R.id.tvSignin))
            .perform(ViewActions.scrollTo(), click())

        //confirm Failure
        onView(withId(R.id.tvSuccessFailure))
            .check(matches(withText("Failure")))

        //TypeRealLoginCredentials
        onView(withId(R.id.etLoginEmail)).perform(ViewActions.clearText())
        onView(withId(R.id.etLoginPassword)).perform(ViewActions.clearText())

        //TypeRealLoginCredentials
        onView(withId(R.id.etLoginEmail)).perform(ViewActions.typeText(realUsername))
        onView(withId(R.id.etLoginPassword)).perform(ViewActions.typeText(realPassword))

        //TryToSignIn
        onView(withId(R.id.tvSignin))
            .perform(ViewActions.scrollTo(), ViewActions.click())

        //confirm Success
        onView(withId(R.id.tvSuccessFailure))
            .check(matches(withText("Success")))

    }



}