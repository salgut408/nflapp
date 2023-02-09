package com.sgut.android.nationalfootballleague.homelistscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import kotlin.math.max

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sgut.android.nationalfootballleague.Leagues
import com.sgut.android.nationalfootballleague.Teams
import com.sgut.android.nationalfootballleague.commoncomposables.GenericImageLoader
import com.sgut.android.nationalfootballleague.commoncomposables.NavigationScreens
import com.sgut.android.nationalfootballleague.commoncomposables.SportSurface
import com.sgut.android.nationalfootballleague.commoncomposables.VerticalGrid
import com.sgut.android.nationalfootballleague.data.domainmodels.League
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.teamdetails.HexToJetpackColor2
import kotlin.math.ln


@Composable
fun ListOfTeams2(
    uiState: ListUiState,
    navController: NavController,

) {
    LazyColumn {
        items (items = uiState.currentTeams) {
            TeamsCollection(
                teams = uiState.currentTeams,
                index = 0,
                navController = navController,
                sport = uiState.currentSport,
                league = uiState.currentLeague
            )
        }
    }

}

@Composable
fun TeamsCollection(
//    leagueMod: Leagues,
    teams: List<TeamDomainModel>,
    index: Int,
    modifier: Modifier = Modifier,
    navController: NavController,
    sport: String,
    league: String,
) {

    Column(modifier) {
        Text(
            text = "Hold",
            modifier = Modifier
                .heightIn(min = 56.dp)
                .padding(horizontal = 24.dp, vertical = 4.dp)
                .wrapContentHeight()
        )

    }

    VerticalGrid(Modifier.padding(horizontal = 16.dp)) {
        val gradient = when (index % 2) {
            0 -> Color.Blue
            else -> Color.Green
        }
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
    team: TeamDomainModel,
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
            .background(Brush.horizontalGradient(listOf(color, color2)))
            .clickable {
                navController.navigate(NavigationScreens.DetailScreenTeam.withArgs(team.abbreviation,
                    sport,
                    league))
            },
        content = {
            Text(
                text = team.displayName,
                modifier = Modifier
                    .padding(4.dp)
                    .padding(start = 8.dp)
            )
            TeamLogoImage(
                team = team,
                contentDescription = null,
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
                x = 0,
                y = (constraints.maxHeight - textPlaceable.height) / 2
            )
            imagePlaceable.placeRelative(
                x = textWidth,
                y = (constraints.maxHeight - imagePlaceable.height) / 2 // centered
            )
        }

    }


}

@Composable
fun TeamLogoImage(
    team: TeamDomainModel,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,

    ) {
    val color = HexToJetpackColor2.getColor(team.color)

    SportSurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {

        GenericImageLoader(
            obj = team.logos?.getOrNull(0)?.href ?: "",
            modifier = Modifier.fillMaxSize()
        )

    }

}



