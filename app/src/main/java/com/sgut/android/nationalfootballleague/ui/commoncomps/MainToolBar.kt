package com.sgut.android.nationalfootballleague.di

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource


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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerTopAppBar(
    openDrawer: ()->Unit,
    onNhlClick: () -> Unit,
    onNflClick: () -> Unit,
    onMlbClick: () -> Unit,
    onNbaClick: () -> Unit,
    onWnbaClick: () -> Unit,
    onNcaaFootballClick: () -> Unit,





    ) {
    TopAppBar(
        title = { Text(text = "Sport")},
        navigationIcon = {
//            MoreSportsMenu(onSportClick)
                         },
        actions = {
            MoreSportsMenu(onNhlClick, onNflClick, onMlbClick, onNbaClick, onWnbaClick, onNcaaFootballClick)
                  },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun MoreSportsMenu(
    onNhlClick: () -> Unit,
    onNflClick: () -> Unit,
    onMlbClick: () -> Unit,
    onNbaClick: () -> Unit,
    onWnbaClick: () -> Unit,
    onNcaaFootballClick: () -> Unit,






    ) {
    TopAppBarDropdownMenu(icontContent = {
        Icon(Icons.Filled.MoreVert, null)

    }) { closeMenu ->
        DropdownMenuItem(text = { Text(text = "NHL") }, onClick = { onNhlClick(); closeMenu()})
        DropdownMenuItem(text = { Text(text = "NFL") }, onClick = { onNflClick(); closeMenu()})
        DropdownMenuItem(text = { Text(text = "MLB") }, onClick = { onMlbClick(); closeMenu()})
        DropdownMenuItem(text = { Text(text = "NBA") }, onClick = { onNbaClick(); closeMenu()})
        DropdownMenuItem(text = { Text(text = "WNBA") }, onClick = { onWnbaClick(); closeMenu()})
        DropdownMenuItem(text = { Text(text = "NCAA Football") }, onClick = { onNcaaFootballClick(); closeMenu()})







    }
}

@Composable
fun TopAppBarDropdownMenu(
    icontContent: @Composable () -> Unit,
    content: @Composable ColumnScope.(() -> Unit) -> Unit
) {
    var expanded by remember { mutableStateOf(false)}
    Box(modifier = Modifier.wrapContentSize(Alignment.TopEnd)){
        IconButton(onClick = { expanded = true }) {
            icontContent()
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.wrapContentSize(Alignment.TopEnd)
        ) {
            content {expanded != expanded}
        }
    }

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
