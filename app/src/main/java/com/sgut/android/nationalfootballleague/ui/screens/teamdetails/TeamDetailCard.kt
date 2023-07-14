package com.sgut.android.nationalfootballleague.ui.screens.teamdetails


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sgut.android.nationalfootballleague.commoncomposables.InjuriesBox
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.VenueModel
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.HeadingSection
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.TeamLogoDetailImageLoader
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.VenueCardImageLoader

@Composable
fun TeamDetailCard(
    team: FullTeamDetailWithRosterModel,
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

        Row(verticalAlignment = Alignment.CenterVertically) {

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

        if(team.standingSummary.isNotEmpty()){
            Text(
                text = team.standingSummary,
                fontSize = 12.sp,
                color = Color.White,
                textAlign = TextAlign.Left,
            )
        }

        VenueCard(
            venue = team.franchise.venue ?: VenueModel(),
            modifier = Modifier.fillMaxWidth()
        )

        HeadingSection(
            modifier = Modifier,
            title = "Athletes",
            subtitle =team.name,
           content = { AtheleteRow(team) }
        )

        team.nextEvent.map { nextEvent ->
            NextEvent(nextEvent = nextEvent, modifier = modifier)
        }
        InjuriesBox(
            stats = team.record.recordItems.getOrNull(0)?.summary.toString(), team
        )
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
    venue: VenueModel,
    modifier: Modifier,
) {

    Box(
        modifier = Modifier.height(200.dp)
    ) {
        // image ()
        VenueCardImageLoader(venue)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Row() {
                val offset = Offset(5.0f, 5.0f)
                Text(
                    text = venue.fullName,
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
            Row() {
                Text(
                    text = venue.address?.city.toString() + " ," + venue.address?.state.toString(),
                    style = TextStyle(color = Color.White, fontSize = 16.sp),
                    textAlign = TextAlign.Left,
                )
            }
        }
    }
}


