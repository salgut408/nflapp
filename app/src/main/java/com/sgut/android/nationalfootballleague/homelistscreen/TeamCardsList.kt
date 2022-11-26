package com.sgut.android.nationalfootballleague.homelistscreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sgut.android.nationalfootballleague.commoncomposables.NavigationScreens

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
// Team Cards List Screen
fun TeamCardsList(
    navController: NavController,
    homeListViewModel: HomeListViewModel = hiltViewModel(),
//    onScoreboardClicked: () -> Unit,
//    onHockeyButtonClicked: () -> Unit
) {
//    val teamsList by remember { homeListViewModel.nflTeamsList }
//    val hockeyTeamsList by remember { homeListViewModel.hockeyTeamsList }
    // ^ Teams moved to listUiState current team list
    val uiState by homeListViewModel.listUiState.collectAsState()
    var sport = uiState.currentSport
    var league = uiState.currentLeague

    val scrollState = rememberScrollState()


    // if current sport is soccer -> radio group/buttons for different leagues

    Scaffold(
        topBar = {},
        content = { padding ->

            Column() {

                LazyRow(
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    ){

                   item { Button(onClick = { homeListViewModel.setFootballTeam() }) {
                        Text("NFL", style = MaterialTheme.typography.labelSmall)
                    }}
                   item { Button(onClick = { homeListViewModel.setHockeyTeam() }) {
                        Text("NHL", style = MaterialTheme.typography.labelSmall)
                    }}
                   item { Button(onClick = { homeListViewModel.setBaseballTeam() }) {
                        Text("MLB", style = MaterialTheme.typography.labelSmall)
                    }}

                    item { Button(onClick = { homeListViewModel.setBasketballTeam() }) {
                        Text("NBA", style = MaterialTheme.typography.labelSmall )
                    } }

                    item { Button(onClick = { homeListViewModel.setWnbaTeam() }) {
                        Text("WNBA", style = MaterialTheme.typography.labelSmall)
                    }}

                    item { Button(onClick = { homeListViewModel.setCollegeTeam() }) {
                        Text("College Football", style = MaterialTheme.typography.labelSmall)
                    }}

                    item { Button(onClick = { homeListViewModel.setMlsTeam() }) {
                        Text("MLS", style = MaterialTheme.typography.labelSmall)
                    }}

                    item { Button(onClick = {  }) {
                        Text("Mexican Soccer", style = MaterialTheme.typography.labelSmall)
                    }}

                    item { Button(onClick = {  }) {
                        Text("English Premier League", style = MaterialTheme.typography.labelSmall)
                    }}

                    item { Button(onClick = {  }) {
                        Text("Spanish Soccer", style = MaterialTheme.typography.labelSmall)
                    }}


                    item { Button(onClick = { homeListViewModel.setWorldCupTeam() }) {
                        Text("World Cup", style = MaterialTheme.typography.labelSmall )
                    } }
                }

                OutlinedButton(onClick = { navController.navigate(NavigationScreens.ScoreboardScreen.withArgs(sport,league)) }) {
                    Text("Scoreboard")
                }

                LazyColumn(contentPadding = PaddingValues(8.dp)) {

                    items(items = uiState.currentTeam) { team ->
                        Row(Modifier.animateItemPlacement()) {
                            TeamCard(team = team, modifier = Modifier.padding(8.dp), navController , sport =sport, league = league)

                        }
                    }

                }


            }
        },

        )
}


