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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sgut.android.nationalfootballleague.R
import com.sgut.android.nationalfootballleague.commoncomposables.BasicButton
import com.sgut.android.nationalfootballleague.commoncomposables.NavigationScreens
import com.sgut.android.nationalfootballleague.di.DrawerTopAppBar
import com.sgut.android.nationalfootballleague.utils.basicButton
import com.sgut.android.nationalfootballleague.R.string as AppText


//Home Screen
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeTeamCardsListScreen(
    navController: NavController,
    homeListViewModel: HomeListViewModel = hiltViewModel(),
    openDrawer: () -> Unit,


    ) {
    val uiState by homeListViewModel.listUiState.collectAsState()
    val sport = uiState.currentSport
    val league = uiState.currentLeague

    val scrollState = rememberScrollState()

    Scaffold(
        content = { padding ->

            Column() {

                DrawerTopAppBar(
                    openDrawer = openDrawer,
                    onNhlClick = { homeListViewModel.setHockeyTeam() },
                    onNflClick = { homeListViewModel.setFootballTeam() },
                    onMlbClick = { homeListViewModel.setBaseballTeam() },
                    onNbaClick = { homeListViewModel.setBasketballTeam() },
                    onWnbaClick = { homeListViewModel.setWnbaTeam() },
                    onNcaaFootballClick = { homeListViewModel.setCollegeTeam() }
                )

                LazyRow(
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {


                    item {
                        FilledTonalButton(onClick = { homeListViewModel.setFootballTeam() }) {
                            Text(text = stringResource(R.string.NFL_League),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }
                    item {
                        OutlinedButton(onClick = { homeListViewModel.setHockeyTeam() }) {
                            Text(stringResource(R.string.NHL_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }
                    item {
                        OutlinedButton(onClick = { homeListViewModel.setBaseballTeam() }) {
                            Text(stringResource(R.string.MLB_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setBasketballTeam() }) {
                            Text(stringResource(R.string.NBA_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setWnbaTeam() }) {
                            Text(stringResource(R.string.WNBA_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setCollegeTeam() }) {
                            Text(stringResource(R.string.NCAA_football),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setCollegeBasketballTeam() }) {
                            Text(stringResource(R.string.NCAA_mens_basketball),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setMlsTeam() }) {
                            Text(stringResource(R.string.MLS_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setWorldCupTeam() }) {
                            Text(stringResource(R.string.world_cup),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setLaLigaTeams() }) {
                            Text(stringResource(R.string.la_liga),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setEnglishTeams() }) {
                            Text(stringResource(R.string.premier_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }
                    item {
                        OutlinedButton(onClick = { homeListViewModel.setEuroTeams() }) {
                            Text(stringResource(R.string.euro_soccer),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                }

                BasicButton(
                    text = AppText.scores_games,
                    modifier = Modifier.basicButton(),
                    action = {
                        navController.navigate(
                            NavigationScreens.ScoreboardScreen.withArgs(sport, league)
                        )
                    })


                LazyColumn(contentPadding = PaddingValues(8.dp)) {

                    items(items = uiState.currentTeams) { team ->
                        Row(Modifier.animateItemPlacement()) {
                            TeamCard(
                                team = team,
                                modifier = Modifier.padding(8.dp),
                                navController,
                                sport = sport,
                                league = league
                            )
                        }
                    }
                }
            }
        },

        )
}


