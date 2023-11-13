package com.ridesage.composepractice

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.reflect.KProperty

@Composable
fun AnimationPractice() {

    Column(modifier = Modifier.fillMaxSize()) {


        var isVisible by remember {
            mutableStateOf(false)
        }
        
        androidx.compose.material3.Button(onClick = {
            isVisible = !isVisible
        }) {
            Text(text = "Toggle")
        }

        AnimatedVisibility(visible = isVisible,
            modifier = Modifier.fillMaxWidth().weight(1f)) {

            Box (modifier = Modifier.background(Color.Red)){

            }
        }
    }
}

