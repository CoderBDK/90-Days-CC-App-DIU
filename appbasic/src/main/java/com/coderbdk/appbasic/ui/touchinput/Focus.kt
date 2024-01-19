package com.coderbdk.appbasic.ui.touchinput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by MD. ABDULLAH on Fri, Jan 19, 2024.
 */

@Preview
@Composable
fun Focus() {
    Column(
        Modifier.fillMaxSize()
    ) {
        Column {
            Row {
                TextButton({ }) { Text("First field") }
                TextButton({ }) { Text("Second field") }
            }
            Row {
                TextButton({ }) { Text("Third field") }
                TextButton({ }) { Text("Fourth field") }
            }
        }
        Row {
            Column {
                TextButton({ }) { Text("First field") }
                TextButton({ }) { Text("Second field") }
            }
            Column {
                TextButton({ }) { Text("Third field") }
                TextButton({ }) { Text("Fourth field") }
            }
        }
    }

}