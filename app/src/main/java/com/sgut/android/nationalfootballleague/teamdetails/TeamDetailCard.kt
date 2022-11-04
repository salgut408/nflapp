package com.sgut.android.nationalfootballleague.teamdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailModel
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailWithRosterModel

@Composable
fun TeamDetailCard(team: TeamDetailWithRosterModel, modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier
                //toast here?
            .clickable {  }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            //image
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(team.logos[0].href)
                    .crossfade(true)
                    .build()
            )
            Image(
                painter = painter,
                contentDescription = team.displayName,
                modifier = Modifier
                    .padding(16.dp)

            )





        }
        Row(

        ) {

            team.displayName?.let { Text(text = it,   style = MaterialTheme.typography.displaySmall, )  }
            team.standingSummary?.let { Text(text = it,   style = MaterialTheme.typography.bodySmall, )  }
            team.franchise?.shortDisplayName?.let { Text(text = it,   style = MaterialTheme.typography.bodySmall, )  }
            team.franchise?.venue?.fullName?.let { Text(text = it,   style = MaterialTheme.typography.bodySmall, )  }

        }

    }

}