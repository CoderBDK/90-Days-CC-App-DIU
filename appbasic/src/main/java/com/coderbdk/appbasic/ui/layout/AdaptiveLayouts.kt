package com.coderbdk.appbasic.ui.layout

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AdaptiveLayouts(){
    AdaptivePane(showOnePane = true)
}
@Composable
fun AdaptivePane(
    showOnePane: Boolean,
) {
    if (showOnePane) {
        Column(
            Modifier.fillMaxSize()
        ) {
            OnePane()
            Card()
        }

    } else {
        TwoPane()
    }
}

@Composable
fun TwoPane() {

}

@Composable
fun OnePane() {
    Text(text = "hello, world")
}
@Composable
fun Card() {
    BoxWithConstraints(
        Modifier.fillMaxSize()
    ) {
        if (maxWidth < 400.dp) {
            Text(text = "400.dp > :: hello, world")
        } else {
            Text(text = "hello, world")
        }
    }
}
