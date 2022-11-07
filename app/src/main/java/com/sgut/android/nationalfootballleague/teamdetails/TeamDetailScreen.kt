package com.sgut.android.nationalfootballleague.teamdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamDetailScreen(
    teamDetailViewModel: TeamDetailViewModel = hiltViewModel(),
) {
    val team by remember {teamDetailViewModel.team}
    val msg by remember {teamDetailViewModel.toastMessageObserver}

    Column() {
//        SearchBar()
        team?.let { TeamDetailCard(team = it, modifier = Modifier.padding(8.dp)) }

    }






}


















