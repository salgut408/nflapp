package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details.SituationScoreboard
import com.sgut.android.nationalfootballleague.di.TopAppBarWithLogo
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.*
import com.sgut.android.nationalfootballleague.ui.commoncomps.CardHeaderText
import com.sgut.android.nationalfootballleague.ui.commoncomps.EIGHT
import com.sgut.android.nationalfootballleague.ui.commoncomps.NormalDivider
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.BasicImage
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.DefaultCard
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.SpacerDp
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.TeamLogoScoreboardImageLoader
import com.sgut.android.nationalfootballleague.ui.navigation.NavigationScreens
import com.sgut.android.nationalfootballleague.ui.screens.homelistscreen.NewsRow
import com.sgut.android.nationalfootballleague.ui.screens.teamdetails.HexToJetpackColor2
import com.sgut.android.nationalfootballleague.utils.*
import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreboardScreen(
    modifier: Modifier = Modifier,
    sport: String,
    league: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    scoreboardViewModel: ScoreboardViewModel = hiltViewModel(),
    navController: NavController,
) {

    scoreboardViewModel.loadGenericScoreboard(sport, league)


    val newUiState by scoreboardViewModel.scoreboardModelState.collectAsState()
    val news = newUiState.currentArticles
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val sport = newUiState.currentSport
    val league = newUiState.currentLeague


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {

            TopAppBarWithLogo(
                title = newUiState.scoreboardModelUiState.league?.abbreviation ?: "",
                logo = newUiState.scoreboardModelUiState.league?.logos?.first()?.href ?: "",
                canNavigateBack = canNavigateBack,
                navigateUp = navigateUp,
                scrollBehavior = scrollBehavior
            )

        },
        content = { innerPadding ->
            Column(
                modifier = modifier
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.background),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = { }) {
                    Text(text = "MLB")
                }

                Scoreboard(
                    events = newUiState.scoreboardModelUiState.events,
                    modifier = modifier,
                    sport = sport,
                    league = league,
                    navController = navController
                )


                Spacer(modifier = modifier.height(16.dp))

                NewsRow(news = news ?: ArticlesListModel(), modifier = modifier.wrapContentSize())

                Spacer(modifier = modifier.height(16.dp))


            }
        }

    )
}


//        TODO do

@Composable
fun MatchPreview() {

}

@Composable
fun Scoreboard(
    events: List<ScoreboardEventModel>,
    sport: String,
    league: String,
    navController: NavController,
    modifier: Modifier,

    ) {
    DefaultCard(modifier = modifier
    ) {
        CardHeaderText(text = "Scoreboard")
        NormalDivider()
        events.map { event ->

            NewEventMatchup(
                event = event,
                modifier = modifier,
                sport = sport,
                league = league,
                navController = navController
            )
            NormalDivider()

        }
    }
}


@Composable
fun TeamsMatchUpListFromEvents(
    events: List<ScoreboardEventModel>,
    modifier: Modifier,
    sport: String,
    league: String,
    navController: NavController,
) {
    DefaultCard(modifier = modifier) {
        CardHeaderText(text = "Scores")
        events.map { event ->
            event.competitions.map { competition ->
                TeamComponent2(
                    compScoreboard = competition,
                    modifier = modifier,
                    navController = navController,
                    sport = sport,
                    league = league,
                )
            }
        }
    }
}


@Composable
fun Record(record: ScoreboardRecordModel) {
    Row() {
        Text(text = record.name)
    }
}


@Composable
fun TeamComponent(team: ScoreboardCompetitorsModel, modifier: Modifier) {
    val color = HexToJetpackColor2.getColor(team.team.color)

    Box(modifier = modifier
        .padding(8.dp)
        .background(Brush.horizontalGradient(
            listOf(color, Color.White)
        ))
        .fillMaxWidth(3f)) {


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            TeamLogoScoreboardImageLoader(team = team.team)


            if (team.winner == true) {
                Text(
                    text = team.team.name,
                    style = TextStyle(fontSize = 20.sp),
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = team.score.toString(),
                    style = TextStyle(fontSize = 20.sp),
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold
                )
            } else {

                Text(
                    text = team.team.name,
                    style = TextStyle(fontSize = 20.sp),
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = team.score.toString(),
                    style = TextStyle(fontSize = 20.sp),
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Light
                )
            }
        }

    }
}


