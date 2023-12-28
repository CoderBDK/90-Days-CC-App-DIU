package com.coderbdk.appbasic.ui.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateRect
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
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

        var currentState by remember { mutableStateOf(BoxState.Collapsed) }
        val transition = updateTransition(currentState, label = "box state")
        val rect by transition.animateRect(label = "rectangle") { state ->
            when (state) {
                BoxState.Collapsed -> Rect(0f, 0f, 100f, 100f)
                BoxState.Expanded -> Rect(100f, 100f, 300f, 300f)
            }
        }
        val borderWidth by transition.animateDp(label = "border width") { state ->
            when (state) {
                BoxState.Collapsed -> 1.dp
                BoxState.Expanded -> 0.dp
            }
        }

        val color by transition.animateColor(
            transitionSpec = {
                when {
                    BoxState.Expanded isTransitioningTo BoxState.Collapsed ->
                        spring(stiffness = 50f)
                    else ->
                        tween(durationMillis = 500)
                }
            }, label = "color"
        ) { state ->
            when (state) {
                BoxState.Collapsed -> MaterialTheme.colorScheme.primary
                BoxState.Expanded -> MaterialTheme.colorScheme.background
            }
        }

        Box(
            Modifier
                .size(100.dp)
                .background(color)
                .border(width = borderWidth,
                    brush = Brush.linearGradient(
                        listOf(
                            Color.Red,
                            Color.Blue
                        )
                    ), shape = RoundedCornerShape(10.dp)
                )
        ) {

        }
        Button(onClick = {
            currentState = BoxState.Expanded
        }) {

        }
    }
}

enum class BoxState {
    Collapsed,
    Expanded
}
