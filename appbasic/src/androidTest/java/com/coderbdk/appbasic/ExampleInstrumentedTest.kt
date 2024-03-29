package com.coderbdk.appbasic

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.compose.ui.unit.dp
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.coderbdk.appbasic.ui.theme.AppTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.coderbdk.appbasic.test", appContext.packageName)

    }

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testAnimationWithClock() {
        // Pause animations
        rule.mainClock.autoAdvance = false
        var enabled by mutableStateOf(false)
        rule.setContent {
            val color by animateColorAsState(
                targetValue = if (enabled) Color.Red else Color.Green,
                animationSpec = tween(durationMillis = 250), label = ""
            )
            Box(
                Modifier
                    .size(64.dp)
                    .background(color))
        }

        // Initiate the animation.
        enabled = true

        // Let the animation proceed.
        rule.mainClock.advanceTimeBy(50L)

        // Compare the result with the image showing the expected result.
        // `assertAgainGolden` needs to be implemented in your code.
        rule.onRoot().captureToImage()
    }

    private fun ImageBitmap.assertAgainstGolden(){

    }

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun MyTest() {
        // Start the app
        composeTestRule.setContent {
            AppTheme {
                Text("Hello world!")
            }
        }
        // Log the full semantics tree
        composeTestRule.onRoot().printToLog("MY TAG")

        val mySwitch = SemanticsMatcher.expectValue(
            SemanticsProperties.Role, Role.Switch
        )
        composeTestRule.onNode(mySwitch)
            .performClick()
            .assertIsOff()
    }
}