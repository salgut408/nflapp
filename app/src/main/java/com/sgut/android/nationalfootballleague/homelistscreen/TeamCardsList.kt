package com.sgut.android.nationalfootballleague.homelistscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.loader.content.Loader
import androidx.navigation.NavController
import com.sgut.android.nationalfootballleague.di.MainToolBar
import com.sgut.android.nationalfootballleague.di.MyNewToolBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
// Team Cards List Screen
fun TeamCardsList(
    navController: NavController,
    homeListViewModel: HomeListViewModel = hiltViewModel(),
//    onHockeyButtonClicked: () -> Unit
) {
//    val teamsList by remember { homeListViewModel.nflTeamsList }
//    val hockeyTeamsList by remember { homeListViewModel.hockeyTeamsList }
    // ^ Teams moved to listUiState current team list
    val uiState by homeListViewModel.listUiState.collectAsState()
    var sport = uiState.currentSport
    var league = uiState.currentLeague


    Scaffold(
        topBar = {},
        content = { padding ->

            Column() {

                LazyRow(
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),

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
                    item { Button(onClick = { homeListViewModel.setWnbaTeam() }) {
                        Text("WNBA", style = MaterialTheme.typography.labelSmall)
                    }}

                    item { Button(onClick = { homeListViewModel.setMlsTeam() }) {
                        Text("MLS", style = MaterialTheme.typography.labelSmall)
                    }}
                    item { Button(onClick = { homeListViewModel.setCollegeTeam() }) {
                        Text("College Football", style = MaterialTheme.typography.labelSmall)
                    }}
                    item { Button(onClick = { homeListViewModel.setBasketballTeam() }) {
                        Text("NBA", style = MaterialTheme.typography.labelSmall )
                    } }
                }

                LazyColumn(contentPadding = PaddingValues(16.dp)) {
                    items(items = uiState.currentTeam) { team ->

                        TeamCard(team = team, modifier = Modifier.padding(8.dp), navController , sport =sport, league = league)
                    }
                }
            }
        },

        )
}


