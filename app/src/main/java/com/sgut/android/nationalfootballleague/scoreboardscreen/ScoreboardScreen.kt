package com.sgut.android.nationalfootballleague.scoreboardscreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreboardScreen(
    scoreboardViewModel: ScoreboardViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    val scoreboardUiState by scoreboardViewModel.scoreboardUiState.collectAsState()
    Log.e("scoreboard state scrn", scoreboardUiState.scoreboardUiStateEvents.toString())
    
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = scoreboardUiState.scoreboardUiStateEvents.day?.date ?: "", style = MaterialTheme.typography.displayLarge)
        Text(text = "Headlines", style = MaterialTheme.typography.displaySmall)
        for (i in scoreboardUiState.scoreboardUiStateEvents.events) {
            for (j in i.competitions[0].headlines) {
                Text(text = j.description.toString())
            }
        }

        for (i in scoreboardUiState.scoreboardUiStateEvents.events ) {
            Text(text = i.shortName  ?: "", style = MaterialTheme.typography.headlineMedium)
            Text(text =  i.competitions[0].competitors[0].team?.name + " " + i.competitions[0].competitors[0].score.toString()  ?: "", style = MaterialTheme.typography.headlineMedium)
            Text(text =  i.competitions[0].competitors[1].team?.name + " " + i.competitions[0].competitors[1].score.toString()  ?: "", style = MaterialTheme.typography.headlineMedium)

            Text(text = i.competitions[0].competitors[0].team?.color ?: "", style = MaterialTheme.typography.headlineMedium)
            Text(text = i.competitions[0].competitors[1].team?.color ?: "", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.padding(16.dp))

        }

    }
    
}