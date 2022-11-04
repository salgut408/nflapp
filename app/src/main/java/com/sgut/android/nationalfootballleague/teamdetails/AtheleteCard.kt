package com.sgut.android.nationalfootballleague.teamdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sgut.android.nationalfootballleague.Athletes
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailWithRosterModel

@Composable
fun AtheleteCard(
    athelete: TeamDetailWithRosterModel,
    modifier: Modifier,
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.elevatedCardColors(),
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
//             image
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(athelete.athletes[0].headshot?.href)
                    .crossfade(true)
                    .build()
            )
            Image(
                painter = painter,
                contentDescription = athelete.displayName,
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp)
            )

        }
    }
}

@Composable
fun AltheleteCard2(
    athelete: Athletes,
    modifier: Modifier ,
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.outlinedCardElevation(),
        modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(athelete.headshot?.href)
                    .crossfade(true)
                    .build()
            )
            Image(
                painter = painter,
                contentDescription = athelete.displayName,
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                athelete.displayName?.let { Text(it) }
                athelete.position?.displayName?.let { Text(it) }
                athelete.jersey?.let { Text(it) }
                athelete.age.let { Text(it.toString()) }



            }
        }

    }

}