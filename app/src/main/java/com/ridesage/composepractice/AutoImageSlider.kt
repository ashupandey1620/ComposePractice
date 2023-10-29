package com.ridesage.composepractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyApplication(modifier: Modifier = Modifier) {
    val images = listOf(
        R.drawable.yellowcar,
        R.drawable.busdriver,
        R.drawable.whitecar,
        R.drawable.autodriver
    )

    val pagerState = rememberPagerState(pageCount = images.size)

    Column(modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Box(modifier = modifier.fillMaxWidth()){
            HorizontalPager(state = pagerState,
                modifier
                    .wrapContentSize()
                    .padding(26.dp)) {currentPage->

                Card(
                    modifier.wrapContentSize(),
                    elevation = CardDefaults.cardElevation(8.dp)

                ) {
                    Image(painter = painterResource(id = images[currentPage]),contentDescription ="")
                }

            }
        }
    }
}