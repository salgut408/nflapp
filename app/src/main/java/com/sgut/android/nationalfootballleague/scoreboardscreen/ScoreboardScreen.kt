package com.sgut.android.nationalfootballleague.scoreboardscreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
    
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(text = scoreboardUiState.scoreboardUiStateEvents.day?.date ?: "", style = MaterialTheme.typography.displayLarge)
//        Text(text = "Headlines", style = MaterialTheme.typography.displaySmall)
        for (i in events) {
            for (j in i.competitions[0].headlines) {
                Text(text = j.description.toString())
            }
        }

        for (i in events ) {
            Card() {
                Text(text = i.name ?: "", style = MaterialTheme.typography.headlineMedium)
                Row(modifier.padding(16.dp)) {

                    i.competitions[0].date?.let {
                        Text(text = it,
                            style = MaterialTheme.typography.headlineMedium)
                    }
                    i.status.period.toString() .let {
                        Text(text = it,
                            style = MaterialTheme.typography.headlineMedium)
                    }
                }

//            Row(modifier.padding(16.dp)){
//                Text(text = i.competitions[0].competitors[0].team?.color ?: "", style = MaterialTheme.typography.headlineMedium)
//                Text(text = i.competitions[0].competitors[1].team?.color ?: "", style = MaterialTheme.typography.headlineMedium)
//            }
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