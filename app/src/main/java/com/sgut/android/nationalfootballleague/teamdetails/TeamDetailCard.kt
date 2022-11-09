package com.sgut.android.nationalfootballleague.teamdetails

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
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
import com.sgut.android.nationalfootballleague.NextEvent3
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailModel
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailWithRosterModel

@Composable
fun TeamDetailCard(
    team: TeamDetailWithRosterModel, modifier: Modifier,
) {
    val color = HexToJetpackColor2.getColor(team.color!!)
    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(color.value))
    ) {
        //image



        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
//                    .data(team.logos[0].href)
                .data(team.logos[0].href)
                .crossfade(true)
                .build()
        )

        team.displayName?.let { Text(text = it, style = MaterialTheme.typography.displayMedium,  ) }


        Image(
            painter = painter,
            contentDescription = team.displayName,
            modifier = Modifier
                .fillMaxWidth()
        )
        team.standingSummary?.let { Text(text = it, style = MaterialTheme.typography.bodySmall) }



        Text(text = "Players", style = MaterialTheme.typography.titleSmall,)

        AtheleteRow()


        team.nextEvent.getOrNull(0)?.let { NextEvent(nextEvent3 = it, modifier = modifier) }


    }



}


object HexToJetpackColor2 {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}

