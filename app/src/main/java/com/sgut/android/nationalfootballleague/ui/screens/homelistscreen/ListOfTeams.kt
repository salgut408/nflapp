package com.sgut.android.nationalfootballleague.ui.screens.homelistscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.VerticalGrid
import com.sgut.android.nationalfootballleague.ui.navigation.NavigationScreens
import com.sgut.android.nationalfootballleague.ui.screens.teamdetails.HexToJetpackColor2
import kotlin.math.max




@Composable
fun ListOfTeams(
    currentTeams: List<TeamModel>,
    sport: String,
    league: String,
    navController: NavController,

    ) {
    LazyColumn {
        items (items = currentTeams) { team ->
            TeamsCollection(
                teams = currentTeams,
                index = currentTeams.indexOf(team),
                navController = navController,
                sport = sport,
                league = league
            )
        }
    }

}

@Composable
fun TeamsCollection(
    teams: List<TeamModel>,
    index: Int,
    modifier: Modifier = Modifier,
    navController: NavController,
    sport: String,
    league: String,
) {

    VerticalGrid(Modifier.padding(horizontal = 16.dp)) {

        teams.forEach { team ->
            TeamDisplayTile(
                team = team,
                modifier = Modifier.padding(8.dp),
                navController = navController,
                sport = sport,
                league = league,
            )
        }
    }
    Spacer(modifier = Modifier.height(4.dp))
}

private val MinImageSize = 134.dp
private val TileShape = RoundedCornerShape(10.dp)
private const val TeamTextProportion = 0.55f

@Composable
fun TeamDisplayTile(
    team: TeamModel,
    modifier: Modifier,
    navController: NavController,
    sport: String,
    league: String,

    ) {
    val color = HexToJetpackColor2.getColor(team.color)
    val color2 = HexToJetpackColor2.getColor(team.alternateColor)

    Layout(
        modifier = modifier
            .aspectRatio(1.45f)
            .shadow(elevation = 3.dp, shape = TileShape)
            .clip(TileShape)
            .background(Brush.sweepGradient(listOf(color2, color)))
            .clickable {
                navController.navigate(
                    NavigationScreens.DetailScreenTeam.withArgs(
                        team.abbreviation,
                        sport,
                        league
                    )
                )
            },
        content = {
            Text(
                    text = team.abbreviation,
                    color = Color.White,
                    modifier = Modifier
                        .rotate(90f)
                )
                TeamLogoImage(
                    team = team,
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
        }
    ) { measurables, constraints ->
        val textWidth = (constraints.maxWidth * TeamTextProportion).toInt()
        val textPlaceable = measurables[0].measure(Constraints.fixedWidth(textWidth))
        val imageSize = max(MinImageSize.roundToPx(), constraints.maxHeight)
        val imagePlaceable = measurables[1].measure(Constraints.fixed(imageSize, imageSize))
        layout(
            width = constraints.maxWidth,
            height = constraints.minHeight
        ) {
            textPlaceable.placeRelative(
                x = textWidth,
                y = (constraints.maxHeight - textPlaceable.height) / 2
            )
            imagePlaceable.placeRelative(
                x = 0,
                y = (constraints.maxHeight - imagePlaceable.height) / 2 // centered
            )
        }
    }
}

@Composable
fun TeamLogoImage(
    team: TeamModel,
    contentDescription: String?,
    modifier: Modifier ,

    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(team.logos ?: "")
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )
}
