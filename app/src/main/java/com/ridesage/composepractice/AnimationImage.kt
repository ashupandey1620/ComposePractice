package com.ridesage.composepractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ridesage.composepractice.ui.theme.Purple40

@Composable
fun AnimationImage() {

    var visible by remember {
        mutableStateOf(true)
    }


Column (modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center){


    if (visible) {
        Image(
            modifier = Modifier
                .size(150.dp)
                .clip(shape = CircleShape) ,
            painter = painterResource(id = R.drawable.yellowcar) ,
            contentDescription = "Yellow Car" ,
            contentScale = ContentScale.Crop
        )
    }
    Button(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth() ,
        shape= RoundedCornerShape(10.dp) ,
        colors = ButtonDefaults.buttonColors(Purple40),
        onClick = {
            visible = !visible
        }) {
        Text(text = if(visible)"Hide Car" else "Show Car")

    }
}
}