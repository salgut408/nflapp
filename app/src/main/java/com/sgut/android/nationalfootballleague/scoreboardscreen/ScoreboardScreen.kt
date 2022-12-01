package com.sgut.android.nationalfootballleague.scoreboardscreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import com.sgut.android.nationalfootballleague.R.string as AppText
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sgut.android.nationalfootballleague.commoncomposables.BasicButton
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
    var events = scoreboardUiState.scoreboardUiStateEvents.events
    var leagues = scoreboardUiState.scoreboardUiStateEvents.leagues
    
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = scoreboardUiState.scoreboardUiStateEvents.day?.date ?: "", style = MaterialTheme.typography.displayLarge)
        Text(leagues.getOrNull(0)?.name?:"", style = MaterialTheme.typography.headlineMedium)

        val leagueLogoPainter = rememberAsyncImagePainter(

            model = ImageRequest.Builder(LocalContext.current)
                .data(leagues.getOrNull(0)?.logos?.getOrNull(0)?.href)
                .crossfade(true)
                .crossfade(1000)
                .build()
        )
        Image(
            painter = leagueLogoPainter,
            contentDescription = leagues.getOrNull(0)?.name?:"",
            modifier = Modifier
                .size(300.dp)

        )



        for (i in events) {
            for (j in i.competitions[0].headlines) {
                Text(text = j.description.toString())
            }
        }



        for (i in events ) {
            Card(modifier.padding(16.dp)) {
                BasicButton(text = AppText.watc, modifier = Modifier.basicButton() ) {

                }

                Text(text = i.name ?: "", style = MaterialTheme.typography.headlineMedium)


                Row() {

                    //use id for game details screen
                    i.competitions[0].id .let {
                        Text(text = it!!,
                            style = MaterialTheme.typography.headlineMedium)
                    }


                    i.status.period.toString() .let {
                        Text(text = it,
                            style = MaterialTheme.typography.headlineMedium)
                    }
                }


                Row(modifier.padding(16.dp)) {


                    Text(text = i.competitions[0].competitors[0].team?.name + " " + i.competitions[0].competitors[0].score.toString()
                        ?: "", style = MaterialTheme.typography.headlineMedium)


                    Text(text = i.competitions[0].competitors[1].team?.name + " " + i.competitions[0].competitors[1].score.toString()
                        ?: "", style = MaterialTheme.typography.headlineMedium)



                    }

            }

            Divider(modifier = Modifier.padding(8.dp))

        }

    }
    
}

@Preview
@Composable
fun TextMaker() {
    Text(
        text = "TEXT",
        modifier = Modifier
            .padding(20.dp)

    )
}