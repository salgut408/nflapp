package com.sgut.android.nationalfootballleague.ui.screens.teamdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.TeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.RecordModel

//TODO only pass what is needed

@Composable
fun TeamDetailScreen(
    modifier: Modifier = Modifier,
    teamDetailViewModel: TeamDetailViewModel = hiltViewModel(),
    sendButtonOnclick: (String, String) -> Unit,
    team: String,
    sport: String,
    league: String,

    ) {

    teamDetailViewModel.getFullTeamDetails(team, sport, league)

    val teamDetailUiState by teamDetailViewModel.teamDetailUiState.collectAsState()
    val teamDetail = teamDetailUiState.currentTeamDetails

    NewTeamDetailCard(team = teamDetail, modifier = Modifier)
}


@Composable
fun TeamRecord(
    record: RecordModel,
    modifier: Modifier,
) {
    if(record.recordItems.isEmpty()){
        Text(text = "no records")
    } else {

        val recordItems = record.recordItems.getOrNull(0)?.stats

        Card( modifier = modifier.fillMaxWidth()) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,


                modifier = modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary),


                ) {
                Text(text = record.recordItems.getOrNull(0)?.summary ?: "" , fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSecondary)
                Text(text = record.recordItems.getOrNull(0)?.type ?: "", color =  MaterialTheme.colorScheme.onSecondary)
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.background(MaterialTheme.colorScheme.secondary)
            ) {
                Column() {
                    recordItems?.map { recordItems ->
                        Text(text = recordItems.name ?: "", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSecondary)
                    }
                }
                Column() {
                    recordItems?.map { recordItems ->
                        Text(text = recordItems.value.toString(), fontSize = 12.sp, color = MaterialTheme.colorScheme.onSecondary)
                    }
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
    val recordItems = team.record?.recordItems
    Column() {
        recordItems?.map { record ->
            Text(text = record.type ?: "")
            Row() {

                Text(text = record.summary ?: "")
                Spacer(modifier = modifier.width(20.dp))
                Column() {
                    recordItems.map { items ->
                        items.stats.map { stats ->
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


















