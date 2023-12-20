package com.coderbdk.appbasic.ui.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by MD. ABDULLAH on Wed, Dec 20, 2023.
 */

@Preview
@Composable
fun QuickGuide(){
    var visible by remember {
        mutableStateOf(true)
    }

    // Animated visibility will eventually remove the item from the composition once the animation has finished.
    AnimatedVisibility(visible) {
        Button(onClick = { }) {
            visible = false
        }
    }

    val animatedAlpha by animateFloatAsState(
        targetValue = if (visible) 1.0f else 0f,
        label = "alpha"
    )
    Box(
        modifier = Modifier
            .size(200.dp)
            .graphicsLayer {
                alpha = animatedAlpha
            }
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Green)

    ) {
    }
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 8f,
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
        label = "scale"
    )
    Box(modifier = Modifier.size(100.dp)) {
        Text(
            text = "Hello",
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    transformOrigin = TransformOrigin.Center
                }
                .align(Alignment.Center),
            // Text composable does not take TextMotion as a parameter.
            // Provide it via style argument but make sure that we are copying from current theme
            style = LocalTextStyle.current.copy(textMotion = TextMotion.Animated)
        )
    }

    var state by remember {
        mutableStateOf(UiState.Loading)
    }
    AnimatedContent(
        state,
        transitionSpec = {
            fadeIn(
                animationSpec = tween(3000)
            ) togetherWith fadeOut(animationSpec = tween(3000))
        },
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            state = when (state) {
                UiState.Loading -> UiState.Loaded
                UiState.Loaded -> UiState.Error
                UiState.Error -> UiState.Loading
            }
        },
        label = "Animated Content"
    ) { targetState ->
        when (targetState) {
            UiState.Loading -> {
               Text(text = "Loading...")
            }
            UiState.Loaded -> {
                Text(text = "Loaded")
            }
            UiState.Error -> {
                Text(text = "Error")
            }
        }
    }


}

enum class UiState{
    Loading,
    Loaded,
    Error
}