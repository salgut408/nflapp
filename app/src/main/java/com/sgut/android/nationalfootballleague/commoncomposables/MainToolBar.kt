package com.sgut.android.nationalfootballleague.di

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sgut.android.nationalfootballleague.commoncomposables.DrawerNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainToolBar(title: @Composable () -> Unit,) {
    TopAppBar(
        title = title,
        navigationIcon = {
            Icon(imageVector = Icons.Default.Menu, contentDescription = null)
        },

    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNewToolBar2(
currentScreen: String,
canNavigateBack: Boolean,
navigateUp: ()->Unit,
modifier: Modifier = Modifier
) {
   TopAppBar(

        title = {Text(text = "Sports!", style = MaterialTheme.typography.titleMedium)},
        modifier = modifier.height(46.dp),
        navigationIcon = {
            if(canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = ""
                    )
                }

            }

        },
    )


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MyNewToolBar(

) {
    CenterAlignedTopAppBar(

        title = {Text(text = "Sports", style = MaterialTheme.typography.titleMedium)},
        navigationIcon = {
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Filled.Menu, "")
            }
        },
    )


}

