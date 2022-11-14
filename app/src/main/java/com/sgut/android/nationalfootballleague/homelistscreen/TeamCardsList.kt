package com.sgut.android.nationalfootballleague.homelistscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.loader.content.Loader
import androidx.navigation.NavController
import com.sgut.android.nationalfootballleague.di.MainToolBar
import com.sgut.android.nationalfootballleague.di.MyNewToolBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamCardsList(navController: NavController,
    homeListViewModel: HomeListViewModel = hiltViewModel(),
) {
    val teamsList by remember {homeListViewModel.nflTeamsList}
    val uiState = homeListViewModel.uiState.collectAsState()

    val scope = rememberCoroutineScope()


    Scaffold(





           content = { padding ->
                Column(modifier = Modifier.padding(top=8.dp)) {



                    LazyColumn(contentPadding = PaddingValues(16.dp)) {
                        items(items = teamsList) { team ->
                            TeamCard(team = team, modifier = Modifier.padding(8.dp), navController)
                        }
                    }


                }
            },


        )
    }


