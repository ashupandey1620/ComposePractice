package com.ridesage.composepractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpeakableText() {
    Column {
        TextWithPadding(
            text = "Users of screen readers rely on content labels to understand the meaning of" +
                    " elements on the screen."
        )

        TextWithPadding(
            text = "Turn on TalkBack to navigate this screen to better understand how proper" +
                    " content labels affect the user experience. You can also run Accessibility" +
                    "Scanner on this screen to see how Scanner provides tips for better labels."
        )

        TextWithPadding(
            text = "Content labels should be succinct and clearly describe the meaning or action" +
                    " associated with the element. It should not include the element's type" +
                    " (ie: button, checkbox), or instruct the user how to specifically interact" +
                    " with the element. Below are examples of bad content labels that degrade the" +
                    " user experience."
        )

        Row(
            Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally)
        ) {

            // Content descriptions should not include the element's type. In this case, including
            // the word "button" is extraneous.
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Edit, contentDescription = "Call Button")
            }

            // Content descriptions should not include instructions on how to specifically
            // interact with the element. In this case, "Double Tap" is extraneous.
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Edit, contentDescription = "Call Button, Double Tap")
            }

            // Content descriptions should describe the action associated with the element instead
            // of a description of the element itself.
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Edit, contentDescription = "Pencil")
            }

            // Elements with a content description make it difficult for users to navigate the app.
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Edit, contentDescription = null)
            }
        }

        TextWithPadding(
            text = "Below is an example of a button with a succinct and descriptive content label."
        )

        Row(
            Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit")
            }
        }
    }
}

@Composable
fun TextWithPadding(text: String) {
    Text(text = text, modifier = Modifier.padding(30.dp))
}