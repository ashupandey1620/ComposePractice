package com.ridesage.composepractice


import androidx.compose.animation.animateColor
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AnimatedBackground()
{
    val composition = rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.android))
    val progress by animateLottieCompositionAsState(composition = composition.value, restartOnPlay = true,
        iterations = LottieConstants.IterateForever)

    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Yellow ,
        targetValue =  Color.Green,
        animationSpec = infiniteRepeatable(animation = tween(durationMillis = 5000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.BottomCenter
    ) {
        LottieAnimation(modifier = Modifier.fillMaxSize() ,composition =composition.value  , progress = {progress})
        Column(
            modifier = Modifier
                .padding(bottom = 80.dp)
                .padding(horizontal = 40.dp)

        ) {
            Text(modifier = Modifier.fillMaxWidth(),
                text = "Happy Dussehra",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold)
            Text(modifier = Modifier.fillMaxWidth(),
                text = "On this Dussehra, may you conquer your inner demons and emerge victorious in life",
                textAlign = TextAlign.Start,
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium)


            Text(modifier = Modifier.fillMaxWidth(),
                text = "~Ashutosh Pandey",
                textAlign = TextAlign.End,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(24.dp))
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = color),
                onClick = {

                },
                shape = CircleShape
            ){
                Text(text = "Click it",
                    color = Color.Black)
            }
        }
    }

}


