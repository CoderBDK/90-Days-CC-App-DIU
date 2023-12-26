package com.coderbdk.appbasic.ui.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

/**
 * Created by MD. ABDULLAH on Thu, Dec 21, 2023.
 */

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun AnimationModifiers(){
    var visible by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    Column {

        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically {
                // Slide in from 40 dp from the top.
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                // Expand from the top.
                expandFrom = Alignment.Top
            ) + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            Text("Hello",
                Modifier
                    .fillMaxWidth()
                    .height(50.dp))
        }


        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            // Fade in/out the background and the foreground.
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.DarkGray)) {
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .animateEnterExit(
                            // Slide in/out the inner box.
                            enter = slideInVertically(),
                            exit = slideOutVertically()
                        )
                        .sizeIn(minWidth = 256.dp, minHeight = 64.dp)
                        .background(Color.Red)
                ) {
                    // Content of the notification…
                }
            }
        }
        // Create a MutableTransitionState<Boolean> for the AnimatedVisibility.
        val state = remember {
            MutableTransitionState(false).apply {
                // Start the animation immediately.
                targetState = true
            }
        }

        Column {
            AnimatedVisibility(visibleState = state) {
                Text(text = "Hello, world!")
            }

            // Use the MutableTransitionState to know the current animation state
            // of the AnimatedVisibility.
            Text(
                text = when {
                    state.isIdle && state.currentState -> "Visible"
                    !state.isIdle && state.currentState -> "Disappearing"
                    state.isIdle && !state.currentState -> "Invisible"
                    else -> "Appearing"
                }
            )
        }
        var visible by remember { mutableStateOf(false) }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) { // this: AnimatedVisibilityScope
            // Use AnimatedVisibilityScope#transition to add a custom animation
            // to the AnimatedVisibility.
            val background by transition.animateColor(label = "color") { state ->
                if (state == EnterExitState.Visible) Color.Blue else Color.Gray
            }
            Box(modifier = Modifier
                .size(128.dp)
                .background(background))
        }
        Button(onClick = {
            visible = true
        }) {

        }
        Row {
            var count by remember { mutableStateOf(0) }
            Button(onClick = { count++ }) {
                Text("Add")
            }
            AnimatedContent(targetState = count, label = "") { targetCount ->
                // Make sure to use `targetCount`, not `count`.
                Text(text = "Count: $targetCount")
            }
        }

        var expanded by remember { mutableStateOf(false) }
        Surface(
            color = MaterialTheme.colorScheme.primary,
            onClick = { expanded = !expanded }
        ) {
            AnimatedContent(
                targetState = expanded,
                transitionSpec = {
                    fadeIn(animationSpec = tween(150, 150)) with
                            fadeOut(animationSpec = tween(150)) using
                            SizeTransform { initialSize, targetSize ->
                                if (targetState) {
                                    keyframes {
                                        // Expand horizontally first.
                                        IntSize(targetSize.width, initialSize.height) at 150
                                        durationMillis = 300
                                    }
                                } else {
                                    keyframes {
                                        // Shrink vertically first.
                                        IntSize(initialSize.width, targetSize.height) at 150
                                        durationMillis = 300
                                    }
                                }
                            }
                }, label = ""
            ) { targetExpanded ->
                if (targetExpanded) {
                    Expanded()
                } else {
                    ContentIcon()
                }
            }
        }
        var count by remember {
            mutableIntStateOf(0)
        }
        IconButton(onClick = { count++}) {
            Icon(imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = "add")
        }
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                // Compare the incoming number with the previous number.
                if (targetState > initialState) {
                    // If the target number is larger, it slides up and fades in
                    // while the initial (smaller) number slides up and fades out.
                    (slideInVertically { height -> height } + fadeIn()).togetherWith(
                        slideOutVertically { height -> -height } + fadeOut())
                } else {
                    // If the target number is smaller, it slides down and fades in
                    // while the initial number slides down and fades out.
                    (slideInVertically { height -> -height } + fadeIn()).togetherWith(
                        slideOutVertically { height -> height } + fadeOut())
                }.using(
                    // Disable clipping since the faded slide-in/out should
                    // be displayed out of bounds.
                    SizeTransform(clip = false)
                )
            }, label = ""
        ) { targetCount ->

            Text(text = "$targetCount")


        }
        IconButton(onClick = { count-- }) {
            Icon(imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = "remove")
        }

        var currentPage by remember { mutableStateOf("A") }
        Crossfade(targetState = currentPage, label = "") { screen ->
            when (screen) {
                "A" -> Text("Page A")
                "B" -> Text("Page B")
            }
        }
        IconButton(onClick = { currentPage = "B" }) { Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "remove")

        }
    }
}

@Composable
fun ContentIcon() {
    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add" )
}

@Composable
fun Expanded() {
    Text(text = "this is expand text")
}
