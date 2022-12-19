package com.sgut.android.nationalfootballleague.gamedetailscreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun GameDetailsScreen(
    sport: String,
    league: String,
    event: String,
    gameDetailViewModel: GameDetailViewModel = hiltViewModel(),
) {

}


@Composable
fun DoughnutChart(
    values: List<Float> = listOf(189f, 168f, 2.16f),
    colors: List<Color> = listOf(
        Color(0xFFFF6384),
        Color(0xFFFFCE56),
        Color(0xFF36A2EB) ),
    legend: List<String> = listOf("GreenBay", "Rams", "Tie"),
    size: Dp = 200.dp,
    thickness: Dp = 36.dp

) {

}



@Composable
fun SmallCircle() {
    Canvas(modifier = Modifier.size(100.dp),){
        drawArc(
            color = Color.White,
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = true
        )
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
            color = Color.Cyan,
            startAngle = 0f,
            sweepAngle = 189f,
            useCenter = true,

        )
        drawArc(
            color = Color.Yellow,
            startAngle = 0f,
            sweepAngle = -168.84f,
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




