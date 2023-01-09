package com.sgut.android.nationalfootballleague.gamedetailscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.commoncomposables.DetailVenueCardImageLoader
import com.sgut.android.nationalfootballleague.commoncomposables.GameDetailLogoImageLoader
import com.sgut.android.nationalfootballleague.commoncomposables.GenericImageLoader
import com.sgut.android.nationalfootballleague.data.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.data.remote.responses.game_details.Videos
import com.sgut.android.nationalfootballleague.teamdetails.HexToJetpackColor2


@Composable
fun GameDetailsScreen(
    modifier: Modifier = Modifier,
    sport: String,
    league: String,
    event: String,
    gameDetailViewModel: GameDetailViewModel = hiltViewModel(),

) {

    gameDetailViewModel.loadGameDetails(sport, league, event)

    val gameDetailUiState by gameDetailViewModel.gameDetailUiState.collectAsState()
    Log.e("GAMEDETAILUISTATE", gameDetailUiState.toString())


    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        HeaderStatusSlot(gameDetailModel = gameDetailUiState.currentGameDetails
            ?: GameDetailModel())

        when (gameDetailUiState.currentSport) {
            "basketball" -> DoughnutChartForBasketball(
                gameDetailModel = gameDetailUiState.currentGameDetails
                    ?: GameDetailModel(),
            )
            "football" -> DoughnutChart2(
                gameDetailModel = gameDetailUiState.currentGameDetails
                    ?: GameDetailModel(),
            )
        }





        SeasonLeaders(gameDetailModel = gameDetailUiState.currentGameDetails
            ?: GameDetailModel())



        NewVidList(vidList = gameDetailUiState.currentGameDetails?.videos ?: listOf())

        TabsLastFiveGames(lastFiveGames = gameDetailUiState.currentGameDetails?.lastFiveGames
            ?: listOf())

        GameArticle(gameDetailModel = gameDetailUiState.currentGameDetails
            ?: GameDetailModel())

        FindTickets(gameDetailUiState.currentGameDetails?.ticketsInfo ?: GameDetailsTicketsInfo())

        InjuriesReportCard(gameDetailModel = gameDetailUiState.currentGameDetails
            ?: GameDetailModel())


        GameInformation(
            gameDetailModel = gameDetailUiState.currentGameDetails ?: GameDetailModel(),
        )

        TeamStatCard2(boxscore = gameDetailUiState.currentGameDetails?.boxscore ?: GameDetailsBoxscore())


//        TeamStat(boxscore = gameDetailUiState.currentGameDetails?.boxscore ?: GameDetailsBoxscore())


    }
}

@Composable
fun LongGameTimeDetail(gameDetailModel: GameDetailModel) {
    Text(text = gameDetailModel.header?.competitions?.getOrNull(0)?.status?.type?.gameTimeDetail
        ?: "", fontSize = 11.sp)

}

@Composable
fun ScoringPlay(scoringPlays: ScoringPlays) {
    Column() {
        Text(text = scoringPlays.team?.name ?: "Nul")

        Text(text = scoringPlays.type?.text ?: "Nul")
        Text(text = "Period: " + scoringPlays.period?.number.toString())

    }
}


@Composable
fun ScoringPlaysList(gameDetailModel: GameDetailModel) {
    gameDetailModel.scoringPlays.map { play ->
        ScoringPlay(scoringPlays = play)
    }

}

@Composable
fun WinProbabilityGraph() {

}

@Composable
fun HeaderTeamLogo(team: GameDetailsTeam) {
    GenericImageLoader(
        obj = team.logos.getOrNull(0)?.href ?: "",
        modifier = Modifier.size(60.dp))
}

@Composable
fun HeaderTeamItem(competitors: GameDetailsCompetitors) {
    Row() {
        competitors.team?.name
        competitors.team?.abbreviation

        HeaderTeamLogo(competitors.team ?: GameDetailsTeam())

    }
}

@Composable
fun HeaderTeamSlot(competitors: GameDetailsCompetitors) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = competitors.team?.abbreviation ?: "", fontSize = 12.sp)
            Text(text = competitors.record.getOrNull(0)?.displayValue ?: "", fontSize = 10.sp)
        }
        HeaderTeamItem(competitors)
    }
}

