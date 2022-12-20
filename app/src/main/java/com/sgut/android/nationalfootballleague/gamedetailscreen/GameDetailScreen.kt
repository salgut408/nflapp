package com.sgut.android.nationalfootballleague.gamedetailscreen

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.commoncomposables.DetailVenueCardImageLoader
import com.sgut.android.nationalfootballleague.commoncomposables.HeadshotImageLoader
import com.sgut.android.nationalfootballleague.commoncomposables.VenueCardImageLoader
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
//mult same name fields only last one will be used
fun Injuries(
    gameDetailModel: GameDetailModel,
) {
    val team1 = gameDetailModel.injuries.getOrNull(0)?.team?.displayName
    val team2 = gameDetailModel.injuries.getOrNull(1)?.team?.displayName
    val injuries1 = gameDetailModel.injuries.getOrNull(0)
    val injuries2 = gameDetailModel.injuries.getOrNull(1)


 Card(
     modifier = Modifier.fillMaxWidth()
 ){
     Text(text = "Injury Report", style = MaterialTheme.typography.headlineSmall)
     Divider()
     Text(text = team1 ?: "", fontWeight = FontWeight.Bold)
     if (injuries1 != null) {
         InjuryColumn(injuries = injuries1)
     }
     Text(text = team2 ?: "", fontWeight = FontWeight.Bold)

     if (injuries2 != null) {
         InjuryColumn(injuries = injuries2)
     }

}
}

@Composable
fun InjuryColumn(injuries: GameDetailsInjuries) {
    Column() {
        for(i in injuries.injuries){
            Row(
                modifier = Modifier.fillMaxWidth().padding(start =8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
               AthleteNameAndPosition(athlete = i.athlete)
                Text(text = i.status)
//                HeadshotImageLoader(athlete = i.athlete, modifier = Modifier)
            }
        }
    }

}

@Composable
fun AthleteNameAndPosition(athlete: GameDetailsAthlete) {
    Row() {
        Text(text = athlete.displayName?: "")
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
        colors.add(HexToJetpackColor2.getColor(i.team?.color ?: "EmptyString"))
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
            .padding(16.dp)) {
        Column(

            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


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
                        style = Stroke(width = thickness.toPx(), cap = StrokeCap.Butt)
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

        DetailVenueCardImageLoader(venue = gameDetailModel.gameInfo?.venue!!)

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






