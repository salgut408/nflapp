package com.sgut.android.nationalfootballleague.teamdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.getValue

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
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
    modifier: Modifier,
    teamDetailViewModel: TeamDetailViewModel = hiltViewModel(),
) {
    val primColor by remember {teamDetailViewModel.primaryColor}
    OutlinedCard(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(),
        modifier = Modifier.fillMaxWidth()

    ) {



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
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.background)
            )



            Divider()
            Column(modifier = Modifier.padding(16.dp)) {
                athelete.displayName?.let { Text(it) }
                athelete.position?.displayName?.let { Text(it) }
                athelete.jersey?.let { Text("# $it") }
//                athelete.injuries?.getOrNull(1).toString().let { Text("# $it") }
//                athelete { Text(it.toString()) }

                FloatingActionButton(
                    onClick = { /* do something */ },
                    shape = FloatingActionButtonDefaults.smallShape,
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        Icons.Filled.Favorite,
                        ""
                    )
                }

            }
        }

    }

}