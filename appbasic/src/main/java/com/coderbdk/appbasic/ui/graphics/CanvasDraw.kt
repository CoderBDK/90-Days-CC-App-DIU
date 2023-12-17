package com.coderbdk.appbasic.ui.graphics

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun CanvasDraw(){
    Canvas(
        Modifier.fillMaxSize(),
        onDraw = {
            scale(scaleX = 0.8f, scaleY = 1.9f){
                drawCircle(
                    Color.Blue,
                )
            }

        }
    )
    Canvas(
        Modifier.fillMaxSize(),
        onDraw = {
            withTransform(
                {
                    rotate(10f)
                }
            ){
                scale(scaleX = 0.5f, scaleY = 1.2f){
                    drawCircle(
                        Color.Red,
                    )
                }
            }


        }
    )
}