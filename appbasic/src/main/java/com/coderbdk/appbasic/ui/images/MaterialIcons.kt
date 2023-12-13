package com.coderbdk.appbasic.ui.images

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.coderbdk.appbasic.R

@Preview
@Composable
fun MaterialIcons(){
    Column {
        Icon(
            painter = painterResource(R.drawable.ic_android_black_24dp),
            contentDescription = "android"
        )
        Icon(
            Icons.Rounded.ShoppingCart,
            contentDescription = "shopping cart"
        )
    }

}