@Composable
fun GameArticle(gameDetailModel: GameDetailModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {


        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)) {


            Text(
                text = gameDetailModel.singleArticle?.headline ?: "",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = gameDetailModel.singleArticle?.description ?: "",
                fontSize = 14.sp
            )

            Row() {


                Text(text = gameDetailModel.singleArticle?.published ?: "")
                Text(text = " - ")
                Text(text = gameDetailModel.singleArticle?.source ?: "")
            }


        }
    }
}

@Composable
fun SeasonLeaders(gameDetailModel: GameDetailModel) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Season Leaders",

            fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold
        )
        Divider()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.fillMaxWidth()
        ) {


        }
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {


            gameDetailModel.leaders.map {
                Column() {
                    it.leaders.map {
                        Column() {
                            Text(text = it.displayName.uppercase())
                        }
                        Column() {
                            it.leadersAthlete.map {
                                SeasonLeadersPlayer(athlete = it)
                            }
                        }
                    }
                }

            }


        }
    }

}


@Composable
fun SeasonLeaderPlayerItem(athlete: AthleteLeaders) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        GenericImageLoader(
            obj = athlete.athlete?.headshot?.href ?: "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White)

                .border(width = 1.dp, color = Color.LightGray)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(text = athlete.athlete?.shortName ?: "")
            Text(text = athlete.displayValue)


        }

    }
}

@Composable
fun NewVidList(vidList: List<Videos>) {
    Column() {
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "Videos")
        LazyRow(contentPadding = PaddingValues(8.dp)) {
            items(items = vidList) { vid ->
                VideoPreview(video = vid, modifier = Modifier.padding(8.dp))

            }
        }
    }
}




@Composable
fun VideoPreview(
    video: Videos,
    modifier: Modifier,
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .width(200.dp)
            .height(200.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                GenericImageLoader(
                    obj = video.thumbnail ?: "",
                    modifier = Modifier.width(200.dp)
                )

                Text(
                    text = video.headline.toString(),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Left,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = video.duration?.div(60)?.toFloat().toString() ,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Left,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }


        }


    }


}

@Composable
fun DisplayLabels(list: List<GameDetailsStatistics>) {
    Column() {
        list.map {
            Text(text = it.label ?: "", fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            Text(text = it.displayValue ?: "", fontSize = 10.sp)
        }

    }

}

@Composable
fun TeamStatCard2(boxscore: GameDetailsBoxscore) {
    Card(modifier = Modifier.fillMaxWidth()) {

        Text(text = "Team Stats", fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold)
        Column(verticalArrangement = Arrangement.Center) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                boxscore.teams.map {
                    Column(
                        modifier = Modifier
                    ) {
                        Text(text = it.team?.abbreviation ?: "", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Column() {
                                DisplayLabels(list = it.statistics)
                            }
                        }
                    }

                }
            }


        }
    }
}

@Composable
fun TeamStat(boxscore: GameDetailsBoxscore) {
    Card(modifier = Modifier.fillMaxWidth()) {
        
        boxscore.teams.map {
            Row(){
                Column() {
                    Text(text =  it.team?.name ?: "")
                    DisplayLabels(list = it.statistics)
                }

            }

        }
        
        Column(verticalArrangement = Arrangement.Center) {
            Row() {
                boxscore.teams.map {
                    Row() {
                        Text(text = it.team?.displayName ?: "")
                        Column() {
                            DisplayLabels(list = it.statistics)
                        }
                    }
                }
            }


        }
    }
}

@Composable
fun SeasonLeadersPlayer(athlete: AthleteLeaders) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,

        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 8.dp)

    ) {
        Column() {
            Text(
                text = athlete.athlete?.shortName ?: "",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = athlete.displayValue ?: "",
                fontSize = 11.sp,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis, modifier = Modifier.width(90.dp)
            )
        }
        Column() {
            GenericImageLoader(
                obj = athlete.athlete?.headshot?.href ?: "",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.End)

            )
        }
    }
}

