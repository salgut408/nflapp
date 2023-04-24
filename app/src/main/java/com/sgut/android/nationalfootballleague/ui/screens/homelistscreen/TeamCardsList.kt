package com.sgut.android.nationalfootballleague.ui.screens.homelistscreen

import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sgut.android.nationalfootballleague.R
import com.sgut.android.nationalfootballleague.di.ToolBar3
import com.sgut.android.nationalfootballleague.domain.domainmodels.FilterRepo
import com.sgut.android.nationalfootballleague.domain.domainmodels.filters
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel
import com.sgut.android.nationalfootballleague.ui.commoncomps.FilterBar
import com.sgut.android.nationalfootballleague.ui.commoncomps.SportScaffold
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.BasicButton
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.BasicCircleImage
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.SportSurface
import com.sgut.android.nationalfootballleague.ui.navigation.NavigationScreens
import com.sgut.android.nationalfootballleague.ui.screens.teamdetails.HexToJetpackColor2
import com.sgut.android.nationalfootballleague.utils.basicButton
import com.sgut.android.nationalfootballleague.R.string as AppText


//Home Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTeamCardsListScreen(
    navController: NavController,
    homeListViewModel: HomeListViewModel = hiltViewModel(),
) {

    val uiState by homeListViewModel.listUiState.collectAsState()
    val sport = uiState.fullTeamInfo?.sport?.slug
    val league = uiState.fullTeamInfo?.sport?.league?.slug

    val sportStateLeagueName = uiState.fullTeamInfo?.sport?.league?.name
    val sportStateTeamsFullInfo = uiState.fullTeamInfo

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    val categoryFilters = remember { FilterRepo.getFilters() }
    var filtersVisible by rememberSaveable { mutableStateOf(false) }


    SportScaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            Column() {
                ToolBar3(
                    title = sportStateLeagueName ?: "",
                    scrollBehavior = scrollBehavior
                )
                FilterBar(filters, onShowFilters = { filtersVisible = true })
            }
        },
        content = { padding ->
            Column() {


                LazyRow(
                    contentPadding = padding,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setBaseballTeams() }) {
                            Text(stringResource(R.string.MLB_league),
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
                        OutlinedButton(onClick = { homeListViewModel.setWbc() }) {
                            Text(stringResource(R.string.WBC_league),
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
                        OutlinedButton(onClick = { homeListViewModel.setChampionsTeam() }) {
                            Text(stringResource(R.string.champions),
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
                        OutlinedButton(onClick = { homeListViewModel.setCollegeBaseballTeams() }) {
                            Text(stringResource(R.string.NCAA_baseball),
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
                            NavigationScreens.ScoreboardScreen.withArgs(sport ?: "", league ?: "")
                        )
                    })

//                BasicButtonToNavigate(
//                    text = AppText.standings,
//                    modifier = Modifier.basicButton(),
//                    onNavigateTo = onNavigateTo,
//                    sport = sport ?: "",
//                    league = league?: ""
//                )


                if (sportStateTeamsFullInfo != null) {
                    TeamsListCircle(teams = uiState.fullTeamInfo?.sport?.league?.teams ?: listOf(),
                        onTeamClick = {})



                    ListOfTeams(
                        currentTeams = uiState.fullTeamInfo?.sport?.league?.teams ?: listOf(),
                        navController = navController,
                        league = uiState.currentLeague,
                        sport = uiState.currentSport,
                    )

                }
            }
        },
    )
}


@Composable
fun TeamsListCircle(
    teams: List<TeamModel>,
    onTeamClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
    ) {
        items(teams) { team ->
            TeamItem(team = team, onTeamClick = onTeamClick)
        }
    }
}

@Composable
fun TeamItem(
    team: TeamModel,
    onTeamClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val teamColor = HexToJetpackColor2.getColor(team.color)
    SportSurface(
        shape = MaterialTheme.shapes.medium,

        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .clickable(onClick = { onTeamClick(team.abbreviation) })
                .padding(4.dp)
        ) {
            BasicCircleImage(
                imgUrl = team.logos,
                contentDescription = team.name,
                modifier = modifier.size(100.dp),
                elevation = 10.dp,
                backgroundColor = teamColor,
                borderColor = Color.Black,
                borderWidth = 1.dp
            )
            Text(
                text = team.abbreviation,
                style = MaterialTheme.typography.labelSmall,
                modifier = modifier.padding(top = 8.dp)
            )
        }
    }
}






