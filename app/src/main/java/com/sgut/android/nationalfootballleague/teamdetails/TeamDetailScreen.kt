package com.sgut.android.nationalfootballleague.teamdetails

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TeamDetailScreen(
    teamDetailViewModel: TeamDetailViewModel = hiltViewModel(),
) {
    val team by remember {teamDetailViewModel.team}
    val msg by remember {teamDetailViewModel.toastMessageObserver}

    team?.let { TeamDetailCard(team = it, modifier = Modifier.padding(8.dp)) }



}