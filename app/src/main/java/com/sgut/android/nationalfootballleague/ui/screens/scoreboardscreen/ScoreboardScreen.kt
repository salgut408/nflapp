package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.*
import com.sgut.android.nationalfootballleague.homelistscreen.ArticleRow
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.GenericImageLoader
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.TeamLogoScoreboardImageLoader
import com.sgut.android.nationalfootballleague.ui.navigation.NavigationScreens
import com.sgut.android.nationalfootballleague.ui.screens.teamdetails.HexToJetpackColor2
import com.sgut.android.nationalfootballleague.utils.*
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.FIRST_TEAM
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.SECOND_TEAM
import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreboardScreen(
    modifier: Modifier = Modifier,
    sport: String,
    league: String,
    scoreboardViewModel: ScoreboardViewModel = hiltViewModel(),
    navController: NavController,
) {

    scoreboardViewModel.loadGenericScoreboard(sport, league)

    val scoreboardUiState by scoreboardViewModel.scoreboardUiState.collectAsState()

//    TODO articles move to usecase
    val articles = scoreboardUiState.currentArticles




    val newUiState by scoreboardViewModel.newScoreboardModelState.collectAsState()
    val sport = newUiState.currentSport
    val league = newUiState.currentLeague

    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
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
                    .padding(8.dp)
            )

            Text(
                text = newUiState.scoreboardModelUiState.league?.abbreviation ?: "",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
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
    }
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


    events.map { events ->
        Card(modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
        ) {
            events.competitions.map {
                TeamComponent2(
                    compScoreboard = it,
                    modifier = Modifier,
                    navController = navController,
                    sport = sport,
                    league = league,
                )
            }
        }
    }


}

//@Composable
//fun EventsHeadLines(events: List<EventsScoreboard>) {
//    events.map {
//        it.competitions.map {
//            it.headlines.map {
//                Text(text = it.description ?: "")
//            }
//        }
//    }
//}

@Composable
fun EventsHeadLines(headlines: List<ScoreboardHeadlineModel>) {
    headlines.map { HeadLine(headline = it) }
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
fun WeekHeader() {

}


@Composable
fun TeamComponent2(
    compScoreboard: ScoreboardCompetitionModel,
    modifier: Modifier,
    navController: NavController,
    sport: String,
    league: String,

    ) {
    val team1 = compScoreboard.competitors[FIRST_TEAM].team
    val team2 = compScoreboard.competitors[SECOND_TEAM].team
    val color1 = HexToJetpackColor2.getColor(team1.color)
    val color2 = HexToJetpackColor2.getColor(team2.color)
    val team1Score = compScoreboard.competitors[FIRST_TEAM].score
    val team2Score = compScoreboard.competitors[SECOND_TEAM].score
    val whiteColor = Color.White

    val dateString = compScoreboard.date.toDate()?.formatTo("MMM-dd")
    val date = compScoreboard.date.toDate()?.formatTo("K:mm aa")

    Card(modifier = modifier

        .fillMaxSize()
        .clickable {
            navController.navigate(NavigationScreens.GameDetailScreen.withArgs(sport,
                league,
                compScoreboard.id ?: ""))
        }) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { }) {
                Text(text = "Notify me")
            }

            Icon(
                imageVector = Icons.Default.Info, contentDescription = "Match Preview",
                modifier = Modifier.clickable { }
            )
        }

        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
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

                        Spacer(modifier = modifier.padding(8.dp))

                        TeamLogoScoreboardImageLoader(team = team1)
                        Spacer(modifier = modifier.padding(8.dp))

                        Text(
                            text = team1.name,
                            style = TextStyle(fontSize = 12.sp),
                            textAlign = TextAlign.Left,
                            color = whiteColor
                        )

                        Spacer(modifier = modifier.padding(8.dp))

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
                        Spacer(modifier = modifier.padding(8.dp))

                        Text(
                            text = team2.name,
                            style = TextStyle(fontSize = 12.sp),
                            textAlign = TextAlign.Center,
                            color = whiteColor
                        )
                        Spacer(modifier = modifier.padding(8.dp))


                        TeamLogoScoreboardImageLoader(team = team2 )
                        Spacer(modifier = modifier.padding(8.dp))
                    }
                }

//                Game id for info or date
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = compScoreboard.status?.type?.description ?: "",
                        style = TextStyle(fontSize = 12.sp),
                        color = Color.White,
                        textAlign = TextAlign.Center)
                    Text(
                        text = dateString ?: "",
                        style = TextStyle(fontSize = 9.sp),
                        color = Color.White,
                        textAlign = TextAlign.Center)
                    Text(
                        text = date ?: "",
                        style = TextStyle(fontSize = 9.sp),
                        color = Color.White,
                        textAlign = TextAlign.Center)
                    Text(
                        text = compScoreboard.id ?: "",
                        style = TextStyle(fontSize = 9.sp),
                        color = Color.White,
                        textAlign = TextAlign.Center)

                }


            }
        }

    }
}


