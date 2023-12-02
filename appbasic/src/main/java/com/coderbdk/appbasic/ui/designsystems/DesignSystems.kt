package com.coderbdk.appbasic.ui.designsystems

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.coderbdk.appbasic.ui.theme.replyShapes
import com.coderbdk.appbasic.ui.theme.replyTypography

@Preview
@Composable
private fun DSTypography() {

    MaterialTheme(
        typography = replyTypography,
        shapes = replyShapes
    ) {
        Column {
            Text(text = "Hello")
            Text(
                text = "Hello M3 theming",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "you are learning typography",
                style = MaterialTheme.typography.bodyMedium
            )
            ShapeUsage()
        }


    }
}

@Composable
fun ShapeUsage() {
    Card(shape = MaterialTheme.shapes.medium) {
        Text(text = "Hello")
    }
    FloatingActionButton(
        shape = MaterialTheme.shapes.large,
        onClick = {
        }
    ) {
       Text(text = "Hello")
    }
    Card(shape = RectangleShape) {  Text(text = "Hello") }
    Card(shape = CircleShape) {  Text(text = "Hello") }
}
