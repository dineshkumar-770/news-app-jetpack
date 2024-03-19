package com.example.apicallapp

import android.annotation.SuppressLint
import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
  import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
 import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
 import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
 import androidx.compose.material3.Scaffold
 import androidx.compose.material3.Surface
import androidx.compose.material3.Text 
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf 
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp 
import com.example.apicallapp.network.NewsManager
import com.example.apicallapp.ui.AppBar
import com.example.apicallapp.ui.MoreNewsScreen
import com.example.apicallapp.ui.NewsContCard
import com.example.apicallapp.ui.model.BottomMenuData
import com.example.apicallapp.ui.theme.ApiCallAppTheme 

class MainActivity : ComponentActivity() {
    val screens = listOf("Home", "More",)
    val selectedScreen =  mutableStateOf(screens.first())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApiCallAppTheme {
                 Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Scaffold(
                       topBar = {
                           AppBar()
                       },
                       bottomBar = {
                           BottomNavigationBar(
                               screens = screens,
                               selectedScreen = selectedScreen.value,
                               onScreenSelected = { screen ->
                                   selectedScreen.value = screen
                               }
                           )
                       }
                   ) { innerPadding  ->
                       Column(
                           modifier = Modifier
                               .padding(innerPadding),
                           verticalArrangement = Arrangement.spacedBy(16.dp),
                       ) {
                          when(selectedScreen.value){
                            "Home"->  NewsArticals(NewsManager(),NewsContCard())
                            "More"->  MoreNewsScreen()
                          }

                       }
                   }
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun NewsArticals( newManager: NewsManager, newsCntCard: NewsContCard){
    val totalArtical = newManager.newsResponse.value
    if(totalArtical.articles == null)
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
        )    else
    Box(Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(totalArtical.articles.count()){
                    index -> newsCntCard.NewsContentCard(
                newsAuther = totalArtical.articles[index].author?: "",
                newsDescription = totalArtical.articles[index].description?:"",
                newsImage = totalArtical.articles[index].urlToImage?:"",
                newsSource = totalArtical.articles[index].source.name?:"",
                newsTitle = totalArtical.articles[index].title
            )
            }
        }
    }
}

@Composable
fun BottomNavigationBar(
    screens: List<String>,
    selectedScreen: String,
    onScreenSelected: (String) -> Unit
){

    val items = listOf<BottomMenuData>(
        BottomMenuData.homeNews,
        BottomMenuData.moreNews
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,

    ) {
        screens.forEach { screen ->
            BottomNavigationItem(
                selected = screen == selectedScreen,
                onClick = { onScreenSelected(screen) },
                icon = {
                       items.forEach{
                           Icon(imageVector = it.icon, contentDescription = null)
                       }
                },
                alwaysShowLabel = true,
                label = {
                    Text(text = screen)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewsCardPreview() {
    ApiCallAppTheme {
//        NewsContentCard()
    }
}

