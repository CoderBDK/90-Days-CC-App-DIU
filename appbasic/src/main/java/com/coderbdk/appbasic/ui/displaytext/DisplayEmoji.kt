package com.coderbdk.appbasic.ui.displaytext

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.EmojiSupportMatch
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun  DisplayEmoji(){
    Column {
        Text(
            text = "Hello 🫠 Garlic \uD83E\uDDC4",
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    emojiSupportMatch = EmojiSupportMatch.None
                )
            )
        )
    }
}