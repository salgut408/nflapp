package com.sgut.android.nationalfootballleague.teamdetails

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamDetailScreen(
    teamDetailViewModel: TeamDetailViewModel = hiltViewModel(),
    team: String
) {
    //team vm need abbrv param
    teamDetailViewModel.loadTeamDetails(team)
    val team by remember {teamDetailViewModel.team}
//    val team by remember {teamDetailViewModel.team}
    val msg by remember {teamDetailViewModel.toastMessageObserver}

    Column() {

        team?.let { TeamDetailCard(team = it, modifier = Modifier.padding(8.dp)) }

    }






}


















