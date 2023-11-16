package com.coderbdk.appbasic.ui.layout

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderbdk.appbasic.R
import kotlinx.coroutines.launch
import java.lang.Float.min
import kotlin.math.absoluteValue


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun PagerLayout() {
    val pagerIndicatorStateX = rememberScrollState()
    val pagerStateX = rememberPagerState(
        pageCount = { 100 }
    )
    val fling = PagerDefaults.flingBehavior(
        state = pagerStateX,
        pagerSnapDistance = PagerSnapDistance.atMost(5)
    )

    val coroutineScope = rememberCoroutineScope()
    var width = 0
    coroutineScope.launch {
        pagerIndicatorStateX.animateScrollTo(pagerStateX.currentPage * width)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HorizontalPager(
            state = pagerStateX,
            modifier = Modifier,
            flingBehavior = fling

        ) { page ->



            // Our page content
            Box(modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    // https://www.sinasamaki.com/pager-animations/
                    val pageOffset = pagerStateX.getOffsetFractionForPage(page)
                    val offScreenRight = pageOffset < 0f
                    val deg = 105f
                    val interpolated = FastOutLinearInEasing.transform(pageOffset.absoluteValue)
                    rotationY = min(interpolated * if (offScreenRight) deg else -deg, 90f)

                    transformOrigin = TransformOrigin(
                        pivotFractionX = if (offScreenRight) 0f else 1f,
                        pivotFractionY = .5f
                    )
                }
                .drawWithContent {
                    val pageOffset = pagerStateX.getOffsetFractionForPage(page)

                    this.drawContent()
                    drawRect(
                        Color.Black.copy(
                            (pageOffset.absoluteValue * .7f)
                        )
                    )
                },
                contentAlignment = Alignment.Center){
                Column(
                    modifier = Modifier
                        .background(
                            color = Color.White,
                        )
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Image"
                    )
                    Text(text = "${page + 1}", fontSize = 35.sp)
                }
            }

        }
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "${pagerStateX.currentPage}/${pagerStateX.pageCount}", fontSize = 15.sp, color = Color.White)
            Row(
                Modifier
                    .horizontalScroll(state = pagerIndicatorStateX, enabled = true)
            ){

                repeat(pagerStateX.pageCount) { iteration ->
                    val coroutineScope = rememberCoroutineScope()


                    val color =
                        if (pagerStateX.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(16.dp)
                            .clickable(onClick = {
                                coroutineScope.launch {
                                    // Call scroll to on pagerState
                                    pagerStateX.animateScrollToPage(iteration)
                                }
                            })
                    )
                }
                width = pagerIndicatorStateX.maxValue / pagerStateX.pageCount + 1
            }

        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppPreview() {
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
        ) { page ->
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