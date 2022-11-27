package com.sgut.android.nationalfootballleague.teamdetails

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sgut.android.nationalfootballleague.commoncomposables.StatBox
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailWithRosterModel

@Composable
fun TeamDetailCard(
    team: TeamDetailWithRosterModel,
    modifier: Modifier,
) {
    val color = HexToJetpackColor2.getColor(team.color!!)
    val altcolor = HexToJetpackColor2.getColor(team.alternateColor!!)

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
        Text(team.abbreviation.toString())
        team.displayName?.let { Text(text = it, style = MaterialTheme.typography.displayMedium, color = altcolor ) }
        team.standingSummary?.let { Text(text = it, style = MaterialTheme.typography.displaySmall) }


        Image(
            painter = logoPainter,
            contentDescription = team.displayName,
            modifier = Modifier
                .size(200.dp)
        )

        Card() {

Column(
    verticalArrangement = Arrangement.spacedBy(24.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
){

            val venuePainter = rememberAsyncImagePainter(

                    model = ImageRequest.Builder(LocalContext.current)
                        .data(team.franchise?.venue?.images3?.getOrNull(0)?.href)
                        .crossfade(true)
                        .crossfade(1000)
                        .build()


            )


            Text(text = team.franchise?.venue!!.fullName, style = MaterialTheme.typography.bodyLarge)


            Image(
                painter = venuePainter,
                contentDescription = team.displayName,
                modifier = Modifier
                    .size(200.dp)

            )

            if(team.franchise?.venue!!.images3.size>1) {
                val interiorVenuePainter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(team.franchise?.venue!!.images3[1].href)
                        .crossfade(true)
                        .crossfade(1000)
                        .build()
                )
                Image(
                    painter = interiorVenuePainter,
                    contentDescription = team.displayName,
                    modifier = Modifier
                        .size(200.dp)
                )

            }

}
        }




        Text(text = "Team", style = MaterialTheme.typography.titleSmall,)

        AtheleteRow(team)

        Log.e("TeamDetailCard", team.athletes.filter { it.injuries!!.isNotEmpty() }.toString())

//        Text(text = "Injuries", style = MaterialTheme.typography.titleSmall,)
//        InjuredAtheleteRow(team)








        team.nextEvent.getOrNull(0)?.let { NextEvent(nextEvent3 = it, modifier = modifier) }

        StatBox(stats = team.record?.items?.get(0)?.summary.toString())


    }









}





object HexToJetpackColor2 {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}

