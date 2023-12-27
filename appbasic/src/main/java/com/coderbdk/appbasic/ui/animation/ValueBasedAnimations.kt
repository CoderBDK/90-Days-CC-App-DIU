package com.coderbdk.appbasic.ui.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by MD. ABDULLAH on Wed, Dec 27, 2023.
 */

@Preview
@Composable
fun ValueBasedAnimation() {
    var enable by remember {
        mutableStateOf(true)
    }
    val alpha: Float by animateFloatAsState(
        targetValue = if (enable) 0.1f else 1f, label = "animate float",
        animationSpec = tween(durationMillis = 1000)
    )
    Column {
        Box(
            modifier = Modifier
                .size(100.dp)
                .graphicsLayer(alpha = alpha)
                .background(Color.Red)
        ) {

        }
        Button(onClick = { enable = !enable }) {
            
        }
    }
}