@Composable
fun HeaderStatusSlot(gameDetailModel: GameDetailModel) {
    Card() {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {

            Row() {


                gameDetailModel.header?.competitions!!.map {
                    it.competitors.map {
                        HeaderTeamSlot(competitors = it)
                    }
                }
            }
        }
    }
}


@Composable
//multiple same name fields only last one will be used
fun InjuriesReportCard(
    gameDetailModel: GameDetailModel,
) {
    val team1Display = gameDetailModel.injuries.getOrNull(0)?.team?.displayName
    val team2Display = gameDetailModel.injuries.getOrNull(1)?.team?.displayName
    val injuries1 = gameDetailModel.injuries.getOrNull(0)
    val injuries2 = gameDetailModel.injuries.getOrNull(1)
    val team1Logo = gameDetailModel.injuries.getOrNull(0)?.team
    val team2Logo = gameDetailModel.injuries.getOrNull(1)?.team

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Injury Report", fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold)

        Divider()

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (team1Logo != null) {
                GameDetailLogoImageLoader(team = team1Logo, modifier = Modifier.size(35.dp))
            }
            Text(text = team1Display ?: "", fontWeight = FontWeight.Bold)


        }

        if (injuries1 != null) {
            InjuryColumn(injuries = injuries1)
        }



        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (team2Logo != null) {
                GameDetailLogoImageLoader(team = team2Logo, modifier = Modifier.size(35.dp))
            }

            Text(text = team2Display ?: "", fontWeight = FontWeight.Bold)


        }

        if (injuries2 != null) {
            InjuryColumn(injuries = injuries2)
        }

    }
}

@Composable
fun InjuryColumn(injuries: GameDetailsInjuries) {
    Column() {
        Row() {
        }
        injuries.injuries.map {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AthleteNameAndPosition(athlete = it.athlete)


                Text(text = it.status, textAlign = TextAlign.Right)

            }
        }
    }

}

@Composable
fun AthleteNameAndPosition(athlete: GameDetailsAthlete) {
    Row() {
        Text(text = athlete.displayName ?: "")
        Text(text = " ")
        Text(text = athlete.position?.abbreviation ?: "", color = Color.Blue)
    }
}

@Composable
fun DoughnutChart2(
    gameDetailModel: GameDetailModel,
    size: Dp = 200.dp,
    thickness: Dp = 20.dp,
) {
    val colors = mutableListOf<Color>()
    val legends = mutableListOf<String>()
    val teams = gameDetailModel.boxscore?.teams


    teams?.map {
        colors.add(HexToJetpackColor2.getColor(it.team?.color ?: ""))
        legends.add(it.team?.name ?: "")
    }

    colors.reverse()
    legends.reverse()

    colors.add(Color.Yellow)
    legends.add("Tie")

//for nba only response is "AWAYTEAM"

    val gameProjection = gameDetailModel.predictor?.homeTeam?.gameProjection ?: 0f
    val teamChanceLoss = gameDetailModel.predictor?.homeTeam?.teamChanceLoss ?: 0f
    val teamChanceTie = gameDetailModel.predictor?.homeTeam?.teamChanceTie ?: 0f
    val values = listOf(gameProjection, teamChanceLoss, teamChanceTie)

    val sumOfValues = values.sum()
    val proportions = values.map { it * 100 / sumOfValues }
    val sweepAngles = proportions.map { it * 360 / 100 }


    Card(
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(8.dp)) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Matchup Predictor", fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold)
            }
            Divider()
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "$gameProjection%",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(10.dp)
                )
                Text(
                    text = "$teamChanceLoss%",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(10.dp)
                )

                Box(
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .align(Alignment.Center)
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = teams?.get(0)?.team?.abbreviation ?: "",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Divider(
                            color = Color.LightGray,
                            modifier = Modifier
                                .height(100.dp)
                                .width(1.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = teams?.get(1)?.team?.abbreviation ?: "",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Canvas(
                    modifier = Modifier
                        .size(size = size)
                        .padding(16.dp)
                        .align(Alignment.Center),
                ) {

                    var startAngle = -90f
                    for (i in values.indices) {

                        drawArc(
                            color = colors.getOrElse(i) { color -> Color.White },
                            startAngle = startAngle,
                            sweepAngle = sweepAngles[i],
                            useCenter = false,
                            style = Stroke(width = thickness.toPx(), cap = StrokeCap.Butt)
                        )
                        startAngle += sweepAngles[i]
                    }
                }
            } //end of box

            Spacer(modifier = Modifier.height(8.dp))

            Column() {

                Text(
                    text = "Tie: $teamChanceTie%",
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                )
                for (i in values.indices) {
                    DisplayLegend(
                        color = colors.getOrElse(i, { color -> Color.White }),
                        legend = legends.getOrElse(i, { word -> "" }))
                }
            }
        }
    }
}


