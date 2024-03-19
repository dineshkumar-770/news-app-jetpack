package com.example.apicallapp.ui.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
 import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val icon: ImageVector,
    ){
    object homeNews : BottomMenuData(icon = Icons.Filled.Home, )
    object moreNews : BottomMenuData(icon = Icons.Filled.AddCircle,  )
}