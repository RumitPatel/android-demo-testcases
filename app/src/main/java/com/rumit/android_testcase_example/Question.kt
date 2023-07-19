package com.rumit.android_testcase_example

data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer: Int
)
