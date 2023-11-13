package com.coderbdk.appbasic.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun ConstraintLayoutUI(){
    Column(
        Modifier.fillMaxSize()
    ) {
        //ConstraintLayoutContent2()
        AudioPlayerController()
    }

}

@Composable
fun AudioPlayerController() {
   ConstraintLayout(
       modifier = Modifier
           .fillMaxSize()
           .background(Color.White)
   ) {
       val (layout1,layout2) = createRefs()
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .constrainAs(layout1){
                   top.linkTo(parent.top)
               },
           horizontalArrangement = Arrangement.Center
       ) {
           Button(
               modifier = Modifier,
               onClick = { /*TODO*/ },
           ){
               Text(text = "00:20:00")
           }
           Button(
               modifier = Modifier,
               onClick = { /*TODO*/ }) {
               Text(text = "--------")
           }
           Button(
               modifier = Modifier,
               onClick = { /*TODO*/ },
           ){
               Text(text = "10:00:00")
           }
       }
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .constrainAs(layout2){
                   top.linkTo(layout1.bottom)
               },
          horizontalArrangement = Arrangement.Center
       ) {
           Button(
               modifier = Modifier,
               onClick = { /*TODO*/ },
           ){
               Text(text = "Prev")
           }
           Button(
               modifier = Modifier,
               onClick = { /*TODO*/ }) {
               Text(text = "Play")
           }
           Button(
               modifier = Modifier,
               onClick = { /*TODO*/ },
           ){
               Text(text = "Next")
           }
       }

   }
}


@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text(
            "Text",
            Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
            }
        )
    }
}

@Composable
fun ConstraintLayoutContent2() {
    ConstraintLayout {
        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text(
            "Text",
            Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
            }
        )
    }
}