package com.rumit.android_testcase_example.screenTests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.rumit.android_testcase_example.QuizQuestionsActivity
import com.rumit.android_testcase_example.robots.quizQuestions
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QuizQuestionsScreenTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(QuizQuestionsActivity::class.java)

    @Test
    @LargeTest
    fun titleIsShown() {
        quizQuestions {
            isOnQuestionsScreen()
        }
    }

    @Test
    @LargeTest
    fun canAnswerQuestion() {
        quizQuestions {
            titleIsShown()
            selectAnswer(1)
            clickSubmit()
        }
    }
}