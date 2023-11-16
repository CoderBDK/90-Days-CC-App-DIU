package com.coderbdk.appbasic.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun ButtonPreview(){
    Column(
        Modifier.fillMaxSize()
    ) {
       FlowRow{
           Button(onClick = {  }) {
               Text("Filled")
           }
           FilledTonalButton(onClick = { }) {
               Text("Tonal")
           }
           OutlinedButton(onClick = {  }) {
               Text("Outlined")
           }
           ElevatedButton(onClick = { }) {
               Text("Elevated")
           }
           TextButton(
               onClick = {  }
           ) {
               Text("Text Button")
           }

       }

        Row {
            Button(onClick = {  }) {
                Text("Save")
            }
            Button(onClick = {  }) {
                Text("Submit")
            }
        }
        Row {
            FilledTonalButton(onClick = { }) {
                Text("Sign in")
            }
            FilledTonalButton(onClick = { }) {
                Text("Add to cart")
            }
        }
        Row {
            ElevatedButton(onClick = { }) {
                Text("Sign in")
            }
           ElevatedButton(onClick = { }) {
                Text("Add to cart")
            }
        }
        Row {
            OutlinedButton(onClick = { }) {
                Text("Cancel")
            }
            ElevatedButton(onClick = { }) {
                Text("Back")
            }
        }
        Row {
            TextButton(onClick = { }) {
                Text("Learn More")
            }
           TextButton(onClick = { }) {
                Text("View details")
            }
        }
    }

}
