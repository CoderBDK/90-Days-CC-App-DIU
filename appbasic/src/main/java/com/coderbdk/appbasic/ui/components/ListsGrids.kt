package com.coderbdk.appbasic.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ListGridPreviews(){
    Column(
        Modifier.background(Color.White)
    ) {
        LazyColumn {
            // Add a single item
            item {
                Text(text = "First item")
            }

            // Add 5 items
            items(5) { index ->
                Text(text = "Item: $index")
            }

            // Add another single item
            item {
                Text(text = "Last item")
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(5) { index ->
                Text(text = "Item: $index")
            }
        }
       LazyHorizontalGrid(
           rows = GridCells.Fixed(3)
        ) {
            items(5) { index ->
                Text(text = "HG Item: $index")
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 30.dp)
        ) {
            item(span = {
                // LazyGridItemSpanScope:
                // maxLineSpan
                GridItemSpan(maxLineSpan)
            }) {
                Text(text = "Item")
            }
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(200.dp),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(5) { index ->
                    Text(text = "SG $index")
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }

}