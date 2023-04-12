package com.sgut.android.nationalfootballleague.ui.screens.standings_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.ChildrenModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.StandingsResponseModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.TeamModel
import com.sgut.android.nationalfootballleague.ui.commoncomps.EIGHT
import com.sgut.android.nationalfootballleague.ui.commoncomps.NormalDivider
import com.sgut.android.nationalfootballleague.ui.commoncomps.THIRTYSIX
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.DefaultCard
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.GenericImageLoader

@Composable
fun Standings(
    modifier: Modifier = Modifier,
    sport: String,
    league: String,
    type: String ,
    standingsViewModel: StandingsViewModel = hiltViewModel(),

) {
    standingsViewModel.loadStandings(sport, league, type)

    val standings by standingsViewModel.standingsState.collectAsState()

    DefaultCard(modifier = modifier) {
        Row {
            standings.standingsUiState.children.map { child ->
                Children(child = child, modifier = modifier)
                Spacer(modifier = modifier.width(THIRTYSIX.dp))
                NormalDivider(
                    color = Color.Black,
                    modifier = modifier
                        .fillMaxHeight(1f)
                        .width(1.dp)
                )
                Spacer(modifier = modifier.width(EIGHT.dp))

            }
        }
//        Text(text = standings.standingsUiState.children.toString() )
    }
}


@Composable
fun TeamComp(team: TeamModel, modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = team.abbreviation, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        GenericImageLoader(obj = team.logos.first().href, modifier = modifier.size(30.dp))
    }

}

@Composable
fun Children(child: ChildrenModel, modifier: Modifier) {
    Column {
        Text(text = child.name, fontWeight = FontWeight.Bold)
        Standings(standings = child.standings, modifier)
    }

}

@Composable
fun Standings(standings: StandingsResponseModel, modifier: Modifier) {


    Row(verticalAlignment = Alignment.CenterVertically) {
        Column {
            standings.entries.map { entry ->
                TeamComp(team = entry.team, modifier = modifier)

            }
        }

    }


}