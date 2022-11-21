package com.sgut.android.nationalfootballleague.commoncomposables

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sgut.android.nationalfootballleague.homelistscreen.TeamCardsList
import com.sgut.android.nationalfootballleague.teamdetails.TeamDetailScreen


// this can be used OR spread out like in scaffold in app fx

@Composable
//fun Navigation(navController: NavHostController, padding: PaddingValues) {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = NavigationScreens.MainScreenTeamsList.route, modifier = Modifier.padding(padding)){
//        composable(route = NavigationScreens.MainScreenTeamsList.route) {
//                TeamCardsList(navController = navController)
//        }
//        composable(
//            route = NavigationScreens.DetailScreenTeam.route + "/{teamName}",
//            arguments = listOf(
//                navArgument("teamName") {
//                    type = NavType.StringType
//                }
//
//        )
//
//        ) { entry ->
//            entry.arguments?.getString("teamName")?.let {
//                val context = LocalContext.current
//
//                TeamDetailScreen(team = it,
//                    sendButtonOnclick = {
//                            subject: String, summary: String ->
//                        shareTeamAndNextEvent2(context, subject, summary)
//                    })
//            }
//        }
//    }
//}




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