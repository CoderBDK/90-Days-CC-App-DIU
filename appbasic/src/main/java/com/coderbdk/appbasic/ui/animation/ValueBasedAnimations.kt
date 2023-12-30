package com.coderbdk.appbasic.ui.animation

import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.VectorConverter
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
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
                .border(
                    width = borderWidth,
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

        // Start out gray and animate to green/red based on `ok`
        val color2 = remember { Animatable(Color.Gray) }
        val ok by remember {
            mutableStateOf(false)
        }
        LaunchedEffect(ok) {
            color2.animateTo(if (ok) Color.Green else Color.Red)
        }
        Box(
            Modifier
                .size(100.dp)
                .background(color2.value)){
            Button(onClick = {
                currentState = BoxState.Expanded
            }) {
                Text(text = "Click1")
            }
        }
        val anim = remember {
            TargetBasedAnimation(
                animationSpec = tween(200),
                typeConverter = Float.VectorConverter,
                initialValue = 200f,
                targetValue = 10000f
            )
        }
        var playTime by remember { mutableLongStateOf(0L) }
        var animateValue by remember {
            mutableFloatStateOf(0f)
        }
        LaunchedEffect(anim) {
            val startTime = withFrameNanos { it }

            do {
                playTime = withFrameNanos { it } - startTime
                animateValue = anim.getValueFromNanos(playTime)
            } while (someCustomCondition())
        }
        Text(text = "$animateValue")
    }
}

fun someCustomCondition(): Boolean {
    return false
}

enum class BoxState {
    Collapsed,
    Expanded
}
