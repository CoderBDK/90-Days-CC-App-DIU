package com.coderbdk.appbasic.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.lang.Integer.max
import java.lang.Integer.min

@Preview
@Composable
fun AlignmentLines(){
    Text("Hi there!", Modifier
        .background(
            color = Color.Red
        ).firstBaselineToTop(32.dp))

    BarChartMinMax(
        dataPoints = listOf(4, 24, 15),
        maxText = { Text("Max") },
        minText = { Text("Min") },
        modifier = Modifier.padding(24.dp)
    )
}

fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp,
) = layout { measurable, constraints ->
    // Measure the composable
    val placeable = measurable.measure(constraints)

    // Check the composable has a first baseline
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]

    // Height of the composable with padding - first baseline
    val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
    val height = placeable.height + placeableY
    layout(placeable.width, height) {
        // Where the composable gets placed
        placeable.placeRelative(0, placeableY)
    }
}


/**
 * AlignmentLine defined by the maximum data value in a [BarChart]
 */
private val MaxChartValue = HorizontalAlignmentLine(merger = { old, new ->
    min(old, new)
})

/**
 * AlignmentLine defined by the minimum data value in a [BarChart]
 */
private val MinChartValue = HorizontalAlignmentLine(merger = { old, new ->
    max(old, new)
})

@Composable
private fun BarChart(
    dataPoints: List<Int>,
    modifier: Modifier = Modifier,
) {
    val maxValue: Float = remember(dataPoints) { dataPoints.maxOrNull()!! * 1.2f }

    BoxWithConstraints(modifier = modifier) {
        val density = LocalDensity.current
        with(density) {
            // ...
            // Calculate baselines
            val maxYBaseline = 1
            val minYBaseline = 1
                Layout(
                    content = {},
                    modifier = Modifier.drawBehind {
                        // ...
                    }
                ) { _, constraints ->
                    with(constraints) {
                        layout(
                            width = if (hasBoundedWidth) maxWidth else minWidth,
                            height = if (hasBoundedHeight) maxHeight else minHeight,
                            // Custom AlignmentLines are set here. These are propagated
                            // to direct and indirect parent composables.
                            alignmentLines = mapOf(
                                MinChartValue to minYBaseline,
                                MaxChartValue to maxYBaseline
                            )
                        ) {}
                    }
                }
        }
    }
}

@Composable
private fun BarChartMinMax(
    dataPoints: List<Int>,
    maxText: @Composable () -> Unit,
    minText: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Layout(
        content = {
            maxText()
            minText()
            // Set a fixed size to make the example easier to follow
            BarChart(dataPoints, Modifier.size(200.dp))
        },
        modifier = modifier
    ) { measurables, constraints ->
        check(measurables.size == 3)
        val placeables = measurables.map {
            it.measure(constraints.copy(minWidth = 0, minHeight = 0))
        }

        val maxTextPlaceable = placeables[0]
        val minTextPlaceable = placeables[1]
        val barChartPlaceable = placeables[2]

        // Obtain the alignment lines from BarChart to position the Text
        val minValueBaseline = barChartPlaceable[MinChartValue]
        val maxValueBaseline = barChartPlaceable[MaxChartValue]
        layout(constraints.maxWidth, constraints.maxHeight) {
            maxTextPlaceable.placeRelative(
                x = 0,
                y = maxValueBaseline - (maxTextPlaceable.height / 2)
            )
            minTextPlaceable.placeRelative(
                x = 0,
                y = minValueBaseline - (minTextPlaceable.height / 2)
            )
            barChartPlaceable.placeRelative(
                x = max(maxTextPlaceable.width, minTextPlaceable.width) + 20,
                y = 0
            )
        }
    }
}
