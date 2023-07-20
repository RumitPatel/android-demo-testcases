package com.rumit.android_testcase_example

import com.rumit.android_testcase_example.utils.isValidNameValue
import com.rumit.android_testcase_example.utils.reverseString
import org.junit.Test

import org.junit.Assert.*
import java.lang.IllegalArgumentException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testValidName_EmptyString() {
        val result = isValidNameValue("")
        assertEquals(false, result)
    }

    @Test
    fun testValidName_Rumit() {
        val result = isValidNameValue("RumitPatel")
        assertEquals(true, result)
    }

    @Test
    fun testStringReversal_EmptyString() {
        val result = reverseString("")
        assertEquals(result, "")
    }

    @Test
    fun testStringReversal_Rumit_expacted_timuR() {
        val result = reverseString("Rumit")
        assertEquals(result, "timuR")
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReversal_null_expacted_exception() {
        val result = reverseString(null)
    }
}