@Composable
fun DisplayLegend(color: Color, legend: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(color = color, shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = legend, color = Color.Blue, fontSize = 12.sp)

    }

}

@Composable
fun DoughnutChartForBasketball(
    gameDetailModel: GameDetailModel,
    size: Dp = 200.dp,
    thickness: Dp = 20.dp,
) {
    val colors = mutableListOf<Color>()
    val legends = mutableListOf<String>()
    val teams = gameDetailModel.boxscore?.teams

    teams?.map {
        colors.add(HexToJetpackColor2.getColor(it.team?.color ?: ""))
        legends.add(it.team?.name ?: "")
    }


    colors.add(Color.Yellow)
    legends.add("Tie")

//for nba only response is "AWAYTEAM"

    val gameProjection = gameDetailModel.predictor?.awayTeam?.gameProjection ?: 0f
    val teamChanceLoss = gameDetailModel.predictor?.awayTeam?.teamChanceLoss ?: 0f
    val teamChanceTie = gameDetailModel.predictor?.awayTeam?.teamChanceTie ?: 0f
    val values = listOf(gameProjection, teamChanceLoss, teamChanceTie)

    val sumOfValues = values.sum()
    val proportions = values.map { it * 100 / sumOfValues }
    val sweepAngles = proportions.map { it * 360 / 100 }


    Card(
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(8.dp)) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Matchup Predictor", fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold)
            }
            Divider()
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "$gameProjection%",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(10.dp)
                )
                Text(
                    text = "$teamChanceLoss%",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(10.dp)
                )
                Box(
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .align(Alignment.Center)
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = teams?.get(1)?.team?.abbreviation ?: "",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Divider(
                            color = Color.LightGray,
                            modifier = Modifier
                                .height(100.dp)
                                .width(1.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = teams?.get(0)?.team?.abbreviation ?: "",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Canvas(
                    modifier = Modifier
                        .size(size = size)
                        .padding(16.dp)
                        .align(Alignment.Center),
                ) {
                    var startAngle = -90f
                    for (i in values.indices) {
                        drawArc(
                            color = colors.getOrElse(i) { color -> Color.White },
                            startAngle = startAngle,
                            sweepAngle = sweepAngles[i],
                            useCenter = false,
                            style = Stroke(width = thickness.toPx(), cap = StrokeCap.Butt),
                        )
                        startAngle += sweepAngles[i]
                    }

                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Column() {
                Text(text = "Win Prediction", textAlign = TextAlign.Center)
                for (i in values.indices) {
                    DisplayLegend(
                        color = colors.getOrElse(i, { color -> Color.White }),
                        legend = legends.getOrElse(i, { word -> "" }))
                }
            }
        }
    }
}


@Composable
fun DisplayLegend2(color: Color, legend: String, value: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(color = color, shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = legend, color = Color.Blue, fontSize = 16.sp)
        Spacer(modifier = Modifier.width(4.dp))

        Text(text = value.toString(), color = Color.Blue, fontSize = 16.sp)

    }

}


@Composable
fun SeasonLeaders() {

}

@Composable
fun PickCenter() {

}

@Composable
fun TeamStatsCard() {

}

