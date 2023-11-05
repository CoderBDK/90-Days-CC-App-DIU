package com.coderbdk.appbasic.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.coderbdk.appbasic.ui.layout.ConstraintsModifier
import com.coderbdk.appbasic.ui.layout.LayoutBasis
import com.coderbdk.appbasic.ui.layout.Modifiers
import com.coderbdk.appbasic.ui.theme.AppTheme


@Composable
fun Main() {

    Column {
        ConstraintsModifier()
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
            Main()
        }
    }
}