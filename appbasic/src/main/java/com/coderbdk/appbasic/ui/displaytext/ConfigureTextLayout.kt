package com.coderbdk.appbasic.ui.displaytext

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ConfigureTextLayout(){
    Column {
        LongText()
        OverflowedText(color = Color.Blue)
        OverflowedText(5, color = Color.Red)
    }
}

@Composable
fun LongText() {
    Text("hello ".repeat(50), maxLines = 2)
}
@Composable
fun OverflowedText(maxLines: Int = 2, color: Color) {
    Text("Hello Compose ".repeat(50), maxLines = maxLines, overflow = TextOverflow.Ellipsis, color = color)
}