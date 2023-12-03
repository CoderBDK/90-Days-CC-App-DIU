package com.coderbdk.appbasic.ui.displaytext

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.coderbdk.appbasic.R

@Preview
@Composable
fun DisplayTextPreview(){
   Column {
       Text("Hello World")
       Text(stringResource(R.string.compose))
   }
}