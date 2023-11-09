package com.ridesage.composepractice

import android.annotation.SuppressLint
import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ButtonExpandable() {


}


@Composable
fun DynamicShapeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    shape:Shape
) {

    Button(
        onClick = {
            onClick()
        },
        modifier = modifier,
        shape = shape,
        content = content
    )
}

fun Button(onClick: () -> Unit , modifier: Modifier , shape: Shape , content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}





@Composable
fun ButtonView() {

    var array = arrayOf(">","Next","Finish")
    var counter = remember{ mutableStateOf(0) }

    var buttonText by remember{mutableStateOf(">")}
    var buttonWidth by remember {
        mutableStateOf(80.dp)
    }
    var buttonHeight by remember {
        mutableStateOf(80.dp)
    }



    Button(
        onClick = {
            if (buttonText == ">") {
                buttonText = "Next"
                buttonWidth = 160.dp
                buttonHeight = 160.dp
            } else {
                buttonText = "Finish"
                buttonWidth = 400.dp
                buttonHeight = 400.dp
            }
        },
        modifier = Modifier.sizeIn(
            minWidth = 80.dp,
            minHeight = 80.dp,
            maxWidth = buttonWidth,
            maxHeight = buttonHeight
        ).offset(
            x = 100.dp,
            y = 0.dp
        )
    ) {
        Text(text = buttonText, fontSize = 18.sp)
    }
}
