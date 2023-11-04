package com.coderbdk.appbasic.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coderbdk.appbasic.R

@Composable
fun Modifiers() {
    // Greeting(name = "World!")
    MatchParentSizeComposable()
}

@Composable
fun MatchParentSizeComposable() {
    Box {
        Spacer(
            Modifier
                .matchParentSize()
                .clip(CircleShape)
                .align(Alignment.Center)
                .align(Alignment.CenterEnd)
                .background(Color.LightGray)
        )
        ArtistCardModifier()
    }
}


@Composable
fun ArtistCardModifier(/*...*/) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            /*...*/
            modifier = Modifier.weight(2f),
            contentDescription = "",
            painter = painterResource(id = R.drawable.ic_android_black_24dp)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            /*...*/
        }
    }
}

@Composable
private fun Greeting(name: String) {
    Column(
        modifier = Modifier
            .background(Color.Green)
            .paddingFromBaseline(bottom = 100.dp)
            .background(Color.Yellow)
            .fillMaxWidth()
            .padding(124.dp)

            .background(Color.Red)
    ) {
        Text(text = "Helldo,")
        Text(text = name)
    }
}
