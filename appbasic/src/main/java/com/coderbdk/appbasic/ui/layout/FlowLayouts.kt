package com.coderbdk.appbasic.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
@Preview
private fun FlowRowSimpleUsageExample() {
    Column {

        FlowRow(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            maxItemsInEachRow = 2
        ) {
            ChipItem("Price: High to Low")
            ChipItem("Avg rating: 4+")
            ChipItem("Free breakfast")
            ChipItem("Free cancellation")
            ChipItem("£50 pn")
            ChipItem("Price: High to Low")
            ChipItem("Avg rating: 4+")
            ChipItem("Free breakfast")
            ChipItem("Free cancellation")
            ChipItem("£50 pn")
        }
        FlowColumn(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            ChipItem("Price: High to Low")
            ChipItem("Avg rating: 4+")
            ChipItem("Free breakfast")
            ChipItem("Free cancellation")
            ChipItem("£50 pn")
            ChipItem("Price: High to Low")
            ChipItem("Avg rating: 4+")
            ChipItem("Free breakfast")
            ChipItem("Free cancellation")
            ChipItem("£50 pn")
        }
        FlowRow(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            maxItemsInEachRow = 3
        ) {
            val itemModifier = Modifier
                .clip(RoundedCornerShape(8.dp))
            Box(
                modifier = itemModifier
                    .height(200.dp)
                    .width(60.dp)
                    .background(Color.Red)
            )
            Box(
                modifier = itemModifier
                    .height(200.dp)
                    .fillMaxWidth(0.7f)
                    .background(Color.Blue)
            )
            Box(
                modifier = itemModifier
                    .height(200.dp)
                    .weight(1f)
                    .background(Color.Magenta)
            )
        }
    }
}

@Composable
fun ChipItem(s: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(text = s)
    }
}
