package com.sgut.android.nationalfootballleague.ui.screens.atheletedetail

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Composable
fun AthleteDetailScreen() {
    
}


@Composable
fun AtheleteTradingCard(backgroundColor: Color) {

    var rotated by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(500)
    )



}