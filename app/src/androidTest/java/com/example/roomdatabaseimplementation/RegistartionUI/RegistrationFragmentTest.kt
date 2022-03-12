package com.example.roomdatabaseimplementation.RegistartionUI

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.accessibility.AccessibilityChecks
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.roomdatabaseimplementation.ImageViewMatcher.Companion.withDrawable
import com.example.roomdatabaseimplementation.R
import org.junit.Assert.*
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class RegistrationFragmentTest
{

    //This is for enabling Accessibility Testing
//    companion object {
//        @BeforeClass
//        @JvmStatic
//        fun enableAccessibilityChecks() {
//            AccessibilityChecks.enable().setRunChecksFromRootView(true)
//
//        }
//    }


    @Test
    fun checkIfRegistrationFragmentIsVisible() {

        val scenario = launchFragmentInContainer<RegistrationFragment>()

        onView(withId(R.id.registration))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkIfWidgetsAreDisplayed(){
        val scenario = launchFragmentInContainer<RegistrationFragment>()

        onView(withId(R.id.ivBackArrowRegistrationScreen))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvCreateAccount))
            .check(matches(isDisplayed()))

        onView(withId(R.id.etRegisterUserName))
            .check(matches(isDisplayed()))

        onView(withId(R.id.etRegisterEmail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.etRegisterPassword))
            .check(matches(isDisplayed()))

        onView(withId(R.id.etRegisterPhone))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvCreate))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvCreateAccountWithSocials))
            .check(matches(isDisplayed()))

        onView(withId(R.id.ivGoogle))
            .check(matches(isDisplayed()))

        onView(withId(R.id.ivTwitter))
            .check(matches(isDisplayed()))

        onView(withId(R.id.ivFacebook))
            .check(matches(isDisplayed()))

    }

    @Test
    fun checkIfWidgetsDisplayWhatTheyAreSupposedToDisplay(){

        val scenario = launchFragmentInContainer<RegistrationFragment>()

        onView(withId(R.id.ivBackArrowRegistrationScreen))
            .check(matches(withDrawable(R.drawable.ic_arrow_back)))

        onView(withId(R.id.tvCreateAccount)).check(matches(withText(R.string.create_account)))

        onView(withId(R.id.etRegisterUserName)).check(matches(withHint(R.string.username)))
        onView(withId(R.id.etRegisterEmail)).check(matches(withHint(R.string.e_mail)))
        onView(withId(R.id.etRegisterPassword)).check(matches(withHint(R.string.password)))
        onView(withId(R.id.etRegisterPhone)).check(matches(withHint(R.string.phone_number)))

        onView(withId(R.id.tvCreate)).check(matches(withText(R.string.create)))
        onView(withId(R.id.tvCreateAccountWithSocials)).check(matches(withText(R.string.or_create_account_using_social_media)))

        onView(withId(R.id.ivGoogle))
            .check(matches(withDrawable(R.drawable.ic_google)))

        onView(withId(R.id.ivTwitter))
            .check(matches(withDrawable(R.drawable.ic_twitter)))

        onView(withId(R.id.ivFacebook))
            .check(matches(withDrawable(R.drawable.ic_facebook)))


    }
}