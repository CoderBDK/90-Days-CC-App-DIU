package com.coderbdk.appbasic.ui.touchinput

import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by MD. ABDULLAH on Wed, Jan 24, 2024.
 */

@Composable
@Preview
fun HandlingInteraction() {
    /*
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
    } */

    Column {
        Focusable()
        HldInteraction()
    }

}

@Composable
fun HldInteraction() {
    val interactionSource = remember { MutableInteractionSource() }
    val interactions = remember { mutableStateListOf<Interaction>() }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> {
                    interactions.add(interaction)
                }
                is DragInteraction.Start -> {
                    interactions.add(interaction)
                }
            }
        }
    }

    when (interactions.lastOrNull()) {
        is DragInteraction.Start -> {
            Text(text = "Dragged")
        }
        is PressInteraction.Press -> {
            Text(text = "Pressed")
        }
        is PressInteraction.Cancel -> {
            Text(text = "Cancel")
        }
        is PressInteraction.Release -> {
            Text(text = "Release")
        }
        else -> "No state"
    }

    val isPressed by interactionSource.collectIsPressedAsState()

    Button(onClick = { /* do something */ }, interactionSource = interactionSource) {
        Text(if (isPressed) "Pressed!" else "Not pressed")
    }
    
}

@Composable
fun Focusable() {
    // This InteractionSource will emit hover, focus, and press interactions
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        Modifier
            .size(100.dp)
            .clickable(
                onClick = {},
                interactionSource = interactionSource,

                // Also show a ripple effect
                indication = rememberRipple(
                    color = Color.Green,
                    radius = 40.dp
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Text("Hello!")
    }
}
