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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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


    val scope = rememberCoroutineScope()


    Scaffold(


            topBar = { MyNewToolBar() },




           content = { padding ->
                Column(modifier = Modifier.padding(top=8.dp)) {

                    SearchBar()

                    LazyColumn(contentPadding = PaddingValues(16.dp)) {
                        items(items = teamsList) { team ->
                            TeamCard(team = team, modifier = Modifier.padding(8.dp), navController)
                        }
                    }
                }
            },



            bottomBar = {
                BottomAppBar(modifier = Modifier,) {

                    IconButton(onClick = {  },  ) {
                        Icon(Icons.Default.Menu, contentDescription = null)
                    }
                    IconButton( onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                    
                }
            }
//            bottomBar = {
//                BottomAppBar(modifier = Modifier, contentColorFor(backgroundColor = MaterialTheme.colorScheme.onPrimaryContainer) ) { Text("BottomAppBar") }
//            }
        )


    }


