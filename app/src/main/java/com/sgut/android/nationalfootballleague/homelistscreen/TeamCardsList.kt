package com.sgut.android.nationalfootballleague.homelistscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TeamCardsList(
    homeListViewModel: HomeListViewModel = hiltViewModel(),
) {
    val teamsList by remember {homeListViewModel.nflTeamsList}
    Column(){
        SearchBar()

        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            items(items = teamsList) { team ->
                TeamCard(team = team, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

