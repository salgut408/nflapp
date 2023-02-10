package com.sgut.android.nationalfootballleague.teamdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sgut.android.nationalfootballleague.commoncomposables.DataLoadingComponent
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailWithRosterModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamDetailScreen(
    modifier: Modifier = Modifier,
    teamDetailViewModel: TeamDetailViewModel = hiltViewModel(),
    sendButtonOnclick: (String, String) -> Unit,
    team: String,
    sport: String,
    league: String,

    ) {
    //    val team by remember { teamDetailViewModel.team }
    // ^ Moded to detailUiState
    teamDetailViewModel.loadTeamDetails(team, sport, league)

    val teamDetailUiState by teamDetailViewModel.teamDetailUiState.collectAsState()
    val team = teamDetailUiState.currentTeamDetails

    if (team != null) {

        NewTeamDetailCard(team = team, modifier = Modifier)


//        Column(
//            modifier
//                .verticalScroll(rememberScrollState())
//                .padding(vertical = 8.dp)
//        ) {
//
////            TeamDetailCard(team = team, modifier = Modifier.padding(8.dp))
//
//
//
////            Button(onClick = { sendButtonOnclick(team.name, team.nextEvent[0].shortName) },
////                modifier.fillMaxWidth()) {
////                Text("Share Next Event")
////            }
////
////            Text(teamDetailUiState.currentSport)
////            Text(teamDetailUiState.currentLeague)
////            Text(teamDetailUiState.currentTeamDetails?.abbreviation ?: "")
//
//        }

    } else {
        DataLoadingComponent()
    }
}


@Composable
fun TeamRecord(
    team: TeamDetailWithRosterModel,
    modifier: Modifier,
) {
    val recordItems = team.record?.items?.getOrNull(0)?.stats

    Card( modifier = modifier.fillMaxWidth()) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,


            modifier = modifier.fillMaxWidth().background(MaterialTheme.colorScheme.secondary),


        ) {
            Text(text = team.record?.items?.getOrNull(0)?.summary ?: "" , fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSecondary)
            Text(text = team.record?.items?.getOrNull(0)?.type ?: "", color =  MaterialTheme.colorScheme.onSecondary)
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.background(MaterialTheme.colorScheme.secondary)
        ) {
            Column() {
                recordItems?.map { recordItems ->
                    Text(text = recordItems?.name ?: "", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSecondary)
                }
            }
            Column() {
                recordItems?.map { recordItems ->
                    Text(text = recordItems?.value.toString(), fontSize = 12.sp, color = MaterialTheme.colorScheme.onSecondary)
                }
            }
        }
    }


}


@Composable
fun TeamRecord2(
    team: TeamDetailWithRosterModel,
    modifier: Modifier,
) {
    val recordItems = team.record?.items
    Column() {
        recordItems?.map { record ->
            Text(text = record?.type ?: "")
            Row() {

                Text(text = record?.summary ?: "")
                Spacer(modifier = modifier.width(20.dp))
                Column() {
                    recordItems.map { items ->
                        items?.stats?.map { stats ->
                            Text(text = stats?.name ?: "")
                            Text(text = stats?.value.toString())


                        }
                    }
                }

//            records.items.map{ stat ->
//                stat?.stats?.map{ teamStat ->
//                    Text(text = teamStat?.name ?: "")
//                    Text(text = teamStat?.value.toString())
//
//
//                }
//            }
            }

        }


    }
}


















