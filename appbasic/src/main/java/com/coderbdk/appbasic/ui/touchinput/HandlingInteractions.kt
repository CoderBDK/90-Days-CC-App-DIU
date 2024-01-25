package com.coderbdk.appbasic.ui.touchinput

import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by MD. ABDULLAH on Wed, Jan 24, 2024.
 */

@Composable
@Preview
fun HandlingInteraction() {
    // This InteractionSource will emit hover interactions
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = { /* do something */ },
        interactionSource = interactionSource) {
        Text(if (isPressed) "Pressed!" else "Not pressed")
    }


    Box(
        Modifier
            .size(100.dp)
            .hoverable(interactionSource = interactionSource),
        contentAlignment = Alignment.Center
    ) {
        Text("Hello!")
    }
}