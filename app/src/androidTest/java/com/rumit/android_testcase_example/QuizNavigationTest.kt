package com.rumit.android_testcase_example

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rumit.android_testcase_example.robots.main
import com.rumit.android_testcase_example.robots.quizQuestions
import com.rumit.android_testcase_example.robots.result
import org.hamcrest.core.AllOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QuizNavigationTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun canNavigateAppToResults() {
        val name = "Rumit D. Patel"
        main {
            titleIsShown()
            enterName(name)
            pressStart()
        }
        quizQuestions {
            isOnQuestionsScreen()
            answerAllCorrectly()
        }
        result {
            isOnResultScreen()
            nameIsShown(name)
            resultIsXOutOfTen(10)

            Intents.init()
            val expected = AllOf.allOf(IntentMatchers.hasAction(Intent.ACTION_SEND))
            Espresso.onView(ViewMatchers.withId(R.id.btnShareScore)).perform(ViewActions.click())
            Intents.intended(expected)
            Intents.release()
        }
    }
}