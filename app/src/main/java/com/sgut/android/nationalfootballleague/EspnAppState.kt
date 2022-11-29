package com.sgut.android.nationalfootballleague

import android.content.res.Resources
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Stable
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavHostController
import com.sgut.android.nationalfootballleague.commoncomposables.snackbar.SnackbarManager
import com.sgut.android.nationalfootballleague.commoncomposables.snackbar.SnackbarMessage.Companion.toMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

@Stable
class EspnAppState(
    val navController: NavHostController,
    private val snackbarManager: SnackbarManager,
    private val resources: Resources,
    coroutineScope: CoroutineScope,
    snackbarHostState: SnackbarHostState

) {
    init {
        coroutineScope.launch{
            snackbarManager.snackbarMessages.filterNotNull().collect(){snackbarMessage ->
                val text = snackbarMessage.toMessage(resources)
                snackbarHostState.showSnackbar(text)
            }

        }
    }

    fun popUp() {
        navController.popBackStack()
    }

    fun navigate(route: String) {
        navController.navigate(route) { launchSingleTop = true }
    }

    fun navigateAndPopUp(route: String, popUp: String) {
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(popUp) { inclusive = true }
        }
    }

    fun clearAndNavigate(route: String) {
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(0) {
                inclusive = true
            }
        }
    }


}


