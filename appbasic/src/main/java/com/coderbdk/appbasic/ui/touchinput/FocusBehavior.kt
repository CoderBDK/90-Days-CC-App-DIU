package com.coderbdk.appbasic.ui.touchinput

import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by MD. ABDULLAH on Mon, Jan 22, 2024.
 */

@Preview
@Composable
fun FocusBehaviour() {
    val chocolates = listOf(
        0,
        0,
        1
    )
    Column(
        Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(4)) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Row(modifier = Modifier.focusGroup()) {
                    FilterChipA()
                    FilterChipB()
                    FilterChipC()
                }
            }
            items(chocolates) {
                SweetsCard(sweets = it)
            }
        }

        var checked by remember { mutableStateOf(false) }

        Switch(
            checked = checked,
            onCheckedChange = { checked = it },
            // Prevent component from being focused
            modifier = Modifier
                .focusProperties { canFocus = false }
        )

        val focusRequester = remember { FocusRequester() }
        var text by remember { mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.focusRequester(focusRequester)
        )
        val textField = FocusRequester()

        TextField(
            value = text,
            onValueChange = {
                text = it

                if (it.length > 3) {
                    textField.captureFocus()
                } else {
                    textField.freeFocus()
                }
            },
            modifier = Modifier.focusRequester(textField)
        )
    }
}

@Composable
fun SweetsCard(sweets: Int) {
    Card(
        Modifier.fillMaxSize()
    ) {
        Text(text = "$sweets")
    }
}

@Composable
fun FilterChipC() {
    Text(text = "Chip")
}

@Composable
fun FilterChipB() {
    Text(text = "Chip")
}

@Composable
fun FilterChipA() {
    Text(text = "Chip")
}

