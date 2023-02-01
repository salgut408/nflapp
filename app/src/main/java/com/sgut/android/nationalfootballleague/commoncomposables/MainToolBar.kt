package com.sgut.android.nationalfootballleague.di

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNewToolBar2(
    currentScreen: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
) {

    TopAppBar(

        title = { Text(text = currentScreen) },

        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = ""
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicToolBar(
    @StringRes title: Int,
) {
    TopAppBar(
        title = { Text(stringResource(title)) },

        )
}


@Composable
fun ActionToolbar(
    @StringRes title: Int,
    @DrawableRes endActionIcon: Int,
    modifier: Modifier,
    endAction: () -> Unit,
) {
    androidx.compose.material.TopAppBar(
        title = { androidx.compose.material.Text(stringResource(title)) },
        actions = {
            Box(modifier) {
                androidx.compose.material.IconButton(onClick = endAction) {
                    androidx.compose.material.Icon(painter = painterResource(endActionIcon),
                        contentDescription = "Action")
                }
            }
        }
    )
}
