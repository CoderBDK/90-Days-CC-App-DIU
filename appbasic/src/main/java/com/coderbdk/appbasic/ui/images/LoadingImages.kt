package com.coderbdk.appbasic.ui.images

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.coderbdk.appbasic.R

@Preview
@Composable
fun LoadingImages(){
    Image(
        painter = painterResource(id = R.drawable.ic_android_black_24dp),
        contentDescription = "adndroid black"
    )
   /* AsyncImage(
        model = "https://example.com/image.jpg",
        contentDescription = "Translated description of what the image contains"
    )*/

}