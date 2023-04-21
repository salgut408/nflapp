package com.sgut.android.nationalfootballleague

import android.content.res.Resources
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sgut.android.nationalfootballleague.di.ToolBar2
import com.sgut.android.nationalfootballleague.ui.application.EspnAppState
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.Navigation
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.snackbar.SnackbarManager
import com.sgut.android.nationalfootballleague.ui.navigation.NavigationScreens
import kotlinx.coroutines.CoroutineScope


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EspnApp(
    modifier: Modifier = Modifier,

    ) {
    val appState = rememberAppState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val backStackEntry by appState.navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: NavigationScreens.MainScreenTeamsList.route
    val snackbarHostState = remember { SnackbarHostState() }
    val scaffoldState = rememberScaffoldState()



    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),



        topBar = {
            ToolBar2(
                title = backStackEntry?.destination?.route ?: NavigationScreens.MainScreenTeamsList.route,
                canNavigateBack = appState.navController.previousBackStackEntry != null,
                navigateUp = { appState.navController.navigateUp() },
                scrollBehavior = scrollBehavior
            )
        },



        bottomBar = {
            BottomAppBar(modifier = Modifier) {
                IconButton(onClick = { appState.navController.navigate(NavigationScreens.SettingsScreen.route){
                    this.launchSingleTop = true
                } }) {
                    Icon(Icons.Default.Settings, contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Menu, contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Favorite, contentDescription = null)
                }
            }
        },

        ) { innerPadding ->

        Navigation(appState, padding = innerPadding)

    }

}


@Composable
fun rememberAppState(
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    navController: NavHostController = rememberNavController(),
    snackbarManager: SnackbarManager = SnackbarManager,
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
) =
    remember(navController, snackbarManager, resources, coroutineScope, snackbarHostState) {
        EspnAppState(navController, snackbarManager, resources, coroutineScope, snackbarHostState)
    }

@Composable
@ReadOnlyComposable
fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}


