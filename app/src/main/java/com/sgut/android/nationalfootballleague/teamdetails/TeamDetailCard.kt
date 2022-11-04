package com.sgut.android.nationalfootballleague.teamdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailModel
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailWithRosterModel

@Composable
fun TeamDetailCard(
    team: TeamDetailWithRosterModel, modifier: Modifier,
) {

    Card(
        shape = RoundedCornerShape(10.dp),
        //hex color
        colors = CardDefaults.elevatedCardColors(),
//        elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier.fillMaxSize()
            //toast here?
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            //image

            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(team.logos[0].href)
                    .crossfade(true)
                    .build()
            )

            team.displayName?.let { Text(text = it, style = MaterialTheme.typography.displayMedium) }


            Image(
                painter = painter,
                contentDescription = team.displayName,
                modifier = Modifier
//                    .padding(8.dp)
                    .fillMaxWidth()
            )
            team.standingSummary?.let { Text(text = it, style = MaterialTheme.typography.bodySmall) }

        }

        Text(text = "Players", style = MaterialTheme.typography.titleSmall)

        AtheleteRow()
        NextEvent(nextEvent3 = team.nextEvent[0], modifier = modifier)

    }
}


