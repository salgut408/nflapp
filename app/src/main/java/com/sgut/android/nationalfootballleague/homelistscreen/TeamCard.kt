package com.sgut.android.nationalfootballleague.homelistscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sgut.android.nationalfootballleague.commoncomposables.NavigationScreens
import com.sgut.android.nationalfootballleague.commoncomposables.TeamLogoImageLoader
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.teamdetails.HexToJetpackColor2

@Composable
fun TeamCard(
    team: TeamDomainModel,
    modifier: Modifier,
    navController: NavController,
    sport:String,
    league:String
) {

    val color = HexToJetpackColor2.getColor(team.color)


    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.elevatedCardColors(),
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(NavigationScreens.DetailScreenTeam.withArgs(team.abbreviation, sport, league))
            }
    ) {

        Box(modifier = Modifier.background(
            Brush.verticalGradient(
                listOf(color, Color.White)
            )
        )) {


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()) {
//             image

                TeamLogoImageLoader(team = team)



                    Text(
                        text = team.shortDisplayName,
                        style = MaterialTheme.typography.headlineMedium
                            .copy(fontWeight = FontWeight.ExtraBold),
                        color = Color(color.value),
                    )

            }

        }


    }
}


































