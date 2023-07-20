package com.rumit.android_testcase_example.screenTests

import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.rumit.android_testcase_example.MainActivity
import com.rumit.android_testcase_example.robots.mainActivityScope
import com.rumit.android_testcase_example.robots.quizActivityScope
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityScreenTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @LargeTest
    fun titleIsShown() {
        mainActivityScope {
            titleIsShown()
        }
    }

    @Test
    @LargeTest
    fun canEnterNameAndSeeNextScreen() {
        mainActivityScope {
            enterName("Robert")
            pressStart()
        }
        quizActivityScope {
            isOnQuestionsScreen()
        }
    }
}