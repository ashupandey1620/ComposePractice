package com.ridesage.composepractice

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import java.util.Timer

@Composable
fun TextAndButton(
    visible: Boolean,
    delayMillis: Long
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Column {
            Text("Text")
            Button("Button") {}
        }
    }

    Timer(
        name = "TextAndButtonAnimationTimer",
        initialDelay = delayMillis,
        period = delayMillis
    ) {
        visible = true
    }
}

@Composable
fun CircularElementAnimation(
    visible: Boolean,
    delayMillis: Long
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        CircularElement()
    }

    Timer(
        name = "CircularElementAnimationTimer",
        initialDelay = delayMillis,
        period = delayMillis
    ) {
        visible = true
    }
}
@Composable
fun Button(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Click(onClick) {
        Box(
            modifier = modifier
                .width(25.dp)
                .height(25.dp)
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Text(text, color = Color.White)
        }
    }
}


@Composable
fun ColumnLayout() {
    Column {
        CircularElementAnimation(visible = true, delayMillis = 1000)
        TextAndButton(visible = true, delayMillis = 2000)
    }
}

@Composable
fun LoadingAnimation(timeDelay: Int) {
    val visibility = remember { mutableStateOf(false) }

    LaunchedEffect(timeDelay) {
        delay(timeDelay.toLong())
        visibility.value = true
    }

    if (visibility.value) {
        Column {
            CircularProgressIndicator()
            Text("Loading...")
        }
    }
}

@Composable
fun MovingButton(widthPercentage: Float) {
    val position = remember { mutableStateOf(0f) }

    Button(onClick = { position.value += 0.25f }) {
        Text("Move")
    }

    Box(modifier = Modifier.width(widthPercentage.dp).offset(x = position.value.dp)) {
        Button(onClick = { position.value += 0.25f }) {
            Text("Move")
        }
    }
}


@Composable
fun AppearingTextAndButton(text: String) {
    val visibility = remember { mutableStateOf(false) }

    LaunchedEffect(text) {
        visibility.value = true
    }

    if (visibility.value) {
        Column {
            Text(text)
            Button(onClick = {}) {
                Text("Click")
            }
        }
    }
}