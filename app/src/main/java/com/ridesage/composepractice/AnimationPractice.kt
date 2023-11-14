package com.ridesage.composepractice

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
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

@OptIn(ExperimentalAnimationApi::class)
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

//        val borderRadius by animateIntAsState(
//            targetValue = if(isRound) 40 else 20,
////            animationSpec = tween(
////                durationMillis = 2000,
////                delayMillis = 500
////            )
//            animationSpec = spring(
//                dampingRatio = Spring.DampingRatioHighBouncy,
//                stiffness = Spring.StiffnessLow
//            )
//
//        )
//
//
        val transition = updateTransition(
            targetState = isRound,
            label = null)

        val borderRadius by transition.animateInt(
            transitionSpec = { tween(2000) },
            label = "animate Int",
            targetValueByState = {isRound ->
                if (isRound) 100 else 0
            }
        )
//
//        val color by transition.animateColor(
//            transitionSpec = { tween(2000) },
//            label = "animate Color",
//            targetValueByState = {isRound ->
//                if (isRound) Color.Red else Color.Blue
//            }
//        )


//        val transition = rememberInfiniteTransition()
//
//        val color by transition.animateColor(initialValue = Color.Green , targetValue = Color.LightGray , animationSpec = infiniteRepeatable(
//            animation = tween(2000),
//            repeatMode = RepeatMode.Reverse
//        ))

        
        AnimatedContent(
            targetState = isVisible ,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) ,
            content = { isVisible ->
                if (isVisible)
                    Box(modifier = Modifier.fillMaxSize().background(Color.Green))
                else
                    Box(modifier = Modifier.fillMaxSize().background(Color.Red))
            } ,
            transitionSpec = {
                slideInHorizontally() with slideOutHorizontally()
            } , label = ""
        )


//        Box (modifier = Modifier
//            .size(200.dp)
//            .background(color)){
//
//        }
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

