package com.sgut.android.nationalfootballleague.homelistscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sgut.android.nationalfootballleague.commoncomposables.NavigationScreens
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.teamdetails.HexToJetpackColor2

@Composable
fun TeamCard(team: TeamDomainModel, modifier: Modifier, navController: NavController) {

    val color = HexToJetpackColor2.getColor(team.color!!)


    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.elevatedCardColors(),
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier
            .clickable {
                navController.navigate(NavigationScreens.DetailScreenTeam.withArgs(team.abbreviation!!))
            }
           ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()) {
//             image
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(team.logos?.get(0)?.href)
                    .crossfade(true)
                    .build()
            )
            Image(
                painter = painter,
                contentDescription = team.displayName,
                modifier = Modifier
                    .size(150.dp)
//                    .padding(8.dp)
            )
            team.shortDisplayName?.let { Text(
                                    text = it,
                                    style = MaterialTheme.typography.headlineMedium
                                        .copy(fontWeight = FontWeight.ExtraBold),
                                    color = Color(color.value), )  }



        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()

        ) {
            team.abbreviation?.let { Text(text = it,   style = MaterialTheme.typography.titleSmall, )  }

        }
    }
    
}
































