package com.coderbdk.appbasic.ui.images

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.coderbdk.appbasic.R

@Preview
@Composable
fun BitmapVsVector(){


    Image(painter = painterResource(id = R.drawable.ic_launcher), contentDescription = "android")
    val imageBitmap = ImageBitmap.imageResource(id = R.drawable.ic_launcher)
    Image(painter = painterResource(id = R.drawable.ic_android_black_24dp), contentDescription = "android")
    val imageVector =ImageVector.vectorResource(id = R.drawable.ic_android_black_24dp)
}