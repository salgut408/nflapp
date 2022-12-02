package com.sgut.android.nationalfootballleague.teamdetails

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.ScaleResolver
import com.sgut.android.nationalfootballleague.Franchise3
import com.sgut.android.nationalfootballleague.Venue3
import com.sgut.android.nationalfootballleague.commoncomposables.StatBox
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.utils.card

@Composable
fun TeamDetailCard(
    team: TeamDetailWithRosterModel,
    modifier: Modifier,
) {
    val color = HexToJetpackColor2.getColor(team.color)
    val altcolor = HexToJetpackColor2.getColor(team.alternateColor)

    val scrollState = rememberScrollState()



    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    listOf(color, altcolor)
                )
            )
    ) {
        //image
        val logoPainter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(team.logos[0].href)
                .crossfade(true)
                .build()
        )
        Text(text = team.displayName,
            style = MaterialTheme.typography.displayMedium,
            color = altcolor)
        Text(text = team.standingSummary, style = MaterialTheme.typography.displaySmall)


        Image(
            painter = logoPainter,
            contentDescription = team.displayName,
            modifier = Modifier
                .size(200.dp)
                .clipToBounds()
        )




            VenueCard(venue3 = team.franchise?.venue ?: Venue3(),
                modifier = Modifier.fillMaxWidth())







        Text(text = "Team", style = MaterialTheme.typography.titleSmall)

        AtheleteRow(team)





        team.nextEvent.getOrNull(0)?.let { NextEvent(nextEvent3 = it, modifier = modifier) }

        StatBox(stats = team.record?.items?.getOrNull(0)?.summary.toString(), team)
//        InjuredAtheleteRow(team)

    }


}


object HexToJetpackColor2 {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}


@Composable
fun VenueCard(
    venue3: Venue3,
    modifier: Modifier,
) {
    Card(modifier = modifier.background(Color.Transparent)
        .fillMaxWidth()
        .padding(16.dp),
        shape = RoundedCornerShape(15.dp)) {
        Box(modifier = Modifier.height(200.dp)) {
            // image ()
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(venue3.images3.getOrNull(1)?.href ?: venue3.images3.getOrNull(0)?.href)
                    .crossfade(true)
                    .crossfade(100)
                    .build()
            )
            Image(
                painter = painter,
                contentDescription = "",
                modifier = Modifier
                    .width(400.dp).clip(RoundedCornerShape(16.dp))


            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(venue3.fullName, style = TextStyle(color = Color.White, fontSize = 46.sp))

                }
            }

        }
    }
}
