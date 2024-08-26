package com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sgut.android.nationalfootballleague.ui.application.EspnAppState
import com.sgut.android.nationalfootballleague.ui.navigation.NavigationScreens
import com.sgut.android.nationalfootballleague.ui.screens.athelete_detail.AthleteDetailScreen
import com.sgut.android.nationalfootballleague.ui.screens.gamedetailscreen.GameDetailsScreen
import com.sgut.android.nationalfootballleague.ui.screens.homelistscreen.HomeListViewModel
import com.sgut.android.nationalfootballleague.ui.screens.homelistscreen.HomeTeamCardsListScreen
import com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen.ScoreboardScreen
import com.sgut.android.nationalfootballleague.ui.screens.selection.SelectionViewModel
import com.sgut.android.nationalfootballleague.ui.screens.teamdetails.TeamDetailScreen
import kotlinx.coroutines.CoroutineScope


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
        modifier = Modifier.padding(padding),

    ) {

        composable(
            route = NavigationScreens.MainScreenTeamsList.route
        ) { backStackEntry ->
            val sport = backStackEntry.arguments?.getString("sport")
            val league = backStackEntry.arguments?.getString("league")
            val parentEntry = remember(backStackEntry) {
                appState.navController.getBackStackEntry(NavigationScreens.MainScreenTeamsList.route )
            }
            val selectionViewModel: SelectionViewModel = hiltViewModel(parentEntry)

            HomeTeamCardsListScreen(
                selectionViewModel = selectionViewModel,
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
                canNavigateBack = appState.navController.previousBackStackEntry != null,
                navigateUp = { appState.navController.navigateUp() }
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
        ) { backStackEntry ->
        val sportName = backStackEntry.arguments?.getString("sport")!!
            val leagueName = backStackEntry.arguments?.getString("league")!!
            val parentEntry = remember(backStackEntry) {
                appState.navController.getBackStackEntry(NavigationScreens.MainScreenTeamsList.route )
            }
            val homeListViewModel: HomeListViewModel = hiltViewModel(parentEntry)
            val selectionViewModel: SelectionViewModel = hiltViewModel(parentEntry)


            ScoreboardScreen(
                homeListViewModel = homeListViewModel,
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
