package com.example.celciusfahrenheit

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class MainActivityTest() {

    @get:Rule
    val activityRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testFahrenheitToCelsiusConversion() {
        activityRule.onNodeWithText("Fahrenheit to Celsius").performClick()
        activityRule.onNodeWithText("Temperature").performTextInput("32")
        activityRule.onNodeWithText("0").assertExists()
    }

    @Test
    fun testCelsiusToFahrenheitConversion() {
        activityRule.onNodeWithText("Celsius to Fahrenheit").performClick()
        activityRule.onNodeWithText("Temperature").performTextInput("0")
        activityRule.onNodeWithText("32").assertExists()
    }

}