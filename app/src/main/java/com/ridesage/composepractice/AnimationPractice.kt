package com.ridesage.composepractice

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.reflect.KProperty

@Composable
fun AnimationPractice() {

    Column(modifier = Modifier.fillMaxSize()) {


        var isVisible by remember {
            mutableStateOf(false)
        }

        var isRound by remember {
            mutableStateOf(false)
        }
        
        androidx.compose.material3.Button(onClick = {
            isVisible = !isVisible
            isRound = !isRound
        }) {
            Text(text = "Toggle")
        }

        val borderRadius by animateIntAsState(
            targetValue = if(isRound) 40 else 20,
//            animationSpec = tween(
//                durationMillis = 2000,
//                delayMillis = 500
//            )
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioHighBouncy,
                stiffness = Spring.StiffnessLow
            )

        )


        Box (modifier = Modifier.size(200.dp)
            .clip(RoundedCornerShape(borderRadius))
            .background(Color.Red)){

        }
//        AnimatedVisibility(visible = isVisible,
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1f),
//            enter = slideInHorizontally() + fadeIn(),
//            exit  = slideOutHorizontally() + fadeOut()
//        ) {
//
//            Box (modifier = Modifier.background(Color.Red)){
//
//            }
//        }
    }
}

