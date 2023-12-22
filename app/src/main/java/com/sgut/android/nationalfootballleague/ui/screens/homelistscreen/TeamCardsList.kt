package com.sgut.android.nationalfootballleague.ui.screens.homelistscreen

import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.sgut.android.nationalfootballleague.R
import com.sgut.android.nationalfootballleague.di.ToolBar3
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel
import com.sgut.android.nationalfootballleague.homelistscreen.ArticleRow
import com.sgut.android.nationalfootballleague.ui.commoncomps.CardHeaderText
import com.sgut.android.nationalfootballleague.ui.commoncomps.NormalDivider
import com.sgut.android.nationalfootballleague.ui.commoncomps.SportScaffold
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.BasicButton
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.BasicImage
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.DefaultCard
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.SportSurface
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.ToggleFollowIconButton
import com.sgut.android.nationalfootballleague.ui.navigation.NavigationScreens
import com.sgut.android.nationalfootballleague.ui.screens.standings_screen.Standings
import com.sgut.android.nationalfootballleague.ui.screens.teamdetails.HexToJetpackColor2
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.ATP
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASEBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASKETBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.CHAMPIONS
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.EPL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.F1
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
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.RACING
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

    val uiState by homeListViewModel.listUiState.collectAsStateWithLifecycle()
    val sport = uiState.fullTeamInfo?.sport?.slug
    val league = uiState.fullTeamInfo?.sport?.league?.slug
    val sportStateLeagueName = uiState.fullTeamInfo?.sport?.league?.name
    val sportStateTeamsFullInfo = uiState.fullTeamInfo
    val news = uiState.currentNews
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val errorMessage = homeListViewModel.errorMessage.collectAsStateWithLifecycle()
    
    if (errorMessage.value != null) {
        showToast(message = errorMessage.value!!)
    }

   Log.e("HomeTeamCardsListScreen", "HomeTeamCardsListScreen")

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
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(BASEBALL, MLB)
                        }) {
                            LabelText(stringResId = R.string.MLB_league)
                        }
                    }
                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(BASKETBALL, NCAA_BASKETBALL)
                        }) {
                            Text(stringResource(R.string.NCAA_mens_basketball),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }
                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(SOCCER, FRA)
                        }) {
                            LabelText(stringResId = R.string.fra)
                        }
                    }
                    item {
                        OutlinedButton(onClick = { homeListViewModel.setDifferentTeams(TENNIS, ATP) }) {
                            Text(stringResource(R.string.atp),
                                style = MaterialTheme.typography.labelSmall)
                        }
                    }
                    item {
                        OutlinedButton(
                            onClick = {
                                homeListViewModel.setDifferentTeams(FOOTBALL, NFL)
                            }
                        ) {
                            LabelText(stringResId = R.string.NFL_League)
                        }
                    }
                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(HOCKEY,
                                NHL)
                        }) {
                            LabelText(stringResId = R.string.NHL_league)
                        }
                    }
                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(BASEBALL,
                                WBC)
                        }) {
                            LabelText(stringResId = R.string.WBC_league)

                        }
                    }

                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(BASKETBALL,
                                NBA)
                        }) {
                            LabelText(stringResId = R.string.NBA_league)
                        }
                    }

                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(BASKETBALL, WNBA)
                        }) {
                            LabelText(stringResId = R.string.WNBA_league)

                        }
                    }

                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(SOCCER, CHAMPIONS)
                        }) {
                            LabelText(stringResId = R.string.champions)
                        }
                    }

                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(FOOTBALL,
                                NCAA_FOOTBALL)
                        }) {
                            LabelText(stringResId = R.string.NCAA_football)
                        }
                    }

                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(BASEBALL,
                                NCAA_BASEBALL)
                        }) {
                            LabelText(stringResId = R.string.NCAA_baseball)
                        }
                    }

                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(SOCCER, MLS)
                        }) {
                            LabelText(stringResId = R.string.MLS_league)
                        }
                    }

                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(SOCCER, FIFA)
                        }) {
                            LabelText(stringResId = R.string.world_cup)
                        }
                    }
                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(SOCCER,
                                LA_LIGA)
                        }) {
                            LabelText(stringResId = R.string.la_liga)
                        }
                    }

                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(SOCCER, EPL)
                        }) {
                            LabelText(stringResId = R.string.premier_league)
                        }
                    }
                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(SOCCER, UEFA)
                        }) {
                            LabelText(stringResId = R.string.euro_soccer)
                        }
                    }
                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(FOOTBALL, XFL)
                        }) {
                            LabelText(stringResId = R.string.XFL_League)
                        }
                    }
                    item {
                        OutlinedButton(onClick = {
                            homeListViewModel.setDifferentTeams(RACING, F1)
                        }) {
                            LabelText(stringResId = R.string.F1_RACING)
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

                    ElasticDraggableBox()

                }
            }
        },

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
fun LabelText(@StringRes stringResId: Int) {
    val resources = LocalContext.current.resources
    Text(
        text = stringResource(id = stringResId),
        style = MaterialTheme.typography.labelSmall
    )
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


            }
            ToggleFollowIconButton(
                isFollowed = team.isFavorite,
                onClick = { onTeamClick },
                modifier = Modifier.align(Alignment.TopEnd)
            )

        }
    }
}

@Composable
fun showToast(message: String) {
    Toast.makeText(LocalContext.current, message, Toast.LENGTH_LONG).show()
}

@Composable
fun ElasticDraggableBox() {
    var animatableOffset by remember { mutableStateOf(Animatable(0f)) }

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFFFA732)), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .offset(y = animatableOffset.value.dp)
                .draggable(
                    orientation = Orientation.Vertical,
                    state = rememberDraggableState { delta ->
                        animatableOffset = Animatable(animatableOffset.value + delta)
                    },
                    onDragStopped = {
                        animatableOffset.animateTo(0f, animationSpec = spring())
                    }
                )
                .size(350.dp),
            contentAlignment = Alignment.Center
        ) {
            // replace with an image lol
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "heart",
                modifier = Modifier.size(animatableOffset.value.dp + 150.dp),
                tint = Color.Red
            )
        }
    }
}


