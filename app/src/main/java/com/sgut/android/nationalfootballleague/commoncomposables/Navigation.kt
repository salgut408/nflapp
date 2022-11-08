package com.sgut.android.nationalfootballleague.commoncomposables

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sgut.android.nationalfootballleague.homelistscreen.TeamCardsList
import com.sgut.android.nationalfootballleague.teamdetails.TeamDetailScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreenTeamsList.route){
        composable(route = Screen.MainScreenTeamsList.route) {
                TeamCardsList(navController = navController)
        }
        composable(
            route = Screen.DetailScreenTeam.route + "/{teamName}",
            arguments = listOf(
                navArgument("teamName") {
                    type = NavType.StringType
                }
            )

        ) { entry ->
            entry.arguments?.getString("teamName")?.let { TeamDetailScreen(team = it) }
        }
    }
}