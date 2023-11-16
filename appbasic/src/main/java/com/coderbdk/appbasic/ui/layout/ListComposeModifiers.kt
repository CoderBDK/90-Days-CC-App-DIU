package com.coderbdk.appbasic.ui.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex


@Composable
@Preview
fun ListOfComposeModifiers() {
    Box(
        Modifier.background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .size(500.dp)
                .clickable(
                    enabled = true,
                    onClickLabel = "onClick",
                ) {

                }
                .border(
                    border = BorderStroke(1.dp, Color.Green),
                    shape = RoundedCornerShape(2.dp)
                )
                .background(Color.Yellow)
                .clip(
                    shape = RoundedCornerShape(10.dp)
                )
                .shadow(
                    10.dp,
                    spotColor = Color.Yellow,
                    ambientColor = Color.Magenta
                )
                .zIndex(100f)
                .graphicsLayer(
                    rotationX = 10f,
                    rotationY = 100f,
                    translationX = 100f
                )
                .onKeyEvent {
                    if (it.key == Key.A) {

                    }
                    false
                }
                .onGloballyPositioned {
                    it.size.width
                    it.size.height
                    it.isAttached
                }
                .padding(10.dp)
                .padding(top = 10.dp)
                .paddingFromBaseline(bottom = 10.dp)
                .pointerHoverIcon(
                    icon = PointerIcon.Hand,
                    overrideDescendants = true
                )
                .offset(10.dp)
                .scrollable(rememberScrollState(), orientation = Orientation.Vertical)
                .height(100.dp)
                .width(50.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .fillMaxSize()
                .onSizeChanged {

                }
                .requiredSize(10.dp)
                .rotate(145f)
                .blur(
                    radius = 100.dp,
                    edgeTreatment = BlurredEdgeTreatment.Rectangle
                )


        ) {

        }

    }

}