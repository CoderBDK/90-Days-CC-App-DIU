package com.coderbdk.appbasic.ui.graphics

import android.graphics.RuntimeShader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderbdk.appbasic.R
import org.intellij.lang.annotations.Language

@Preview
@Composable
fun BrushColor() {
    val brush = Brush.horizontalGradient(listOf(Color.Red, Color.Blue))
    Column {
        Canvas(
            modifier = Modifier
                .height(125.dp)
                .fillMaxWidth(),
            onDraw = {
                drawCircle(brush)
            }
        )
        val colorStops = arrayOf(
            0.0f to Color.Yellow,
            0.2f to Color.Red,
            1f to Color.Blue
        )
        Box(
            modifier = Modifier
                .height(125.dp)
                .fillMaxWidth()
                .background(Brush.horizontalGradient(colorStops = colorStops))
        )
        val listColors = listOf(Color.Yellow, Color.Red, Color.Blue)
        val tileSize = with(LocalDensity.current) {
            50.dp.toPx()
        }
        Box(
            modifier = Modifier
                .height(125.dp)
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listColors,
                        endX = tileSize,
                        tileMode = TileMode.Mirror
                    )
                )
        )

        Box(
            modifier = Modifier
                .height(125.dp)
                .fillMaxWidth()
                .background(
                    Brush.radialGradient(
                        listOf(Color(0xFF2be4dc), Color(0xFF243484))
                    )
                )
        )

        val imageBrush =
            ShaderBrush(ImageShader(ImageBitmap.imageResource(id = R.drawable.ic_launcher)))

// Use ImageShader Brush with background
        Box(
            modifier = Modifier
                .requiredSize(20.dp)
                .background(imageBrush)
        )

// Use ImageShader Brush with TextStyle
        Text(
            text = "Hello Android!",
            style = TextStyle(
                brush = imageBrush,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp
            )
        )

// Use ImageShader Brush with DrawScope#drawCircle()
        Canvas(onDraw = {
            drawCircle(imageBrush)
        }, modifier = Modifier.size(25.dp))


    }
}

@Language("AGSL")
val CUSTOM_SHADER = """
    
    uniform float2 resolution;
    layout(color) uniform half4 color;
    layout(color) uniform half4 color2;

    half4 main(in float2 fragCoord) {
        float2 uv = fragCoord/resolution.xy;

        float mixValue = distance(uv, vec2(0, 1));
        return mix(color, color2, mixValue);
    }
""".trimIndent()


val Coral = Color(0xFFF3A397)
val LightYellow = Color(0xFFF8EE94)

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
@Preview
fun ShaderBrushExample() {
    Box(
        modifier = Modifier
            .drawWithCache {
                val shader = RuntimeShader(CUSTOM_SHADER)
                val shaderBrush = ShaderBrush(shader)
                shader.setFloatUniform("resolution", size.width, size.height)
                onDrawBehind {
                    shader.setColorUniform(
                        "color",
                        android.graphics.Color.valueOf(
                            Color.Magenta.red,
                            LightYellow.green,
                            Color.Red.blue,
                            LightYellow.alpha
                        )
                    )
                    shader.setColorUniform(
                        "color2",
                        android.graphics.Color.valueOf(
                            Coral.red,
                            Coral.green,
                            Coral.blue,
                            Coral.alpha
                        )
                    )
                    drawRect(shaderBrush)
                }
            }
            .fillMaxWidth()
            .height(200.dp)
    )
}