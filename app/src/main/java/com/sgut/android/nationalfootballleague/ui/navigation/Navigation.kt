package com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sgut.android.nationalfootballleague.ui.application.EspnAppState
import com.sgut.android.nationalfootballleague.ui.navigation.NavigationScreens
import com.sgut.android.nationalfootballleague.ui.screens.athelete_detail.AthleteDetailScreen
import com.sgut.android.nationalfootballleague.ui.screens.basics.log_in.LoginScreen
import com.sgut.android.nationalfootballleague.ui.screens.basics.settings.SettingsScreen
import com.sgut.android.nationalfootballleague.ui.screens.basics.sign_up.SignUpScreen
import com.sgut.android.nationalfootballleague.ui.screens.gamedetailscreen.GameDetailsScreen
import com.sgut.android.nationalfootballleague.ui.screens.homelistscreen.HomeTeamCardsListScreen
import com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen.ScoreboardScreen
import com.sgut.android.nationalfootballleague.ui.screens.teamdetails.TeamDetailScreen
import kotlinx.coroutines.CoroutineScope
import java.text.SimpleDateFormat


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(
    appState: EspnAppState,
    padding: PaddingValues,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
) {

    NavHost(
        navController = appState.navController,
        startDestination = NavigationScreens.MainScreenTeamsList.route,
        modifier = Modifier.padding(padding)
    ) {

        composable(
            route = NavigationScreens.MainScreenTeamsList.route
        ) {
            val sport = it.arguments?.getString("sport")
            val league = it.arguments?.getString("league")
            HomeTeamCardsListScreen(
                navController = appState.navController,

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
            val teamName = entry.arguments?.getString("teamName")!!
            val sportName = entry.arguments?.getString("sport")!!
            val leagueName = entry.arguments?.getString("league")!!


            val context = LocalContext.current

            TeamDetailScreen(
                team = teamName,
                sport = sportName,
                league = leagueName,
                canNavigateBack = appState.navController.previousBackStackEntry != null,
                navigateUp = { appState.navController.navigateUp() }
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
            val sportName = it.arguments?.getString("sport")!!
            val leagueName = it.arguments?.getString("league")!!


            ScoreboardScreen(
                sport = sportName,
                league = leagueName,
                navController = appState.navController,
                canNavigateBack = appState.navController.previousBackStackEntry != null,
                navigateUp = { appState.navController.navigateUp() },


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


private fun createCalenderNote(
    context: Context,
) {
    val startTime = "2022-02-1T09:00:00"
    val endTime = "2022-02-1T12:00:00"

    // Parsing the date and time
    val mSimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val mStartTime = mSimpleDateFormat.parse(startTime)
    val mEndTime = mSimpleDateFormat.parse(endTime)

    val intent = Intent(Intent.ACTION_EDIT).apply {
        type = "vnd.android.cursor.item/event"
        putExtra("beginTime", mStartTime.time)
        putExtra("time", true)
        putExtra("rule", "FREQ=YEARLY")
        putExtra("endTime", mEndTime.time)
        putExtra("title", "EVENT")
    }
    context.startActivity(intent)

}