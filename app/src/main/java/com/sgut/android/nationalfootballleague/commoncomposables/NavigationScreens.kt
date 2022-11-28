package com.sgut.android.nationalfootballleague.commoncomposables

sealed class NavigationScreens (val route: String) {
    object MainScreenTeamsList: NavigationScreens("team_cards_list")
    object DetailScreenTeam: NavigationScreens("team_detail_screen")
    object AthleteDetailScreen: NavigationScreens("athlete_detail_screen")
    object ScoreboardScreen: NavigationScreens("scoreboard_screen")
    object SettingsScreen: NavigationScreens("settings_screen")




    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg->
                append("/$arg")
            }
        }
    }

}