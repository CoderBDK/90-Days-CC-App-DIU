package com.coderbdk.appbasic.ui.animation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Column(
        Modifier.fillMaxSize()
    ) {
        Button(
            modifier = Modifier
                .offset(x = (value * 100).dp), onClick = {
                isAnimate = true
            }) {

        }
    }

}