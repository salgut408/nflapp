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
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sgut.android.nationalfootballleague.atheletedetail.AthleteDetailScreen
import com.sgut.android.nationalfootballleague.commoncomposables.NavigationScreens
import com.sgut.android.nationalfootballleague.di.MyNewToolBar2
import com.sgut.android.nationalfootballleague.homelistscreen.HomeListViewModel
import com.sgut.android.nationalfootballleague.homelistscreen.TeamCardsList
import com.sgut.android.nationalfootballleague.teamdetails.TeamDetailScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EspnApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),

    ) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: NavigationScreens.MainScreenTeamsList.route

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            MyNewToolBar2(
                currentScreen = backStackEntry?.destination?.route ?: NavigationScreens.MainScreenTeamsList.route,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = {navController.navigateUp()},
                scrollBehavior = scrollBehavior
            )
        },



        bottomBar = {
            BottomAppBar(modifier = Modifier,) {
                IconButton(onClick = {  },  ) {
                    Icon(Icons.Default.Menu, contentDescription = null)
                }
            }
        },

    ) { innerPadding ->

//        Navigation(navController = navController, padding = innerPadding)

        NavHost(navController = navController, startDestination = NavigationScreens.MainScreenTeamsList.route, modifier.padding(innerPadding)){
            composable(route = NavigationScreens.MainScreenTeamsList.route) {
                TeamCardsList(navController = navController)
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

                    TeamDetailScreen(team = teamName, sport = sportName, league = leagueName,
                        sendButtonOnclick = { subject: String, summary: String -> shareTeamAndNextEvent(context, subject, summary) }) }


            composable(
                route = NavigationScreens.AthleteDetailScreen.route,
            ) {
               AthleteDetailScreen()
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