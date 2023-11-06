package com.coderbdk.appbasic.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConstraintsModifier(){
   Button(
       onClick = {},
        modifier = Modifier
            .padding(10.dp)
            .background(Color.Gray)
            .size(DpSize(100.dp, 120.dp))
            .requiredSize(100.dp)
            .sizeIn(
                minWidth = 300.dp,
                maxWidth = 200.dp,
                minHeight = 200.dp,
                maxHeight = 455.dp
            )

    ){

   }
    Button(
        onClick = {},
        modifier = Modifier
            .padding(10.dp)
            .background(Color.Gray)
            .fillMaxWidth()
            .wrapContentSize()

    ){

    }
    Button(
        onClick = {},
        modifier = Modifier
            .padding(10.dp)
            .background(Color.Gray)
            .fillMaxWidth()
            .wrapContentSize()

    ){
        Text(text = "Hello", fontSize = 100.sp)
    }
    Button(
        onClick = {},
        modifier = Modifier
            .padding(10.dp)
            .background(Color.Gray)
            .fillMaxWidth()
            .wrapContentSize()

    ){

    }
}