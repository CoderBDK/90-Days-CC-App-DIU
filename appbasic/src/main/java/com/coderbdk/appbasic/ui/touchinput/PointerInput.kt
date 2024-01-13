package com.coderbdk.appbasic.ui.touchinput

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by MD. ABDULLAH on Thu, Jan 11, 2024.
 */

@Preview
@Composable
fun PointerInput() {
   Column(
        Modifier.fillMaxSize()
    ) {
        SimpleClickable {

        }

        var log by remember { mutableStateOf("") }
        Column {
            Text(log)
            Box(
                Modifier
                    .size(100.dp)
                    .background(Color.Red)
                    .pointerInput(Unit) {
                        detectTapGestures { log = "Tap!" }
                    }
                    .pointerInput(Unit) {
                        // These drag events will correctly be triggered
                        detectDragGestures { _, _ -> log = "Dragging" }
                    }
            )
        }
    }
}

@Composable
private fun SimpleClickable(onClick: () -> Unit) {
    var value by remember {
        mutableStateOf(false)
    }
    Box(
        Modifier
            .size(100.dp)
            .pointerInput(onClick) {
                awaitEachGesture {
                    awaitFirstDown().also { it.consume() }
                    val up = waitForUpOrCancellation()
                    if (up != null) {
                        up.consume()
                        onClick()
                        value = !value
                    }
                }
            }
    ) {
        Text(text = "$value -> Hello")
    }
}