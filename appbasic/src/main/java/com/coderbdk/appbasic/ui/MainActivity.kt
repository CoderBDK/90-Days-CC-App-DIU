package com.coderbdk.appbasic.ui


import android.os.Handler
import android.os.Looper
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coderbdk.appbasic.ui.layout.ConstraintsModifier
import com.coderbdk.appbasic.ui.layout.LayoutBasis
import com.coderbdk.appbasic.ui.layout.ListOfComposeModifiers
import com.coderbdk.appbasic.ui.layout.Modifiers
import com.coderbdk.appbasic.ui.theme.AppTheme


@Composable
fun Main() {

    Column(
        Modifier
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        for( i in 0..16){
            Row {
                for( j in 0..8){
                    if( j * i % 2 == 0){
                        LED(on = true)
                    }else{
                        LED(on = false)
                    }

                }
            }
        }

    }


}

val colors = arrayOf(
    Color.Red,
    Color.Green,
    Color.Blue
)
fun getColor(): Color{
    return colors[(colors.indices).random()]
}
@Composable
fun LED(on: Boolean) {
    var isON by remember {
        mutableStateOf(on)
    }

    isON = (0..4).random() == 0

    val value by animateColorAsState(
        targetValue = getColor(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000, delayMillis = 200),
            repeatMode = RepeatMode.Reverse
        ), label = "anim"
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(
                color = Color.LightGray
            )
    ) {
        Box(
            modifier = Modifier
                .size(35.dp)
                .background(
                    color = Color.Gray,
                    shape = RoundedCornerShape(100.dp)
                ),
        )
        // Color(0xFFDFD73B)
        Box(
            modifier = Modifier
                .size(25.dp)
                .background(
                    // color = if (isON) getColor() else Color(0xFF494940),
                    color = value
                )
                .clip(CircleShape)
                .shadow(
                    elevation = 15.dp,
                    ambientColor = Color.Red,
                    spotColor = Color.White
                )
                .padding(30.dp),
        )

    }

}

@Preview
@Composable
fun AppPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Text(text = "Hello,")
        }
    }
}