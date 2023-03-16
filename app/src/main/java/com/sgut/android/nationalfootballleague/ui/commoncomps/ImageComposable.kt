package com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.sgut.android.nationalfootballleague.GameDetailsAthlete
import com.sgut.android.nationalfootballleague.GameDetailsVenue
import com.sgut.android.nationalfootballleague.InjTeam
import com.sgut.android.nationalfootballleague.TeamScoreboard
import com.sgut.android.nationalfootballleague.domain.domainmodels.ArticleModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardTeamModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.VenueModel


@Composable
fun TeamLogoImageLoader(team: TeamDomainModel) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(team.logos?.getOrNull(0)?.href)
            .build(),
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = team.displayName,
    )
}

@Composable
fun TeamLogoDetailImageLoader(team: FullTeamDetailWithRosterModel) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(team.logos.getOrNull(0)?.href)
            .build(),
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = team.displayName,
        )
}
@Composable
fun TeamLogoScoreboardImageLoader(team: ScoreboardTeamModel) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(team.logo)
            .build(),
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = team.displayName,
        )
}


@Composable
fun TeamLogoImageloadiner2(team: TeamScoreboard) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(team.logo)
            .crossfade(true)
            .build(),
        contentDescription = team.displayName,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(140.dp)
    )
}




@Composable
fun GeneralImageLoader(
    href: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
) {
    SportSurface(
        color = Color.Transparent,
        elevation = elevation,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(href)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun ArticleCardImageLoader(articleModel: ArticleModel) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(articleModel.images.getOrNull(0)?.url).size(Size.ORIGINAL)
            .build(),
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = articleModel.headline,

        )
}



@Composable
fun GenericImageLoader(obj: String, modifier: Modifier) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(obj)
            .build(),
        modifier = modifier,
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = obj,

        )
}

@Composable
fun HeadshotImageLoader(athlete: GameDetailsAthlete, modifier: Modifier) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(athlete.headshot?.href)
            .build(),
        modifier = modifier.size(100.dp),
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = athlete.displayName,

        )
}

@Composable
fun VenueCardImageLoader(venue: VenueModel) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(venue.images3.getOrNull(1)?.href ?: venue.images3.getOrNull(0)?.href)
            .build(),
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = venue.fullName,
        modifier=Modifier.fillMaxWidth()

        )
}

@Composable
fun GameDetailLogoImageLoader(team: InjTeam, modifier: Modifier) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(team.logo)
            .build(),
        modifier = modifier.size(100.dp),
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = team.displayName,

        )
}


@Composable
fun DetailVenueCardImageLoader(venue: GameDetailsVenue) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(venue.images.getOrNull(1)?.href ?: venue.images.getOrNull(0)?.href)
            .build(),
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = venue.fullName,
        modifier=Modifier.fillMaxWidth()

    )
}