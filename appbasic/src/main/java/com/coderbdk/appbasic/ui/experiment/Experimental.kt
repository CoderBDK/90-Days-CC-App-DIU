package com.coderbdk.appbasic.ui.experiment

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coderbdk.appbasic.R

/**
 * Created by MD. ABDULLAH on Sat, Dec 30, 2023.
 */

@Preview
@Composable
fun BulbAnimation() {
    var enable by remember {
        mutableStateOf(false)
    }
    val alpha1: Float by animateFloatAsState(
        targetValue = if (!enable) 0f else 0.9f, label = "animate float",
        animationSpec = tween(durationMillis = 3000)
    )
    val alpha2: Float by animateFloatAsState(
        targetValue = if (!enable) 0f else 0.7f, label = "animate float",
        animationSpec = if (enable) tween(durationMillis = 5000) else tween(durationMillis = 3000)
    )
    val radius = 145.dp
    Column(
        Modifier.background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(340.dp)
                .padding(top = 100.dp),
            contentAlignment = Alignment.Center

        ) {

            Box(
                modifier = Modifier
                    .size(radius)
                    .alpha(alpha1)
                    .background(
                        brush = Brush.radialGradient(
                            listOf(
                                Color.Red,
                                Color.Black
                            ),
                            tileMode = TileMode.Clamp
                        ),

                        ),
            )

            Image(
                modifier = Modifier
                    .offset(y = 30.dp)
                    .size(340.dp)
                    ,
                painter = painterResource(id = R.drawable.bulb),
                contentDescription = "bulb",
                alpha = alpha1 / 2f + 0.5f,
                colorFilter = ColorFilter.colorMatrix(
                    ColorMatrix(
                        floatArrayOf(
                            -1f, 0f, 0f, alpha2 / 2f + 0.5f, 255f,
                            0f, -1f, 0f, 0.0f, 255f,
                            0f, 0f, -1f, 0f, 255f,
                            0f, 0f, alpha1, 1f, 0f,
                        )
                    )
                )
            )

            Box(
                modifier = Modifier
                    .size(radius * 2)
                    .alpha(alpha2)
                    .background(
                        brush = Brush.radialGradient(
                            listOf(
                                Color.Red,
                                Color.Black
                            ),
                        ),
                    ),
            ) {

            }
        }

        Switch(checked = enable, onCheckedChange = {
            enable = it
        })
    }

}