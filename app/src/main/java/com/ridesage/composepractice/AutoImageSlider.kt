package com.ridesage.composepractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyApplication(modifier: Modifier = Modifier) {
    val images = listOf(
        R.drawable.whitecar,
        R.drawable.whitecar,
        R.drawable.whitecar,
        R.drawable.whitecar
    )

    val pagerState = rememberPagerState(pageCount = images.size)


    LaunchedEffect(Unit){
        while (true)
        {
            delay(2000)
            val nextPage = (pagerState.currentPage+1) % pagerState.pageCount
            pagerState.scrollToPage(nextPage)
        }
    }

    Column(modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Box(modifier = modifier.wrapContentSize()){
            HorizontalPager(state = pagerState,
                modifier
                    .wrapContentSize()
                    ) {currentPage->

                Card(
                    modifier
                        .wrapContentSize()
                        .padding(26.dp),
                    elevation = CardDefaults.cardElevation(8.dp)

                ) {
                    Image(painter = painterResource(id = images[currentPage]),contentDescription ="")
                }

            }

            IconButton(onClick = {  },
                 modifier.padding(30.dp)
                     .size(48.dp)
                     .align(Alignment.CenterEnd)
                     .clip(CircleShape)) {

                Icon(imageVector = Icons.Filled.KeyboardArrowRight,contentDescription = "",
                    modifier.fillMaxSize(),
                    tint = Color.LightGray)


            }

            IconButton(onClick = {  },
                modifier.padding(30.dp)
                    .size(48.dp)
                    .align(Alignment.CenterStart)
                    .clip(CircleShape)) {

                Icon(imageVector = Icons.Filled.KeyboardArrowLeft,contentDescription = "",
                    modifier.fillMaxSize(),
                    tint = Color.LightGray)


            }
        }
    }
}