@Composable
fun GameInformation(
    gameDetailModel: GameDetailModel,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Text(
                text = "GameInformation",
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Divider()

        GameInfoCardVenueImage(gameDetailModel = gameDetailModel, modifier = Modifier)

        Row() {
            Text(text = "Coverage: ", fontSize = 12.sp)
            Text(text = gameDetailModel.broadcasts.getOrNull(0)?.station
                ?: gameDetailModel.header?.competitions?.getOrNull(0)?.broadcasts?.getOrNull(1)?.station.toString()
                ?: "", fontSize = 12.sp)

        }
        LongGameTimeDetail(gameDetailModel = gameDetailModel)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)


        ) {
            Text(text = gameDetailModel.gameInfo?.weather?.link?.text ?: "")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AddressComp(gameDetailModel = gameDetailModel)
            Text(text = gameDetailModel.gameInfo?.weather?.temperature.toString(),
                fontWeight = FontWeight.Bold)
        }
        Divider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "CAPACITY: ", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text(text = gameDetailModel.gameInfo?.venue?.capacity.toString(), fontSize = 12.sp)
        }
    }
}

@Composable
fun AddressComp(gameDetailModel: GameDetailModel) {
    Row() {
        Text(text = gameDetailModel.gameInfo?.venue?.address?.city ?: "")
        Text(text = ", ")
        Text(text = gameDetailModel.gameInfo?.venue?.address?.state ?: "")


    }
}


@Composable
fun TeamVsComponent() {

}


fun getTeamsColorsList(gameDetailModel: GameDetailModel): List<Color?> {
    var list = listOf<Color?>()
    for (i in gameDetailModel.boxscore?.teams!!) {
        list = listOf(HexToJetpackColor2.getColor(i.team?.color ?: "")

        )
    }
    return list
}


@Composable
fun FindTickets(ticketsInfo: GameDetailsTicketsInfo) {
    val team1 = ticketsInfo.seatSituation?.opponentTeamName
    val team2 = ticketsInfo.seatSituation?.currentTeamName
    val venueName = ticketsInfo.seatSituation?.venueName
    val shortDate = ticketsInfo.seatSituation?.dateShort
    val dateDay = ticketsInfo.seatSituation?.dateDay
    val dropDownOptions = ticketsInfo.tickets
    Card(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Find Tickets",
                textAlign = TextAlign.Start,
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Divider()
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "$team1 vs $team2",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "$venueName - $dateDay $shortDate",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = ticketsInfo.seatSituation?.summary ?: "",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Blue
            )
        }
        Divider()
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Buy $team2 tickets with VividSeats",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Blue
            )
        }
        Divider()

        // dropdowm
        DropDownFun(dropDownOptions)

    }
}

@Composable
fun DropDownFun(tickets: List<GameDetailsTickets>) {
    val listItems = tickets
    val disabledItem = 1
    val toastConext = LocalContext.current.applicationContext
    var expanded by remember { mutableStateOf(false) }

    Box(contentAlignment = Alignment.Center) {
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = ""
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            listItems.forEachIndexed { itemIndex, itemValue ->
                DropDownMenuItem(
                    onClick = {
                        expanded = false
                    },
                    enabled = (itemIndex != disabledItem)
                ) {
                    Text(text = itemValue.ticketName.toString())
                }
            }

        }
    }
}

