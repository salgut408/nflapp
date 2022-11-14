package com.sgut.android.nationalfootballleague

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sgut.android.nationalfootballleague.commoncomposables.NavigationScreens
import com.sgut.android.nationalfootballleague.di.MyNewToolBar
import com.sgut.android.nationalfootballleague.homelistscreen.HomeListViewModel
import com.sgut.android.nationalfootballleague.homelistscreen.TeamCardsList
import com.sgut.android.nationalfootballleague.teamdetails.TeamDetailScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EspnApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    homeListViewModel: HomeListViewModel = hiltViewModel(),

    ) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: NavigationScreens.MainScreenTeamsList.route

    Scaffold(
        topBar = {
            MyNewToolBar()
        },
        bottomBar = {
            BottomAppBar(modifier = Modifier,) {

                IconButton(onClick = {  },  ) {
                    Icon(Icons.Default.Menu, contentDescription = null)
                }
                IconButton( onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }

            }
        },

    ) { innerPadding ->

        NavHost(navController = navController, startDestination = NavigationScreens.MainScreenTeamsList.route, modifier.padding(innerPadding)){
            composable(route = NavigationScreens.MainScreenTeamsList.route) {
                TeamCardsList(navController = navController)
            }
            composable(
                route = NavigationScreens.DetailScreenTeam.route + "/{teamName}",
                arguments = listOf(
                    navArgument("teamName") {
                        type = NavType.StringType
                    }

                )

            ) { entry ->
                entry.arguments?.getString("teamName")?.let {
                    val context = LocalContext.current

                    TeamDetailScreen(team = it,
                        sendButtonOnclick = { subject: String, summary: String -> shareTeamAndNextEvent(context, subject, summary) }) }
            }
        }

    }

}

private fun shareTeamAndNextEvent(
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