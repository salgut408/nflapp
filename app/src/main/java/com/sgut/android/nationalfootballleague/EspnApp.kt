package com.sgut.android.nationalfootballleague

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sgut.android.nationalfootballleague.atheletedetail.AthleteDetailScreen
import com.sgut.android.nationalfootballleague.commoncomposables.Navigation
import com.sgut.android.nationalfootballleague.commoncomposables.NavigationScreens
import com.sgut.android.nationalfootballleague.commoncomposables.snackbar.SnackbarManager
import com.sgut.android.nationalfootballleague.di.MyNewToolBar2
import com.sgut.android.nationalfootballleague.homelistscreen.TeamCardsList
import com.sgut.android.nationalfootballleague.scoreboardscreen.ScoreboardScreen
import com.sgut.android.nationalfootballleague.teamdetails.TeamDetailScreen
import com.sgut.android.nationalfootballleague.ui.theme.NationalFootballLeagueTheme
import kotlinx.coroutines.CoroutineScope



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EspnApp(
    modifier: Modifier = Modifier,

    ) {
    val appState = rememberAppState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val backStackEntry by appState.navController.currentBackStackEntryAsState()
    val currentScreen =
        backStackEntry?.destination?.route ?: NavigationScreens.MainScreenTeamsList.route

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            MyNewToolBar2(
                currentScreen = backStackEntry?.destination?.route
                    ?: NavigationScreens.MainScreenTeamsList.route,
                canNavigateBack = appState.navController.previousBackStackEntry != null,
                navigateUp = { appState.navController.navigateUp() },
                scrollBehavior = scrollBehavior
            )
        },


        bottomBar = {
            BottomAppBar(modifier = Modifier) {
                IconButton(onClick = { appState.navController.navigate(NavigationScreens.SettingsScreen.route) }) {
                    Icon(Icons.Default.Settings, contentDescription = null)
                }
            }
        },

        ) { innerPadding ->

        Navigation(appState, padding = innerPadding)

    }

}


@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    snackbarManager: SnackbarManager = SnackbarManager,
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) =
    remember( navController, snackbarManager, resources, coroutineScope) {
        EspnAppState( navController, snackbarManager, resources, coroutineScope)
    }

@Composable
@ReadOnlyComposable
fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
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