@Composable
fun DropDownMenuItem(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = MenuDefaults.DropdownMenuItemContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {

}

@Composable
fun Leadrs(gameDetailsLeaders: List<GameDetailsLeaders>) {

    gameDetailsLeaders.map {
        Row() {
            SznLeaders(leaders = it.leaders)
        }
    }
}

@Composable
fun SznLeaders(leaders: List<GameDetailsLeaders2>) {
    Card() {

        leaders.map { SeasonLeaders2(seasonLeader = it) }


    }
}

@Composable
fun SeasonLeaders2(seasonLeader: GameDetailsLeaders2) {
    Row(
        verticalAlignment = Alignment.CenterVertically,


        horizontalArrangement = Arrangement.Start
    ) {


        Column() {
            Text(text = seasonLeader.displayName.uppercase(), fontSize = 16.sp)
            Text(text = seasonLeader.leadersAthlete.getOrNull(0)?.athlete?.shortName ?: "",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold)
            Text(text = seasonLeader.leadersAthlete.getOrNull(0)?.displayValue ?: "",
                fontSize = 10.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(80.dp))
//        GenericImageLoader(obj = , modifier = )

        }
        Column() {
            GenericImageLoader(obj = seasonLeader.leadersAthlete.getOrNull(0)?.athlete?.headshot?.href
                ?: "", modifier = Modifier.size(60.dp))
        }
    }
}


@Composable
fun TabsLastFiveGames(lastFiveGames: List<LastFiveGames>) {
    var teamImages = listOf(lastFiveGames.getOrNull(0)?.team?.logo.toString(),
        lastFiveGames.getOrNull(0)?.team?.logo.toString())
    var tabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf(lastFiveGames.getOrNull(0)?.team,
        lastFiveGames.getOrNull(1)?.team)

    Card() {
        Column(modifier = Modifier.fillMaxWidth()) {
            TabRow(selectedTabIndex = tabIndex) {
                tabTitles.forEachIndexed { index, team ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = {
                            Box(){
                                Row(horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                                ) {

                                    GenericImageLoader(obj = team?.logo.toString(), modifier = Modifier.size(30.dp))
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = team?.abbreviation ?: "")

                                }
                            }

                        },

                        )
                }
            }
            when (tabIndex) {
                0 -> LastFiveGames2(lastFiveGames = lastFiveGames, 0)
                1 -> LastFiveGames2(lastFiveGames = lastFiveGames, 1)

            }
        }
    }
}


@Composable
fun LastFiveGameRow(lastEvents: GameDetailsEvents) {
    Row(
        modifier = Modifier.fillMaxWidth(1f),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {


        Text(text = lastEvents.gameDate, fontSize = 10.sp)
        Spacer(modifier = Modifier.width(8.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = lastEvents.atVs, fontSize = 16.sp)
            GenericImageLoader(obj = lastEvents.opponentLogo, modifier = Modifier.size(30.dp))
            Text(text = lastEvents.opponent.abbreviation, fontSize = 12.sp, textAlign = TextAlign.Start)
        }
        Spacer(modifier = Modifier.width(8.dp))


        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = lastEvents.gameResult, fontSize = 12.sp, textAlign = TextAlign.Start)
            Text(text = lastEvents.score, fontSize = 12.sp, textAlign = TextAlign.Start)
        }


    }
}



@Composable
fun LastFiveGames2(lastFiveGames: List<LastFiveGames>, teamInt: Int) {
    val team1Info = lastFiveGames.getOrNull(teamInt)
    val team2Info = lastFiveGames.getOrNull(1)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Text(text = "Last Five Games",
            fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold)

        Row(
            verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(text = "DATE")
            Text(text = "OPP")
            Text(text = "RESULT")

        }

        team1Info?.lastEvents?.map{ LastFiveGameRow(lastEvents = it) }


    }
}

@Composable
fun GameInfoCardVenueImage(
    gameDetailModel: GameDetailModel, modifier: Modifier,
) {
    Box(modifier = Modifier.height(200.dp)) {
        DetailVenueCardImageLoader(venue = gameDetailModel.gameInfo?.venue ?: GameDetailsVenue())

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Row() {
                val offset = Offset(5.0f, 5.0f)
                Text(
                    text = gameDetailModel.gameInfo?.venue?.fullName ?: "",
                    style = TextStyle(
                        fontSize = 50.sp,
                        shadow = Shadow(
                            color = Color.Black,
                            offset = offset,
                            blurRadius = 3f
                        )
                    ),
                    textAlign = TextAlign.Right,
                    color = Color.White
                )
            }

        }
    }
}


@Composable
fun VideoScreenComp(
    gameDetailModel: GameDetailModel,
    ) {
    val context = LocalContext.current
    val exoPlayer = remember(context) {
        ExoPlayer.Builder(context).build()
    }
    val videos = gameDetailModel.videos

}

@Composable
fun EventNews(
    gameDetailModel: GameDetailModel,
    modifier: Modifier,
) {
    

}

@Composable
fun EventDetailArticle() {
    
}

@Composable
fun VideoPlayer(modifier: Modifier) {
    val context = LocalContext.current
    val expoPlayer = remember {
        ExoPlayer.Builder(context).build().apply { this.prepare() }
    }
}
