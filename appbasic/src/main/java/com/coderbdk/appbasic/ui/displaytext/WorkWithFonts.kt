package com.coderbdk.appbasic.ui.displaytext

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import com.coderbdk.appbasic.R

@Preview
@Composable
fun WorkWithFonts(){
    Column {
        DifferentFonts()

    }
}

@Composable
fun DifferentFonts() {
    val firaSansFamily = FontFamily(
        Font(R.font.abril_fatface, FontWeight.Light),
        Font(R.font.aguafina_script, FontWeight.Normal),
        Font(R.font.abril_fatface, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.abril_fatface, FontWeight.Medium),
        Font(R.font.aguafina_script, FontWeight.Bold)
    )
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )
    val fontName = GoogleFont("Lobster Two")

    val fontFamily = FontFamily(
        Font(googleFont = fontName, fontProvider = provider),

    )

    Column {
        Text("Hello World", fontFamily = FontFamily.Serif)
        Text("Hello World", fontFamily = FontFamily.SansSerif)

        Text(text = "text", fontFamily = fontFamily, fontWeight = FontWeight.Light)

    }
}