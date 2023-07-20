package com.rumit.android_testcase_example.robots

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import com.rumit.android_testcase_example.R
import org.hamcrest.core.AllOf

fun resultActivityScope(func: ResultRobot.() -> Unit) =
    ResultRobot().apply { func() }

class ResultRobot : BaseTestRobot() {

    fun isOnResultScreen() {
        viewWithIdIsDisplayed(R.id.tv_result)
    }

    fun nameIsShown(name: String) {
        textIsDisplayed(name)
    }

    fun resultIsXOutOfTen(result: Int) {
        val text = "Your score is $result out of 10"
        textIsDisplayed(text)
    }

    fun clickOnShareScore() {
        Intents.init()
        val expected = AllOf.allOf(IntentMatchers.hasAction(Intent.ACTION_SEND))
        Espresso.onView(ViewMatchers.withId(R.id.btnShareScore)).perform(ViewActions.click())
        //TODO Need to check if opened intent is opened with ACTION_SEND
        /*intended(expected)
        Intents.release()*/
    }
}