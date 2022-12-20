package com.sgut.android.nationalfootballleague.gamedetailscreen

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
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
fun DoughnutChart2(
    gameDetailModel: GameDetailModel,
    size: Dp = 150.dp,
    thickness: Dp = 30.dp,
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
fun SeasonTeaders() {

}

@Composable
fun PickCenter() {

}

@Composable
fun TeamStatsCard() {

}

@Composable
fun GameInformation() {

}

@Composable
fun WeatherInfo() {

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



