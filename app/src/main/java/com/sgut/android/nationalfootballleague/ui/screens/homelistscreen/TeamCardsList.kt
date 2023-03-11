package com.sgut.android.nationalfootballleague.ui.screens.homelistscreen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sgut.android.nationalfootballleague.R
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.FullTeamsListsModel
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.BasicButton
import com.sgut.android.nationalfootballleague.ui.navigation.NavigationScreens
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

//    homeListViewModel.g

    val uiState by homeListViewModel.listUiState.collectAsState()
    val sport = uiState.currentSport
    val league = uiState.currentLeague

    val sportStateSportName = uiState.fullTeamInfo?.sport?.name
    val sportStateLeagueName = uiState.fullTeamInfo?.sport?.league?.name
    val sportStateTeamsFullInfo = uiState.fullTeamInfo

    Log.d("SPORT FULL INFO", sportStateSportName.toString())
    val scrollState = rememberScrollState()

    Scaffold(
        content = { padding ->

            Column() {
                

                LazyRow(
                    contentPadding = padding,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {

                    item {
                        OutlinedButton(
                            onClick = {
                                homeListViewModel.setFootballTeams()
                            }
                        ) {
                            Text(text = stringResource(R.string.NFL_League),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }
                    item {
                        OutlinedButton(onClick = { homeListViewModel.setHockeyTeams() }) {
                            Text(stringResource(R.string.NHL_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }
                    item {
                        OutlinedButton(onClick = { homeListViewModel.setBaseballTeams() }) {
                            Text(stringResource(R.string.MLB_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setBasketballTeams() }) {
                            Text(stringResource(R.string.NBA_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setWnbaTeams() }) {
                            Text(stringResource(R.string.WNBA_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setCollegeTeams() }) {
                            Text(stringResource(R.string.NCAA_football),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setCollegeBasketballTeams() }) {
                            Text(stringResource(R.string.NCAA_mens_basketball),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setMlsTeams() }) {
                            Text(stringResource(R.string.MLS_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setWorldCupTeams() }) {
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
                    item {
                        OutlinedButton(onClick = { homeListViewModel.setXflTeams() }) {
                            Text(stringResource(R.string.XFL_League),
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

                BasicButton(
                    text = AppText.standings,
                    modifier = Modifier.basicButton(),
                    action = {
                        navController.navigate(
                            NavigationScreens.ScoreboardScreen.withArgs(sport, league)
                        )
                    })

                sportStateTeamsFullInfo?.let { TEAMSLISTWITHLEAGUE(fullTeamsListsModel = it) }


                if (sportStateTeamsFullInfo != null) {
                    ListOfTeams(
                        currentTeams = uiState.fullTeamInfo?.sport?.league?.teams ?: listOf(),
                        navController = navController,
                        uiLeague = uiState.currentLeague,
                        uiSport = uiState.currentSport,
                        sportStateTeamsFullInfo = sportStateTeamsFullInfo
                    )
                }

            }
        },

        )
}


@Composable
fun TEAMSLISTWITHLEAGUE(fullTeamsListsModel: FullTeamsListsModel) {

      Text(
          text = fullTeamsListsModel.sport.name,
          style = MaterialTheme.typography.bodyLarge
      )
          Text(text = fullTeamsListsModel.sport.league?.name ?: "")
          Text(text = fullTeamsListsModel.sport.league?.abbreviation ?: "")
}

