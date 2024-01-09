package com.coderbdk.appbasic.ui.animation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by MD. ABDULLAH on Tue, Jan 02, 2024.
 */

@Preview
@Composable
fun CustomizeAnimation() {
    var isAnimate by remember {
        mutableStateOf(false)
    }

    val alpha by animateFloatAsState(
        targetValue = 0.5f,
        animationSpec = tween(durationMillis = 100, easing = FastOutSlowInEasing),
        label = "alpha"
    )
    val value by animateFloatAsState(
        targetValue = if (isAnimate) 1f else 0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessMedium
        ), label = "spring"
    )

    val value2 by animateFloatAsState(
        targetValue = if (isAnimate) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 50,
            easing = LinearOutSlowInEasing
        ), label = ""
    )

    val value3 by animateFloatAsState(
        targetValue = if (isAnimate) 1f else 0f,
        animationSpec = keyframes {
            durationMillis = 375
            0.0f at 100 using LinearOutSlowInEasing // for 0-15 ms
            0.2f at 15 using FastOutLinearInEasing // for 15-75 ms
            0.4f at 75 // ms
            0.4f at 225 // ms
            0.5f at 250 using LinearOutSlowInEasing
        }, label = "keyframes"
    )
    val value4 by animateFloatAsState(
        targetValue = if (isAnimate) 1f else 0f,
        animationSpec = repeatable(
            iterations = 3,
            animation = tween(durationMillis = 300),
            repeatMode = RepeatMode.Reverse
        ), label = "repeatable"
    )
    val value5 by animateFloatAsState(
        targetValue = if (isAnimate) 1f else 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 300),
            repeatMode = RepeatMode.Reverse
        ), label = "infinite"
    )
    val value6 by animateFloatAsState(
        targetValue = if (isAnimate) 1f else 0f,
        animationSpec = snap(delayMillis = 50), label = "snap"
    )
    val CustomEasing = Easing { fraction -> fraction * fraction}

    val value7 by animateFloatAsState(
        targetValue = if (isAnimate) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300,
            easing = CustomEasing
        ), label = ""
    )

    val value8: MySize by animateValueAsState(
        if(isAnimate) MySize(200.dp, 200.dp) else MySize(50.dp, 50.dp),
        animationSpec = tween(
            durationMillis = 2000,

        ),
       typeConverter =  TwoWayConverter(
            convertToVector = { size: MySize ->
                // Extract a float value from each of the `Dp` fields.
                AnimationVector2D(size.width.value, size.height.value)
            },
            convertFromVector = { vector: AnimationVector2D ->
                MySize(vector.v1.dp, vector.v2.dp)
            }
        ), label = ""
    )
    Column(
        Modifier.fillMaxSize()
    ) {
        Button(
            modifier = Modifier
                .size(value8.width, value8.height), onClick = {
                isAnimate = !isAnimate
            }) {

        }
    }



}

data class MySize(val width: Dp, val height: Dp)

