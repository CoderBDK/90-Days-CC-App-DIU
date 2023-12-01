package com.coderbdk.appbasic.ui.designsystems

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.coderbdk.appbasic.ui.theme.replyTypography

@Preview
@Composable
private fun DSTypography() {

    MaterialTheme(
        typography = replyTypography,
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
        }


    }
}
