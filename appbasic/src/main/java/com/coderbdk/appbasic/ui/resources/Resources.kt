package com.coderbdk.appbasic.ui.resources

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.coderbdk.appbasic.R

@Preview
@Composable
fun ResourcesPreview(){
    Column(
        Modifier.fillMaxSize().background(Color.White)
    ) {
        Text(
            text = stringResource(R.string.compose)
        )
        val quantity = 30
        Text(
            text = pluralStringResource(
                R.plurals.runtime_format,
                quantity,
                quantity
            )
        )
        val smallPadding = dimensionResource(R.dimen.padding_small)
        Text(
            text = "Hello, World! 8dp padding",
            modifier = Modifier.padding(smallPadding)
        )
        HorizontalDivider(color = colorResource(R.color.purple_200))
        Icon(
            painter = painterResource(id = R.drawable.ic_android_black_24dp),
            contentDescription = null // decorative element
        )
    }

}