@Composable
fun TeamComponent2(
    compScoreboard: ScoreboardCompetitionModel,
    modifier: Modifier,
    navController: NavController,
    sport: String,
    league: String,

    ) {
    val team1 = compScoreboard.competitors.first().team
    val team2 = compScoreboard.competitors.last().team
    val color1 = HexToJetpackColor2.getColor(team1.color)
    val color2 = HexToJetpackColor2.getColor(team2.color)
    val team1Score = compScoreboard.getHomeTeam().score
    val team2Score = compScoreboard.getAwayTeam().score
    val whiteColor = Color.White


    val date = compScoreboard.date.toDate()?.formatTo("K:mm aa")

    DefaultCard(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(NavigationScreens.GameDetailScreen.withArgs(sport,
                    league,
                    compScoreboard.id))
            }) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        listOf(color1, color2)
                    )
                )
                .fillMaxWidth(3f)) {

            Surface(color = Color.LightGray.copy(alpha = 0.3f), modifier = modifier.fillMaxSize()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {

                        SpacerDp(modifier = modifier, width = EIGHT)
                        TeamLogoScoreboardImageLoader(team = team1)
                        SpacerDp(modifier = modifier, width = EIGHT)

                        Text(
                            text = team1.abbreviation,
                            style = TextStyle(fontSize = 12.sp),
                            textAlign = TextAlign.Left,
                            color = whiteColor
                        )

                        SpacerDp(modifier = modifier, width = EIGHT)

                        Text(
                            text = team1Score,
                            style = TextStyle(fontSize = 12.sp),
                            textAlign = TextAlign.Left,
                            fontWeight = FontWeight.Bold,
                            color = whiteColor

                        )
                    }
                }

                Column(horizontalAlignment = Alignment.Start) {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {

                        Text(
                            text = team2Score,
                            style = TextStyle(fontSize = 12.sp),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = whiteColor
                        )
                        SpacerDp(modifier = modifier, width = EIGHT)

                        Text(
                            text = team2.abbreviation,
                            style = TextStyle(fontSize = 12.sp),
                            textAlign = TextAlign.Center,
                            color = whiteColor
                        )
                        SpacerDp(modifier = modifier, width = EIGHT)
                        TeamLogoScoreboardImageLoader(team = team2)
                        SpacerDp(modifier = modifier, width = EIGHT)
                    }
                }
//                Game id for info or date

                GameInfoColumn(
                    description = compScoreboard.status?.type?.description ?: "",
                    date = date ?: "",
                    id = compScoreboard.id
                )
            }
        }
    }
}

@Composable
fun GameInfoColumn(description: String, date: String, id: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = description,
            style = TextStyle(fontSize = 12.sp),
            color = Color.White,
            textAlign = TextAlign.Center)
        Text(
            text = date,
            style = TextStyle(fontSize = 9.sp),
            color = Color.White,
            textAlign = TextAlign.Center)
        Text(
            text = id,
            style = TextStyle(fontSize = 9.sp),
            color = Color.White,
            textAlign = TextAlign.Center)
    }
}


@Composable
fun CompetitorRowPre(competitor: ScoreboardCompetitorsModel, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BasicImage(
                imgUrl = competitor.team.logo,
                contentDescription = competitor.team.name,
                elevation = 0.dp,
                backgroundColor = Color.Transparent,
                borderWidth = 0.dp,
                borderColor = Color.Transparent,
                shape = MaterialTheme.shapes.extraSmall,
                modifier = modifier
                    .size(30.dp)
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(text = competitor.team.shortDisplayName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp)
        }

        Row() {
            Text(text = competitor.records.getOrNull(0)?.summary ?: "")
        }

    }
}


@Composable
fun CompetitorRow(
    competitor: ScoreboardCompetitorsModel,
    modifier: Modifier,
    content: @Composable () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BasicImage(
                imgUrl = competitor.team.logo,
                contentDescription = competitor.team.name,
                elevation = 0.dp,
                backgroundColor = Color.Transparent,
                borderWidth = 0.dp,
                borderColor = Color.Transparent,
                shape = MaterialTheme.shapes.extraSmall,
                modifier = modifier
                    .size(30.dp)
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(text = competitor.team.shortDisplayName,
                fontWeight = if (competitor.winner) FontWeight.Bold else FontWeight.Normal,
                fontSize = 16.sp)
        }

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
//            Text(text = competitor.score,  fontSize = 16.sp)
            content()
        }

    }
}


@Composable
fun NewEventMatchup(
    event: ScoreboardEventModel,
    modifier: Modifier,
    navController: NavController,
    sport: String,
    league: String,
) {
    Column() {
        Box(modifier = modifier.clickable {
            navController.navigate(
                NavigationScreens.GameDetailScreen.withArgs(sport, league, event.id)
            )
        }) {
            Column() {
                Text(text = event.competitions.first().id.toString())
                if (sport.equals("baseball") && event.status.type?.state == StatusState.IN) {
                    CompetitionSituation(
                        event.competitions.first().situation,
                        modifier = modifier
                    )
                }
                CompetitorRow(
                    competitor = event.competitions.first().competitors.last(),
                    modifier = modifier,
                    content = {
                        Text(
                            text = if (event.status.type?.state == StatusState.PRE) event.competitions.first().competitors.last().records.getOrNull(
                                0)?.summary ?: ""
                            else event.competitions.first().competitors.last().score)
                    }
                )


                CompetitorRow(
                    competitor = event.competitions.first().competitors.first(),
                    modifier = modifier,
                    content = {
                        Text(
                            text = if (event.status.type?.state == StatusState.PRE) event.competitions.first().competitors.first().records.getOrNull(
                                0)?.summary ?: ""
                            else event.competitions.first().competitors.first().score)
                    }
                )
            }
            Text(text = event.competitions.first().status?.type?.shortDetail ?: "",
                modifier = modifier.align(
                    Alignment.TopCenter),
                fontWeight = FontWeight.Bold)


        }
    }
}


@Composable
fun CompetitionSituation(situation: SituationScoreboard, modifier: Modifier) {

    Text(text = "Balls: ${situation.balls.toString()} Strikes: ${situation.strikes.toString()} Outs: ${situation.outs.toString()}")

}

//
//@Composable
//fun CompetitorRow(event: EventScoreboard, modifier: Modifier) {
//    Row(modifier = modifier) {
//        BasicImage(
//            imgUrl = event.competitions.first().competitors .team.logo,
//            contentDescription = competitor.team.name,
//            elevation = 0.dp,
//            backgroundColor = Color.Transparent,
//            borderWidth = 0.dp,
//            borderColor = Color.Transparent,
//            shape = MaterialTheme.shapes.extraSmall
//        )
//        Spacer(modifier = modifier.width(8.dp))
//        Text(text = competitor.team.displayName)
//    }
//}


