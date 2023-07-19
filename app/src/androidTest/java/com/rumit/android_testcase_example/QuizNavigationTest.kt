package com.rumit.android_testcase_example

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rumit.android_testcase_example.robots.main
import com.rumit.android_testcase_example.robots.quizQuestions
import com.rumit.android_testcase_example.robots.result
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QuizNavigationTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun canNavigateAppToResults() {
        val name = "Rumit D Patel"
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
        }
    }
}