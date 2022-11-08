package com.sgut.android.nationalfootballleague.commoncomposables

sealed class Screen (val route: String) {
    object MainScreen: Screen("main_screen")
    object DetailScreen: Screen("detail_screen")

    object MainScreenTeamsList: Screen("team_cards_list")
    object DetailScreenTeam: Screen("team_detail_screen")


    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg->
                append("/$arg")
            }
        }
    }

}