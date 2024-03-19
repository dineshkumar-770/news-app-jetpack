package com.example.apicallapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

class NewsContCard {

    @Composable
    fun NewsContentCard(newsTitle: String, newsDescription: String, newsAuther: String, newsSource: String, newsImage: String) {
        Box(
            modifier = Modifier.background(Color.Transparent, RoundedCornerShape(12.dp))
                .padding(8.dp)
                .shadow(5.dp, shape = RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "$newsTitle",
                    color= MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp,4.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Author: $newsAuther",
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(8.dp,2.dp)
                    )
                    Text(text = "Source: $newsSource",
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(8.dp,2.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.8f), // Adjust alpha to control darkness
                                    Color.Transparent,
                                    Color.Transparent,
                                    Color.Black.copy(alpha = 0.8f) // Adjust alpha to control darkness
                                ),
                                startY = 0f,
                                endY = 100f // Adjust this value to control the height of the shaded area
                            ),
                            shape = RoundedCornerShape(12.dp)
                        )

                ) {

                    AsyncImage(model = "$newsImage", contentDescription = "", contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(text = "$newsDescription",
                    maxLines = 3,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    lineHeight = 17.5.sp,
                    modifier = Modifier.padding(8.dp,2.dp)
                )
            }
        }
    }

}