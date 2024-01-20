package com.coderbdk.appbasic.ui.touchinput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by MD. ABDULLAH on Fri, Jan 19, 2024.
 */

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun Focus() {

    val (first, second, third, fourth) = remember { FocusRequester.createRefs() }

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

        Column {
            Row {
                TextButton({}, Modifier.focusRequester(first)) { Text("First field") }
                TextButton({}, Modifier.focusRequester(third)) { Text("Third field") }
            }

            Row {
                TextButton({}, Modifier.focusRequester(second)) { Text("Second field") }
                TextButton({}, Modifier.focusRequester(fourth)) { Text("Fourth field") }
            }

        }
        TextButton(
            onClick = {},
            modifier = Modifier
                .focusRequester(fourth)
                .focusProperties {
                    down = third
                    right = second
                }
        ) {}
    }

}