package com.sgut.android.nationalfootballleague.commoncomposables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, var icon: String, var title: String ) {

    object Home: NavigationItem("home", "Home", "Home")
    object Nfl: NavigationItem("nfl", "NFL", "National Football League")
    object Mlb: NavigationItem("mlb", "MLB", "Major League Baseball")
    object Nhl: NavigationItem("nhl", "NHL", "National Hockey League")
    object Wnba: NavigationItem("wnba", "WNBA", "Women's National Basketball")
    object Nba: NavigationItem("nba", "NBA", "National Basketball Association")


}


