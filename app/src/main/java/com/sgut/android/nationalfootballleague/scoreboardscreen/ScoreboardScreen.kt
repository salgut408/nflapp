package com.sgut.android.nationalfootballleague.scoreboardscreen

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import com.sgut.android.nationalfootballleague.R.string as AppText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sgut.android.nationalfootballleague.CompetitionsScoreboard
import com.sgut.android.nationalfootballleague.CompetitorsScoreboard
import com.sgut.android.nationalfootballleague.TeamScoreboard
import com.sgut.android.nationalfootballleague.commoncomposables.BasicButton
import com.sgut.android.nationalfootballleague.commoncomposables.TeamLogoImageloadiner2
import com.sgut.android.nationalfootballleague.commoncomposables.TeamLogoScoreboardImageLoader
import com.sgut.android.nationalfootballleague.homelistscreen.ArticleCard
import com.sgut.android.nationalfootballleague.homelistscreen.ArticleList
import com.sgut.android.nationalfootballleague.homelistscreen.ArticleRow
import com.sgut.android.nationalfootballleague.teamdetails.HexToJetpackColor2
import com.sgut.android.nationalfootballleague.utils.basicButton
import com.sgut.android.nationalfootballleague.utils.card
import com.sgut.android.nationalfootballleague.utils.spacer
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreboardScreen(
    sport: String,
    league: String,
    scoreboardViewModel: ScoreboardViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {

    scoreboardViewModel.loadGenericScoreboard(sport, league)
    val scoreboardUiState by scoreboardViewModel.scoreboardUiState.collectAsState()
    Log.e("scoreboard state scrn", scoreboardUiState.scoreboardUiStateEvents.toString())
    val events = scoreboardUiState.scoreboardUiStateEvents.events
    val leagues = scoreboardUiState.scoreboardUiStateEvents.leagues
    val articles = scoreboardUiState.currentArticles

    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(text = scoreboardUiState.scoreboardUiStateEvents.day?.date ?: "",
            style = MaterialTheme.typography.displayLarge)
        Text(leagues.getOrNull(0)?.name ?: "", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)

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



        for (i in events) {
            for (j in i.competitions[0].headlines) {
                Text(text = j.description.toString())
            }
        }





        for (i in events) {
            Card(modifier
                .padding(8.dp)
                .clickable {}
            ) {

//                BasicButton(text = AppText.watc, modifier = Modifier.basicButton()) { }
//                Text(text = i.name ?: "", style = MaterialTheme.typography.bodyLarge)
//                Text(text = i.id ?: "", style = MaterialTheme.typography.bodyLarge)



                    for (j in i.competitions[0].competitors) {

                        TeamComponent(team = j, modifier = Modifier)
                        Divider(modifier = Modifier.padding(3.dp))

                    }





                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {

//                    Row(){}

                    //use id for game details screen
                    Text("Period ", style = MaterialTheme.typography.bodyLarge)

                    Text(text = i.status.period.toString(), style = MaterialTheme.typography.bodyLarge)


                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        contentColor = Color.White,
                        modifier = Modifier
                            .size(30.dp)

                    ) {
                        Icon(Icons.Outlined.Star, "null")
                    }


                }




            }




            

        }

    }


}


@Composable
fun TeamComponent(team: CompetitorsScoreboard, modifier: Modifier) {
    val color = HexToJetpackColor2.getColor(team.team?.color!!)


    Box(modifier= modifier
        .padding(16.dp)
        .background( Brush.horizontalGradient(
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

