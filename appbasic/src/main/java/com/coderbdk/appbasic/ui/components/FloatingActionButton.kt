package com.coderbdk.appbasic.ui.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun FABPreview(){
   FlowRow {
       FloatingActionButton(
           onClick = { },
       ) {
           Icon(Icons.Filled.Add, "Floating action button.")
       }
       SmallFloatingActionButton(
           onClick = { },
           containerColor = MaterialTheme.colorScheme.secondaryContainer,
           contentColor = MaterialTheme.colorScheme.secondary
       ) {
           Icon(Icons.Filled.Add, "Small floating action button.")
       }

       LargeFloatingActionButton(
           onClick = {  },
           shape = CircleShape,
       ) {
           Icon(Icons.Filled.Add, "Large floating action button")
       }
       ExtendedFloatingActionButton(
           onClick = { },
           icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
           text = { Text(text = "Extended FAB") },
       )
   }
}