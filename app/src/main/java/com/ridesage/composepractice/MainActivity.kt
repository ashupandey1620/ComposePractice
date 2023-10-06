package com.ridesage.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ridesage.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    AnimatedBorderCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 24.dp),
                        shape = RoundedCornerShape(8.dp),
                        onCardClick = {},
                        gradient = Brush.linearGradient(listOf(Color.Magenta, Color.Cyan))

                    ){
                        Column(modifier = Modifier.padding(all=24.dp)) {

                            Text(text = "Ashutosh",
                                fontWeight = FontWeight.Bold,
                                fontSize = MaterialTheme.typography.displaySmall.fontSize)

                            Spacer(modifier =Modifier.height(15.dp) )

                            Text(text = "Hello EveryOne, My Name is Ashutosh Pandey. My Name is Ashutosh Pandey. My Name is Ashutosh Pandey. My Name is Ashutosh Pandey. My Name is Ashutosh Pandey",
                                fontWeight = FontWeight.Bold,
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize)
                        }


                    }
                }

            }
        }
    }
}














//                Box (modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.Black.copy(alpha = 0.7f)),
//                    contentAlignment = Alignment.Center
//
//                ){
//
//                    MyCustomCard(Modifier.fillMaxWidth(fraction = 0.8f),
//                        image = R.drawable.whitecar ,
//                        title = "white Car"  ,
//                        text = "This is a white Car, which is very good in terms of servicing and Engine. it has a top speed of 240 km/hr and it can reach 0-100 km/h in just 6 seconds. It costs around 2 Billion dollars" ,
//                        publisher = Publisher(
//                            name = "Ashutosh Pandey",
//                            job = "Android Developer",
//                            image = R.drawable.user))
//
//                }