package com.coderbdk.appbasic.ui.layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun AppPreview(){
    val pagerStateX = rememberPagerState(pageCount = {
        10
    })
    val pagerStateY = rememberPagerState(pageCount = {
        10
    })

    var currentPage by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(pagerStateX) {
        // Collect from the a snapshotFlow reading the currentPage
        snapshotFlow { pagerStateX.currentPage }.collect { page ->
            // Do something with each page change, for example:
            // viewModel.sendPageSelectedEvent(page)
           currentPage = page
        }
    }

    Column {
        // scroll to page
        val coroutineScope = rememberCoroutineScope()
        Button(onClick = {
            coroutineScope.launch {
                // Call scroll to on pagerState
                pagerStateX.animateScrollToPage(currentPage)
            }
        }) {
            Text("Jump to Page $currentPage")
        }
        HorizontalPager(
            modifier = Modifier.height(100.dp),
            state = pagerStateX
        ) {page ->
            Card(
                Modifier
                    .size(200.dp)
                    .graphicsLayer {
                        // Calculate the absolute offset for the current page from the
                        // scroll position. We use the absolute value which allows us to mirror
                        // any effects for both directions
                        val pageOffset = (
                                (pagerStateX.currentPage - page) + pagerStateX
                                    .currentPageOffsetFraction
                                ).absoluteValue

                        // We animate the alpha, between 50% and 100%

                    }
            ) {
                // Card content
                Button(onClick = { /*TODO*/ }) {
                    Modifier.size(100.dp)
                }
            }
        }
        VerticalPager(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            state = pagerStateY
        ) {
            Text(text = "Hello $it")
        }
    }

}