package com.sgut.android.nationalfootballleague.scoreboardscreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreboardScreen(
    scoreboardViewModel: ScoreboardViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    val scoreboardUiState by scoreboardViewModel.scoreboardUiState.collectAsState()
    Log.e("scoreboard state scrn", scoreboardUiState.scoreboardUiStateEvents.toString())
    
    Column() {
        Text(text = scoreboardUiState.toString() ?: "")
    }
    
}