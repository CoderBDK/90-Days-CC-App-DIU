package com.coderbdk.appbasic.ui.touchinput

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by MD. ABDULLAH on Wed, Jan 24, 2024.
 */

@Composable
@Preview
fun HandlingInteraction() {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = { /* do something */ },
        interactionSource = interactionSource) {
        Text(if (isPressed) "Pressed!" else "Not pressed")
    }
}