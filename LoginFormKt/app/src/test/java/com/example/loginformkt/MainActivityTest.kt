package com.example.loginformkt

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.loginformkt.MainActivity
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun displaysAllFields() {
        composeTestRule
            .onNodeWithText("Login")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Username")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Password")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Submit")
            .assertIsDisplayed()
    }

    @Test
    fun canEnterText() {
        composeTestRule
            .onNodeWithText("Username")
            .performTextInput("test@example.com")

        composeTestRule
            .onNodeWithText("Password")
            .performTextInput("password")

        composeTestRule
            .onNodeWithText("Submit")
            .performClick()
    }
}