package com.sgut.android.nationalfootballleague.teamdetails

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.util.CoilUtils
import com.sgut.android.nationalfootballleague.Athletes
import com.sgut.android.nationalfootballleague.R
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
           ) {
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
) {
    var inj = athelete.injuries
    OutlinedCard(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { } // navigate.to.athletedetailsScreen

    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Box() {
                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(athelete.headshot?.href ?: athelete.flag?.href)
                        .crossfade(true)
                        .scale(Scale.FILL)
                        .crossfade(100)
                        .build()
                )
                Image(
                    painter = painter,
                    contentDescription = athelete.displayName,
                    modifier = Modifier
                        .size(150.dp)
                        .padding(8.dp)
                        .border(BorderStroke(4.dp, Color.Yellow), CircleShape)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background)

                )
                FloatingActionButton(
                    onClick = { /* viewmodel save player ;) */ },
                    shape = FloatingActionButtonDefaults.smallShape,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.CenterStart)
                        .padding(start = 6.dp)
                ) {
                    Icon(
                        Icons.Filled.Favorite,
                        ""
                    )
                }

            }

            Divider()
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = athelete.displayName)
                Text(text = athelete.position.displayName)
                Text("# ${athelete.jersey}")


                var injuries = athelete.injuries


                injuries?.map {
                    Text(text = it.injuryStatus ?: "")
                    Text(text = it.detail?.side ?: "")

                }





            }
        }

    }

}

@Composable
fun AltheleteCard3(
    athelete: Athletes,
    modifier: Modifier,
) {
    Card(modifier = modifier.fillMaxWidth(2f),
        shape = RoundedCornerShape(15.dp)) {
        Box(modifier = Modifier.height(200.dp)) {
            // image ()
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(athelete.headshot.href ?: athelete.flag?.href)
                    .crossfade(true)
                    .scale(Scale.FILL)
                    .crossfade(100)
                    .build()
            )
            Image(
                painter = painter,
                contentDescription = athelete.displayName,
                modifier = Modifier
                    .size(350.dp)
                    .background(Color.Transparent)
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopStart,
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.width(180.dp)
                ) {
                        Text(athelete.jersey, style = TextStyle(color = Color.Black, fontSize = 80.sp))
                        Text(athelete.position.name, style = TextStyle(color = Color.Black, fontSize = 16.sp))
                        Text(athelete.shortName, style = TextStyle(color = Color.Black, fontSize = 16.sp))
                }
            }
        }
    }
}