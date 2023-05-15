package com.sgut.android.nationalfootballleague.ui.screens.homelistscreen

import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel
import com.sgut.android.nationalfootballleague.homelistscreen.ArticleRow
import com.sgut.android.nationalfootballleague.ui.commoncomps.CardHeaderText
import com.sgut.android.nationalfootballleague.ui.commoncomps.NormalDivider
import com.sgut.android.nationalfootballleague.ui.commoncomps.SportScaffold
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.*
import com.sgut.android.nationalfootballleague.ui.navigation.NavigationScreens
import com.sgut.android.nationalfootballleague.ui.screens.standings_screen.Standings
import com.sgut.android.nationalfootballleague.ui.screens.teamdetails.HexToJetpackColor2
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.ATP
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASEBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASKETBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.CHAMPIONS
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.EPL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.FIFA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.FOOTBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.FRA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.HOCKEY
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.LA_LIGA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.MLB
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.MLS
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NBA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_BASEBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_BASKETBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_FOOTBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NFL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NHL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.SOCCER
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.TENNIS
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.UEFA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.WBC
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.WNBA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.XFL
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

    val news = uiState.currentNews

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()



    SportScaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            ToolBar3(
                title = sportStateLeagueName ?: "",
                scrollBehavior = scrollBehavior
            )
        },


        content = { padding ->
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {


                LazyRow(
                    contentPadding = padding,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(BASEBALL, MLB) }) {
                            Text(stringResource(R.string.MLB_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(BASKETBALL, NCAA_BASKETBALL) }) {
                            Text(stringResource(R.string.NCAA_mens_basketball),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(BASEBALL, MLB) }) {
                            Text(text = " WILLd",
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(SOCCER, FRA) }) {
                            Text(stringResource(R.string.fra),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(TENNIS, ATP) }) {
                            Text(stringResource(R.string.atp),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(BASKETBALL, NCAA_BASKETBALL) }) {
                            Text(stringResource(R.string.NCAA_mens_basketball),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(
                            onClick = {
                                homeListViewModel.setDifferentTeams(FOOTBALL, NFL)
                            }
                        ) {
                            Text(text = stringResource(R.string.NFL_League),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }
                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(HOCKEY, NHL) }) {
                            Text(stringResource(R.string.NHL_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(BASEBALL, WBC) }) {
                            Text(stringResource(R.string.WBC_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }



                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(BASKETBALL, NBA) }) {
                            Text(stringResource(R.string.NBA_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(BASKETBALL, WNBA) }) {
                            Text(stringResource(R.string.WNBA_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(SOCCER, CHAMPIONS)}) {
                            Text(stringResource(R.string.champions),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(FOOTBALL, NCAA_FOOTBALL) }) {
                            Text(stringResource(R.string.NCAA_football),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(BASEBALL, NCAA_BASEBALL) }) {
                            Text(stringResource(R.string.NCAA_baseball),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(SOCCER, MLS) }) {
                            Text(stringResource(R.string.MLS_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(SOCCER, FIFA) }) {
                            Text(stringResource(R.string.world_cup),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(SOCCER, LA_LIGA) }) {
                            Text(stringResource(R.string.la_liga),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(SOCCER, EPL) }) {
                            Text(stringResource(R.string.premier_league),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }
                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(SOCCER,
                            UEFA) }) {
                            Text(stringResource(R.string.euro_soccer),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }
                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(FOOTBALL,
                            XFL) }) {
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

                    TeamsListCircleRow(
                        teams = uiState.fullTeamInfo?.sport?.league?.teams ?: listOf(),
                        sport = uiState.currentSport,
                        league = uiState.fullTeamInfo?.sport?.league?.shortName ?: "",
                        onTeamClick = {},
                        navController = navController
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    NewsRow(news = news ?: ArticlesListModel(),
                        modifier = Modifier.wrapContentSize())

                    Spacer(modifier = Modifier.height(16.dp))


                    Standings(
                        sport = sport ?: "",
                        league = league ?: "",
                        type = "0"
                    )

                }
            }
        },

//        bottomBar = { BottomSportBar() },

    )
}


@Composable
fun TeamsListCircleRow(
    teams: List<TeamModel>,
    onTeamClick: () -> Unit,
    modifier: Modifier = Modifier,
    sport: String,
    league: String,
    navController: NavController,
) {

    DefaultCard(modifier = modifier) {
        CardHeaderText(text = league)
        NormalDivider()

        LazyRow(
            modifier = modifier,
            contentPadding = PaddingValues(8.dp)
        ) {
            items(teams) { team ->
                TeamItem(
                    team = team,
                    onTeamClick = onTeamClick,
                    modifier = modifier,
                    sport = sport,
                    league = league,
                    navController = navController
                )
            }
        }

    }


}

@Composable
fun NewsRow(news: ArticlesListModel, modifier: Modifier) {

    DefaultCard(modifier = modifier) {
        CardHeaderText(text = news.header)
        NormalDivider()
        ArticleRow(articleList = news.articles)
    }
}


@Composable
fun TeamItem(
    team: TeamModel,
    onTeamClick: () -> Unit,
    modifier: Modifier = Modifier,
    sport: String,
    league: String,
    navController: NavController,
) {
    val teamColor = HexToJetpackColor2.getColor(team.color)

    SportSurface(
        shape = MaterialTheme.shapes.medium,
        color = Color.LightGray

    ) {
        Box(modifier = modifier) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .clickable {
                        navController.navigate(
                            NavigationScreens.DetailScreenTeam.withArgs(
                                team.abbreviation,
                                sport,
                                league
                            )
                        )
                    }
                    .padding(4.dp)
            ) {
                BasicImage(
                    imgUrl = team.logos,
                    contentDescription = team.name,
                    modifier = modifier.size(100.dp),
                    elevation = 1.dp,
                    backgroundColor = teamColor,
                    borderColor = Color.Black,
                    borderWidth = 1.dp,
                    shape = RoundedCornerShape(8.dp)
                )
                Text(
                    text = team.displayName,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier.padding(top = 8.dp)
                )

            }
            ToggleFollowIconButton(
                isFollowed = team.isFavorite,
                onClick = { onTeamClick },
                modifier = Modifier.align(Alignment.TopEnd)
            )

        }
    }
}






