package com.sgut.android.nationalfootballleague.teamdetails

import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment


import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sgut.android.nationalfootballleague.Venue3
import com.sgut.android.nationalfootballleague.commoncomposables.InjuriesBox
import com.sgut.android.nationalfootballleague.commoncomposables.TeamLogoDetailImageLoader
import com.sgut.android.nationalfootballleague.commoncomposables.VenueCardImageLoader
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailWithRosterModel

@Composable
fun TeamDetailCard(
    team: TeamDetailWithRosterModel,
    modifier: Modifier,
) {
    val color = HexToJetpackColor2.getColor(team.color)
    val altcolor = HexToJetpackColor2.getColor(team.alternateColor)
    val scrollState = rememberScrollState()

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Brush.verticalGradient(listOf(color, altcolor))
            )
    ) {

        Row(verticalAlignment = Alignment.CenterVertically){

            TeamLogoDetailImageLoader(team)

            Column() {
                Text(
                    text = team.displayName,
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify,

                    color = Color.White
                )
            }

        }
        Text(
            text = team.standingSummary,
            style = MaterialTheme.typography.displaySmall,
            color = Color.White,
            textAlign = TextAlign.Center,
            )


        VenueCard(venue3 = team.franchise?.venue ?: Venue3(), modifier = Modifier.fillMaxWidth())
        AtheleteRow(team)

        team.nextEvent.map { nextEvent ->
            NextEvent(nextEvent3 = nextEvent, modifier = modifier)
        }


        //injusries box
        InjuriesBox(
            stats = team.record?.items?.getOrNull(0)?.summary.toString(), team
        )
//        InjuredAtheleteRow(team)

    }


}


object HexToJetpackColor2 {
    fun getColor(colorString: String): Color {
        if (colorString.equals("")) {
            return Color.Red
        } else {
            return Color(android.graphics.Color.parseColor("#" + colorString))

        }
        return Color(android.graphics.Color.parseColor("#" + colorString))

    }
}


@Composable
fun VenueCard(
    venue3: Venue3,
    modifier: Modifier,
) {

        Box(
            modifier = Modifier.height(200.dp)
        ) {
            // image ()
            VenueCardImageLoader(venue3)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Row() {
                    val offset = Offset(5.0f, 5.0f)
                    Text(
                        text =venue3.fullName,
                        style = TextStyle(
                            fontSize = 54.sp,
                            shadow = Shadow(
                                color = Color.Black,
                                offset = offset,
                                blurRadius = 3f
                            )
                        ),
                        textAlign = TextAlign.Right,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }
                Row(){
                    Text(
                        text =venue3.address?.city.toString() + " ," + venue3.address?.state.toString() ,
                        style = TextStyle(color = Color.White, fontSize = 16.sp),
                        textAlign = TextAlign.Left,
                        )
                }
            }
        }
}
