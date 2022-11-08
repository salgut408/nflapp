package com.sgut.android.nationalfootballleague.di

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MainToolBar() {
    TopAppBar(
        title = { Text("Sports!", color = Color.Red) },
        navigationIcon = {
            Icon(imageVector = Icons.Default.Menu, contentDescription = null)
        },

    )
}