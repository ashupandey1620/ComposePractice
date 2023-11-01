package com.ridesage.composepractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorContrast() {
    Column(
        Modifier.verticalScroll(rememberScrollState()),
    ) {
        TextWithPadding(
            "Sufficient color contrast benefits users with various visual impairments, but " +
                    "also helps all users when interacting with their device in extreme lighting" +
                    " conditions, such as in direct sunlight."
        )

        TextWithPadding(
            "Accessibility Scanner, available on the Play Store, can be used to detect color" +
                    " contrast issues. You can use Scanner on this screen to see how it" +
                    " identifies color contrast issues."
        )

        TextWithProperColorContrast(text = "This text has sufficient color contrast ratio")

        TextWithInsufficientColorContrast(
            text = "This text does not have sufficient color contrast ratio and should be " +
                    "identified by Scanner"
        )
    }
}

@Composable
fun TextWithProperColorContrast(text: String) {
    Text(text, color = Color.Blue, modifier = Modifier.padding(30.dp))
}

@Composable
fun TextWithInsufficientColorContrast(text: String) {
    Box(
        modifier = Modifier
            .background(Color.Gray)
            .padding(30.dp)
    ) {
        Text(text, color = Color.DarkGray)
    }
}
