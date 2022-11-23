package com.sgut.android.nationalfootballleague.teamdetails

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sgut.android.nationalfootballleague.commoncomposables.DataLoadingComponent
import com.sgut.android.nationalfootballleague.domain.TeamDetailsScreenUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamDetailScreen(
    teamDetailViewModel: TeamDetailViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    sendButtonOnclick: (String, String) -> Unit,
    team: String,
    sport: String,
    league: String,

) {
    //    val team by remember { teamDetailViewModel.team }
    // ^ Moded to detailUiState
    teamDetailViewModel.loadTeamDetails2(team, sport, league)

    val teamDetailUiState by teamDetailViewModel.teamDetailUiState.collectAsState()
    val team = teamDetailUiState.currentTeamDetails

    if (team != null) {

        Column(
            modifier
                .verticalScroll(rememberScrollState())
                .padding(vertical = 8.dp)
        ) {


            TeamDetailCard(team = team, modifier = Modifier.padding(8.dp))

            Button(onClick = { sendButtonOnclick(team?.name!!, team!!.nextEvent[0].shortName!!) }, modifier.fillMaxWidth()) {
                Text("Share Next Event")

            }

        }


    } else {
        DataLoadingComponent()
    }
}




















