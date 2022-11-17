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


    Scaffold(
        topBar = {},
        content = { padding ->

            Column() {

                LazyRow(contentPadding = PaddingValues(16.dp)){
                   item { Button(onClick = { homeListViewModel.setFootballTeam() }) {
                        Text("NFL")
                    }}
                   item { Button(onClick = { homeListViewModel.setHockeyTeam() }) {
                        Text("NHL")
                    }}
                   item { Button(onClick = { homeListViewModel.setBaseballTeam() }) {
                        Text("MLB")
                    }}
                    item { Button(onClick = { homeListViewModel.setWnbaTeam() }) {
                        Text("WNBA")
                    }}

                    item { Button(onClick = { homeListViewModel.setMlsTeam() }) {
                        Text("MLS")
                    }}
                    item { Button(onClick = { homeListViewModel.setCollegeTeam() }) {
                        Text("College Football")
                    }}


                    item {
                        AssistChip(
                            onClick = { homeListViewModel.setBasketballTeam() },
                            label = { Text("Basketball") },

                            )
                    }

                }

                LazyColumn(contentPadding = PaddingValues(16.dp)) {
                    items(items = uiState.currentTeam) { team ->

                        TeamCard(team = team, modifier = Modifier.padding(8.dp), navController)
                    }
                }
            }
        },

        )
}


