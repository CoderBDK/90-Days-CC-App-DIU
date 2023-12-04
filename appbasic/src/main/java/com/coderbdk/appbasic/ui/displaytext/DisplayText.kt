package com.coderbdk.appbasic.ui.displaytext

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderbdk.appbasic.R

@Preview
@Composable
fun DisplayTextPreview(){
   Column(
       Modifier.background(Color(0xFF134A6B)).padding(8.dp)
   ) {
       Text("Hello World")
       Text(stringResource(R.string.compose))

       // Bold text
       Text("Hello World", fontWeight = FontWeight.Bold)
       // text shadow
       val offset = Offset(2.0f, 1.1f)
       Text(
           text = "Hello world!",
           style = TextStyle(
               fontSize = 24.sp,
               shadow = Shadow(
                   color = Color.White, offset = offset, blurRadius = 1f
               )
           )

       )

       // To set different styles within the same Text composable
       Text(
           buildAnnotatedString {
               withStyle(style = SpanStyle(color = Color.Blue)) {
                   append("H")
               }
               append("ello ")

               withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                   append("W")
               }
               append("orld")
               withStyle(style = SpanStyle(
                   fontSize = 24.sp,
                   shadow = Shadow(
                       color = Color.White, offset = offset, blurRadius = 1f
                   )
               )
               ){
                   append("Compose")
               }
           }
       )
       val gradientColors = listOf(Cyan,Color.LightGray, Green)

       Text(
           text = "Hello vai shab",
           style = TextStyle(
               brush = Brush.linearGradient(
                   colors = gradientColors
               )
           )
       )

       val rainbowColors = listOf(
           Red,
           Cyan,
           LightGray,
           Magenta,
           Green

       )
       val brush = Brush.linearGradient(colors = rainbowColors)
       Text(
           buildAnnotatedString {
               withStyle(
                   SpanStyle(
                       brush = brush, alpha = .5f
                   )
               ) {
                   append("Text in ")
               }
               withStyle(
                   SpanStyle(
                       brush = brush, alpha = 1f
                   )
               ) {
                   append("Compose ❤️")
               }
           }
       )
   }
}