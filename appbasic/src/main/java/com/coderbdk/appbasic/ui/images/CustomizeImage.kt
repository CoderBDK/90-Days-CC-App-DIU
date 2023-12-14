package com.coderbdk.appbasic.ui.images

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coderbdk.appbasic.R

@OptIn(ExperimentalLayoutApi::class)
@Preview(heightDp = 1020, widthDp = 600)
@Composable
fun CustomizeImage(){
    FlowRow {
        val imageModifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black))
            .background(Color.Yellow)
        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.compose),
            contentScale = ContentScale.Fit,
            modifier = imageModifier
        )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.compose),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.compose),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        val borderWidth = 4.dp
        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.compose),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .border(
                    BorderStroke(borderWidth, Color.Yellow),
                    CircleShape
                )
                .padding(borderWidth)
                .clip(CircleShape)
        )

        val rainbowColorsBrush = remember {
            Brush.sweepGradient(
                listOf(
                    Color(0xFF9575CD),
                    Color(0xFFBA68C8),
                    Color(0xFFE57373),
                    Color(0xFFFFB74D),
                    Color(0xFFFFF176),
                    Color(0xFFAED581),
                    Color(0xFF4DD0E1),
                    Color(0xFF9575CD)
                )
            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.compose),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .border(
                    BorderStroke(borderWidth, rainbowColorsBrush),
                    CircleShape
                )
                .padding(borderWidth)
                .clip(CircleShape)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.compose),
            modifier = Modifier.aspectRatio(16f / 9f)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_android_black_24dp),
            contentDescription = stringResource(id = R.string.compose),
            colorFilter = ColorFilter.tint(Color.Green)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.compose),
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Darken)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.compose),
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) })
        )
        val contrast = 2f // 0f..10f (1 should be default)
        val brightness = -180f // -255f..255f (0 should be default)
       var colorMatrix = floatArrayOf(
            contrast, 0f, 0f, 0f, brightness,
            0f, contrast, 0f, 0f, brightness,
            0f, 0f, contrast, 0f, brightness,
            0f, 0f, 0f, 1f, 0f
        )
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.compose),
            colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix))
        )
       colorMatrix = floatArrayOf(
            -1f, 0f, 0f, 0f, 255f,
            0f, -1f, 0f, 0f, 255f,
            0f, 0f, -1f, 0f, 255f,
            0f, 0f, 0f, 1f, 0f
        )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.compose),
            colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix))
        )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.compose),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .blur(
                    radiusX = 10.dp,
                    radiusY = 10.dp,
                    edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
                )
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.compose),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(250.dp)
                .blur(
                    radiusX = 100.dp,
                    radiusY = 100.dp,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded
                )
                .clip(RoundedCornerShape(88.dp))
        )
    }

}