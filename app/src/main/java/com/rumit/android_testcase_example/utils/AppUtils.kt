package com.rumit.android_testcase_example.utils

import android.content.Context
import android.content.Intent

fun isValidNameValue(nameValue: String?): Boolean {
    return !(nameValue.isNullOrEmpty() || nameValue.length !in 6..15)
}

fun reverseString(inputValue: String?): String {
    if (inputValue == null) {
        throw IllegalArgumentException("Input String should not be null")
    }
//      return inputValue.reversed()

    val char = inputValue.toCharArray()
    var i = 0
    var j = char.size - 1

    while (i < j) {
        val temp = char[i]
        char[i] = char[j]
        char[j] = temp
        i++
        j--
    }

    return char.joinToString("")
}

fun Context.shareText(text: String?) {
    val intent = Intent(Intent.ACTION_SEND);
    intent.type = "text/plain";
    intent.putExtra(Intent.EXTRA_TEXT, text);
    intent.putExtra(Intent.EXTRA_SUBJECT, "This is my subject")
    this.startActivity(Intent.createChooser(intent, "Share"));
}