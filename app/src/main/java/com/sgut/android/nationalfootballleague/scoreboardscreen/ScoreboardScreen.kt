package com.sgut.android.nationalfootballleague.scoreboardscreen

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sgut.android.nationalfootballleague.CompetitionsScoreboard
import com.sgut.android.nationalfootballleague.CompetitorsScoreboard
import com.sgut.android.nationalfootballleague.EventsScoreboard
import com.sgut.android.nationalfootballleague.TeamScoreboard
import com.sgut.android.nationalfootballleague.commoncomposables.TeamLogoScoreboardImageLoader
import com.sgut.android.nationalfootballleague.data.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.gamedetailscreen.DoughnutChart
import com.sgut.android.nationalfootballleague.gamedetailscreen.DoughnutChart2
import com.sgut.android.nationalfootballleague.gamedetailscreen.GameDetailViewModel
import com.sgut.android.nationalfootballleague.gamedetailscreen.MatchupPredictorGraph
import com.sgut.android.nationalfootballleague.homelistscreen.ArticleRow
import com.sgut.android.nationalfootballleague.teamdetails.HexToJetpackColor2
import com.sgut.android.nationalfootballleague.utils.basicButton
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreboardScreen(
    sport: String,
    league: String,
    scoreboardViewModel: ScoreboardViewModel = hiltViewModel(),
    gameDetailViewModel: GameDetailViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {

    scoreboardViewModel.loadGenericScoreboard(sport, league)

    gameDetailViewModel.loadGameDetails(sport, league, "401437916")

    val gameDetailUiState by gameDetailViewModel.gameDetailUiState.collectAsState()

    Log.e("GAMEDETAILUISTATE", gameDetailUiState.toString())

    val scoreboardUiState by scoreboardViewModel.scoreboardUiState.collectAsState()
    val events = scoreboardUiState.scoreboardUiStateEvents.events
    val leagues = scoreboardUiState.scoreboardUiStateEvents.leagues
    val articles = scoreboardUiState.currentArticles
    val week = scoreboardUiState.scoreboardUiStateEvents.week.week

    Column(
        modifier
            .verticalScroll(rememberScrollState())
//            .background()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        DoughnutChart2(
            gameDetailModel = gameDetailUiState.currentGameDetails ?: GameDetailModel(),
        )

//
        Text(text = gameDetailUiState.currentGameDetails?.gameInfo?.venue?.fullName ?: "49ERS Game api resp", )
//        Text(text = gameDetailUiState.teams[0].team?.name ?: "49ERS Game api resp", )

//        Text(text = gameDetailUiState.currentGameDetails?.predictor?.toString() ?: "49ERS Game", modifier = Modifier
//            .drawBehind {
//                drawRoundRect(
//                    Color(0xFFBBAAEE),
//                    cornerRadius = CornerRadius(10.dp.toPx())
//                )
//            }
//            .padding(8.dp))
//        Text(text = gameDetailUiState.currentGameDetails?.pickcenter?.getOrNull(0)?.details?: "49ERS Game")
        Text(text = gameDetailUiState.currentGameDetails?.gameInfo?.weather?.temperature.toString() ?: "49ERS Game")
//        Text(text = gameDeetUiState.currentGameDetails?.odds?.get(0)?.bettingOdds?.teamOdds?.preMatchTotalOver?.value?: "49ERS Game")
//


        Text(text = scoreboardUiState.scoreboardUiStateEvents.day?.date ?: "",
            style = MaterialTheme.typography.displayLarge)
        Text(leagues.getOrNull(0)?.name ?: "",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold)

        val leagueLogoPainter = rememberAsyncImagePainter(

            model = ImageRequest.Builder(LocalContext.current)
                .data(leagues.getOrNull(0)?.logos?.getOrNull(0)?.href)
                .crossfade(true)
                .crossfade(1000)
                .build()
        )
        Image(
            painter = leagueLogoPainter,
            contentDescription = leagues.getOrNull(0)?.name ?: "",
            modifier = Modifier
                .size(300.dp)
        )

        Row() { ArticleRow(articleList = articles) }

        when (scoreboardUiState.currentSport) {
            "football" -> OutlinedButton(onClick = {
                scoreboardViewModel.onYesterdayClick(sport, league, week) },
                modifier = Modifier.basicButton()) {
                Text(text = "Last Week")
            }
        }
        TeamsMatchUpListFromEvents(events, modifier)
    }
}


@Composable
fun TeamsMatchUpListFromEvents(events: List<EventsScoreboard>, modifier: Modifier) {
    for (i in events) {
        Card(modifier = modifier
            .padding(8.dp)
            .clickable { }
        ) {
            TeamComponent2(compScoreboard = i.competitions[0], modifier = Modifier)
        }
    }
}

@Composable
fun EventsHeadLines(events: List<EventsScoreboard>) {
    for (i in events) {
        for (j in i.competitions[0].headlines){
            Text(text = j.description.toString())
        }
    }

}

@Composable
fun TeamComponent(team: CompetitorsScoreboard, modifier: Modifier) {
    val color = HexToJetpackColor2.getColor(team.team?.color!!)


    Box(modifier = modifier
        .padding(16.dp)
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
            TeamLogoScoreboardImageLoader(team = team.team!!)


            if (team.winner == true) {
                Text(
                    text = team.team!!.name,
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
                    text = team.team!!.name,
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
fun TeamComponent2(compScoreboard: CompetitionsScoreboard, modifier: Modifier) {
    val team1 = compScoreboard.competitors[0].team
    val team2 = compScoreboard.competitors[1].team
    val color1 = HexToJetpackColor2.getColor(team1!!.color)
    val color2 = HexToJetpackColor2.getColor(team2!!.color)
    val team1Score = compScoreboard.competitors[0].score
    val team2Score = compScoreboard.competitors[1].score
    val whiteColor = Color.White

    Card(modifier = modifier.fillMaxSize()) {

        Box(modifier = modifier
            .padding(8.dp)
            .background(Brush.horizontalGradient(
                listOf(color1, color2)
            ))
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
                        TeamLogoScoreboardImageLoader(team = team1 ?: TeamScoreboard())
                        Spacer(modifier = modifier.padding(8.dp))

                        Text(
                            text = team1.name,
                            style = TextStyle(fontSize = 12.sp),
                            textAlign = TextAlign.Left,
                            color = whiteColor
                        )

                        Spacer(modifier = modifier.padding(8.dp))

                        Text(
                            text = team1Score.toString(),
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
                            text = team2Score.toString(),
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


                        TeamLogoScoreboardImageLoader(team = team2 ?: TeamScoreboard())

                        Spacer(modifier = modifier.padding(8.dp))


                    }


                }
//            Text(text = compScoreboard.status?.type?.shortDetail ?: "",
//                style = TextStyle(fontSize = 12.sp),
//                color = Color.White,
//                textAlign = TextAlign.Center)

                Text(text = compScoreboard.id ?: "",
                    style = TextStyle(fontSize = 12.sp),
                    color = Color.White,
                    textAlign = TextAlign.Center)


            }


        }

    }
}

