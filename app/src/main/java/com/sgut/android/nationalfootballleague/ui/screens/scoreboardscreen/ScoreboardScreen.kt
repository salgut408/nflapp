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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.di.ToolBar2
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.*
import com.sgut.android.nationalfootballleague.homelistscreen.ArticleRow
import com.sgut.android.nationalfootballleague.ui.commoncomps.EIGHT
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.DefaultCard
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.GenericImageLoader
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.SpacerDp
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.TeamLogoScoreboardImageLoader
import com.sgut.android.nationalfootballleague.ui.navigation.NavigationScreens
import com.sgut.android.nationalfootballleague.ui.screens.standings_screen.Standings
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

//    val scoreboardUiState by scoreboardViewModel.scoreboardUiState.collectAsState()


    val newUiState by scoreboardViewModel.newScoreboardModelState.collectAsState()
    val articles = newUiState.currentArticles
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())


    val sport = newUiState.currentSport
    val league = newUiState.currentLeague


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            ToolBar2(
                title = newUiState.scoreboardModelUiState.league?.name ?: "",
                canNavigateBack = canNavigateBack,
                navigateUp = navigateUp,
                scrollBehavior = scrollBehavior)
        },
        content = { innerPadding ->
            Column(
                modifier
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.background),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                Text(
                    text = newUiState.scoreboardModelUiState.day ?: ""
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = newUiState.scoreboardModelUiState.league?.name ?: "",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 4,
                        overflow = TextOverflow.Visible,
                        lineHeight = 40.sp,
                        modifier = Modifier
                            .width(200.dp)
                    )


                    GenericImageLoader(
                        obj = newUiState.scoreboardModelUiState.league?.logos?.get(0)?.href ?: "",
                        modifier = Modifier.fillMaxSize()
                    )
                }


                Row() { ArticleRow(articleList = articles) }

//        TODO take out nav navController
                TeamsMatchUpListFromEvents(
                    newUiState.scoreboardModelUiState.events,
                    modifier,
                    sport,
                    league,
                    navController
                )

                Standings(sport = sport, league = league, type = "0")

            }
        }

    )
}


//        TODO do

@Composable
fun MatchPreview() {

}


@Composable
fun TeamsMatchUpListFromEvents(
    events: List<ScoreboardEventModel>,
    modifier: Modifier,
    sport: String,
    league: String,
    navController: NavController,
) {


    events.map { event ->

        event.competitions.map {

            TeamComponent2(
                compScoreboard = it,
                modifier = modifier,
                navController = navController,
                sport = sport,
                league = league,
            )
            SpacerDp(modifier = modifier, height = 8)

        }

    }
}


@Composable
fun Record(record: ScoreboardRecordModel) {
    Row() {
        Text(text = record.name)
        Text(text = " - ")
        Text(text = record.summary)
    }
}

@Composable
fun CompetitorRecords(records: List<ScoreboardRecordModel>) {
    records.map { Record(record = it) }
}

@Composable
fun EventName(event: ScoreboardEventModel) {
    Text(
        event.shortName,
        style = MaterialTheme.typography.headlineMedium
    )
}


@Composable
fun Competitor(competitor: ScoreboardCompetitorsModel) {
    Row() {
        Text(text = competitor.team.name)
        Text(text = " - ")
        Text(text = competitor.score)
    }

}

@Composable
fun QuickGlance(competition: ScoreboardCompetitionModel) {
    Card() {
        Competition(competition = competition)

    }
}

@Composable
fun Competition(competition: ScoreboardCompetitionModel) {
    Text(text = competition.status?.displayClock ?: "")
    competition.competitors.map { competitor ->
        Row(verticalAlignment = Alignment.Top) {
            Competitor(competitor = competitor)
            Spacer(modifier = Modifier.width(20.dp))
            Column(verticalArrangement = Arrangement.Center) {
                CompetitorRecords(competitor.records)

            }
        }


    }
}


@Composable
fun HeadLine(headline: ScoreboardHeadlineModel) {
    Row() {
        Text(text = headline.type)
        Column() {
            Text(text = headline.description)
        }
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



