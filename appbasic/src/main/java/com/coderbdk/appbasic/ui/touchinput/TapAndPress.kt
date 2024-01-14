package com.coderbdk.appbasic.ui.touchinput

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by MD. ABDULLAH on Sun, Jan 14, 2024.
 */
@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun TapAndPress() {
    var color by remember {
        mutableStateOf(Color.Red)
    }
    Column(
        Modifier.fillMaxSize()
    ) {
        Box(
            Modifier
                .size(100.dp)
                .background(color)
                .combinedClickable(
                    onClick = {
                              color = Color.Red
                    },
                    onLongClick = {
                        color = Color.Green
                    })
        ) {

        }
    }
}