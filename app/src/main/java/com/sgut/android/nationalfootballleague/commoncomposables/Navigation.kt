package com.sgut.android.nationalfootballleague.commoncomposables

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sgut.android.nationalfootballleague.EspnAppState
import com.sgut.android.nationalfootballleague.atheletedetail.AthleteDetailScreen
import com.sgut.android.nationalfootballleague.gamedetailscreen.GameDetailsScreen
import com.sgut.android.nationalfootballleague.homelistscreen.HomeTeamCardsListScreen
import com.sgut.android.nationalfootballleague.log_in.LoginScreen
import com.sgut.android.nationalfootballleague.scoreboardscreen.ScoreboardScreen
import com.sgut.android.nationalfootballleague.settings.SettingsScreen
import com.sgut.android.nationalfootballleague.sign_up.SignUpScreen
import com.sgut.android.nationalfootballleague.teamdetails.TeamDetailScreen


@Composable
fun Navigation(
    appState: EspnAppState,
    padding: PaddingValues,
) {

    NavHost(
        navController = appState.navController,
        startDestination = NavigationScreens.MainScreenTeamsList.route,
        modifier = Modifier.padding(padding)
    ) {

        composable(
            route = NavigationScreens.MainScreenTeamsList.route
        ) {
            HomeTeamCardsListScreen(
                navController = appState.navController
            )
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
                sendButtonOnclick = { subject: String, summary: String ->
                    shareTeamAndNextEvent(context,
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
            route = NavigationScreens.SignUpScreen.route
        ) {
            SignUpScreen(
                openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) }
            )
        }

        composable(
            route = NavigationScreens.LogInScreen.route
        ) {
            LoginScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
        }

        composable(
            route = NavigationScreens.SettingsScreen.route
        ) {
            val restartRoute = NavigationScreens.MainScreenTeamsList.route
            val openSignUpScreenRoute = NavigationScreens.SignUpScreen.route
            val openLogInScreenRoute = NavigationScreens.LogInScreen.route
            SettingsScreen(
                restartApp = { route -> appState.clearAndNavigate(restartRoute) },
                openSignUpScreen = { route -> appState.navigate(openSignUpScreenRoute) },
                openLogInScreen = { route -> appState.navigate(openLogInScreenRoute) }
            )
        }

        composable(
            route = NavigationScreens.GameDetailScreen.route + "/{sport}/{league}/{event}",
            arguments = listOf(
                navArgument("sport") {
                    type = NavType.StringType
                },
                navArgument("league") {
                    type = NavType.StringType
                },
                navArgument("event") {
                    type = NavType.StringType
                },
            )
        ) {
            val sportName = it.arguments?.getString("sport")!!
            val leagueName = it.arguments?.getString("league")!!
            val event = it.arguments?.getString("event")!!

            GameDetailsScreen(
                navController = appState.navController,

                sport = sportName,
                league = leagueName,
                event = event,
            )

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
        ) {
            var sportName = it.arguments?.getString("sport")!!
            var leagueName = it.arguments?.getString("league")!!

            ScoreboardScreen(
                sport = sportName,
                league = leagueName,
                navController = appState.navController
            )
        }
    }
}


private fun shareTeamAndNextEvent(
    context: Context,
    subject: String,
    summary: String,
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