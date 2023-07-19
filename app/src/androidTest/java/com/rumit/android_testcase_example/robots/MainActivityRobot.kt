package com.rumit.android_testcase_example.robots

import com.rumit.android_testcase_example.R

fun main(func: MainActivityRobot.() -> Unit) =
    MainActivityRobot().apply { func() }

class MainActivityRobot : BaseTestRobot() {

    fun titleIsShown() {
        viewWithIdIsDisplayed(R.id.tv_title)
    }

    fun enterName(name: String) {
        enterTextOnViewWithId(R.id.et_name, name)
    }

    fun pressStart() {
        clickViewWithId(R.id.btn_start)
    }
}