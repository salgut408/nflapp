package com.sgut.android.nationalfootballleague.gamedetailscreen

import android.media.browse.MediaBrowser
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.commoncomposables.DetailVenueCardImageLoader
import com.sgut.android.nationalfootballleague.commoncomposables.GameDetailLogoImageLoader
import com.sgut.android.nationalfootballleague.data.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.teamdetails.HexToJetpackColor2


@Composable
fun GameDetailsScreen(
    sport: String,
    league: String,
    event: String,
    gameDetailViewModel: GameDetailViewModel = hiltViewModel(),
) {

}

@Composable
fun LongGameTimeDetail(gameDetailModel: GameDetailModel) {
    Text(text = gameDetailModel.header?.competitions?.getOrNull(0)?.status?.type?.gameTimeDetail ?: "", fontSize = 11.sp)

}


@Composable
fun HeaderTeamItem(team : GameDetailsTeam) {

}

@Composable
fun HeaderTeamSlot(team: GameDetailsTeam) {
    Row() {
        Text(text = team.abbreviation ?: "")
        Text(text = team.records.toString())
    }
}

@Composable
fun HeaderStatusSlot(gameDetailModel: GameDetailModel) {
    Card() {
        Box(modifier = Modifier.fillMaxWidth()){
            Text(text = gameDetailModel.header?.competitions?.getOrNull(0)?.competitors?.getOrNull(0)?.team?.name ?: "")
            Text(text = gameDetailModel.header?.competitions?.getOrNull(0)?.competitors?.getOrNull(0)?.team?.records.toString() ?: "")

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
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Injury Report", style = MaterialTheme.typography.headlineSmall)
        Divider()

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = team1Display ?: "", fontWeight = FontWeight.Bold)

            if (team1Logo != null) {
                GameDetailLogoImageLoader(team = team1Logo, modifier = Modifier.size(25.dp))
            }
        }

        if (injuries1 != null) {
            InjuryColumn(injuries = injuries1)
        }



        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = team2Display ?: "", fontWeight = FontWeight.Bold)

            if (team2Logo != null) {
                GameDetailLogoImageLoader(team = team2Logo, modifier = Modifier.size(20.dp))
            }
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
        for (i in injuries.injuries) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AthleteNameAndPosition(athlete = i.athlete)
                Text(text = i.status, textAlign = TextAlign.Right)
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

    for (i in teams!!) {
        colors.add(HexToJetpackColor2.getColor(i.team?.color ?: "EmptyColorString"))
        legends.add(i.team?.name ?: "")
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


    Card(elevation = CardDefaults.elevatedCardElevation(),
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(8.dp)) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text("Matchup Predictor", fontWeight = FontWeight.Bold)
            }
            Divider()

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "$gameProjection%" ,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(10.dp)
                )

                Text(
                    text = "$teamChanceLoss%" ,
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
                            text = teams[0].team?.abbreviation ?: "",
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
                            text = teams[1].team?.abbreviation ?: "",
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
        Text(text = legend, color = Color.Blue, fontSize = 16.sp)

    }

}

@Composable
fun DoughnutChartForBasketball(
    gameDetailModel: GameDetailModel,
    size: Dp = 150.dp,
    thickness: Dp = 20.dp,
) {
    val colors = mutableListOf<Color>()
    val legends = mutableListOf<String>()
    val teams = gameDetailModel.boxscore?.teams

    for (i in teams!!) {
        colors.add(HexToJetpackColor2.getColor(i.team?.color ?: "EmptyString"))
        legends.add(i.team?.name ?: "")
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


    Card(elevation = CardDefaults.elevatedCardElevation(),
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {


            Canvas(
                modifier = Modifier
                    .size(size = size)
                    .padding(16.dp),
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
fun DoughnutChart(
    values: List<Float> = listOf(78.0f, 21.7f, 0.2f),
    colors: List<Color> = listOf(
        Color(0xFFFF6384),
        Color(0xFFFFCE56),
        Color(0xFF36A2EB)),
    legend: List<String> = listOf("GreenBay", "Rams", "Tie"),
    size: Dp = 200.dp,
    thickness: Dp = 36.dp,
    deetsViewModel: GameDetailViewModel = hiltViewModel(),

    ) {
    // sum of all values
    val sumOfValues = values.sum()
    //calc each proportion
    val proportions = values.map { it * 100 / sumOfValues }
    //convert each proportion to angles
    val sweepAngles = proportions.map { 360 * it / 100 }

    Canvas(modifier = Modifier.size(size = size)) {
        var startAngle = -90f

        for (i in values.indices) {
            drawArc(
                color = deetsViewModel._colorsTeamList[i],
                startAngle = startAngle,
                sweepAngle = sweepAngles[i],
                useCenter = false,
                style = Stroke(width = thickness.toPx(), cap = StrokeCap.Butt)
            )
            startAngle += sweepAngles[i]
        }
    }
    Spacer(modifier = Modifier.height(32.dp))
    Column() {
        for (i in values.indices) {
            DisplayLegend(color = deetsViewModel._colorsTeamList[i], legend = legend[i])
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
fun MatchupPredictorGraph() {
    Canvas(
        modifier = Modifier
            .size(size = 200.dp)
            .border(color = Color.Magenta, width = 2.dp)
    ) {
        drawArc(
            color = Color.Blue,
            startAngle = 0f,
            sweepAngle = 78.12f,
            useCenter = true,

            )
        drawArc(
            color = Color.Green,
            startAngle = 0f,
            sweepAngle = -280f,
            useCenter = true,

            )

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
fun VideoView(videoUri: String) {
    val context = LocalContext.current

    val exoPlayer = ExoPlayer.Builder(LocalContext.current)
        .build()
        .also { exoPlayer ->
            val mediaItem = MediaItem.Builder()
                .setUri(videoUri)
                .build()
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
        }

    DisposableEffect(
        AndroidView(factory = {
            StyledPlayerView(context).apply {
                player = exoPlayer
            }
        })
    ) {
        onDispose { exoPlayer.release() }
    }
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

            Text(text = "GameInformation", style = MaterialTheme.typography.headlineSmall)

        }
        Divider()

        GameInfoCardVenueImage(gameDetailModel = gameDetailModel, modifier = Modifier)

        Row() {
            Text(text = "Coverage: ", fontSize = 12.sp)
            Text(text = gameDetailModel.broadcasts.getOrNull(0)?.station ?: "", fontSize = 12.sp)

        }
        LongGameTimeDetail(gameDetailModel = gameDetailModel)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = gameDetailModel.gameInfo?.weather?.link?.text ?: "")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
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





