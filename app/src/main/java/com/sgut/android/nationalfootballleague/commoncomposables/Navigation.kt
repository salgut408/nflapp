package com.sgut.android.nationalfootballleague.commoncomposables

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sgut.android.nationalfootballleague.EspnAppState
import com.sgut.android.nationalfootballleague.atheletedetail.AthleteDetailScreen
import com.sgut.android.nationalfootballleague.homelistscreen.TeamCardsList
import com.sgut.android.nationalfootballleague.scoreboardscreen.ScoreboardScreen
import com.sgut.android.nationalfootballleague.teamdetails.TeamDetailScreen


// this can be used OR spread out like in scaffold in app fx
//navifation 2 + espnApp2 use seperated navigation




@Composable
fun Navigation(appState: EspnAppState, padding: PaddingValues) {

    NavHost(navController = appState.navController,
        startDestination = NavigationScreens.MainScreenTeamsList.route,
        modifier = Modifier.padding(padding)){

        composable(route = NavigationScreens.MainScreenTeamsList.route) {
            TeamCardsList(navController = appState.navController)
        }
        composable(
            route = NavigationScreens.DetailScreenTeam.route + "/{teamName}/{sport}/{league}",
            arguments = listOf(
                navArgument("teamName") {
                    type = NavType.StringType
                },
                navArgument("sport") {
                    type = NavType.StringType
                },
                navArgument("league") {
                    type = NavType.StringType
                },
            )

        ) { entry ->
            var teamName = entry.arguments?.getString("teamName")!!
            var sportName = entry.arguments?.getString("sport")!!
            var leagueName = entry.arguments?.getString("league")!!


            val context = LocalContext.current

            TeamDetailScreen(
                team = teamName, sport = sportName, league = leagueName,
                sendButtonOnclick = {
                        subject: String, summary: String ->
                    shareTeamAndNextEvent2(context,
                        subject, summary)
                }
            )
        }
        composable(
            route = NavigationScreens.AthleteDetailScreen.route,
        ) {
            AthleteDetailScreen()
        }
        composable(
            route = NavigationScreens.ScoreboardScreen.route + "/{sport}/{league}",
            arguments = listOf(
                navArgument("sport") {
                    type = NavType.StringType
                },
                navArgument("league") {
                    type = NavType.StringType
                },
            )
        ){
            var sportName = it.arguments?.getString("sport")!!
            var leagueName = it.arguments?.getString("league")!!

            ScoreboardScreen(sportName, leagueName)
        }
    }
}




private fun shareTeamAndNextEvent2(
    context: Context,
    subject: String,
    summary: String
) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            "Check this out"
        )
    )
}