package com.sgut.android.nationalfootballleague.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.data.service.AccountService
import com.sgut.android.nationalfootballleague.data.service.StorageService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val accountService: AccountService,
    private val storageService: StorageService
): ViewModel() {
    val uiState = accountService.currentUser.map {
        SettingsUiState(it.isAnonymous)
    }

    fun onLogInClick(openScreen: (String)->Unit) = openScreen("LOGIN_SCREEN")

    fun onSignUpClick(openScreen: (String) -> Unit) = openScreen("SIGN_UP_SCREEN")

    fun onSignOutClick(restartApp: (String) -> Unit) = viewModelScope.launch{
            accountService.signOut()
            restartApp("SPLASH_SCREEN")
    }


    fun onDeleteMyAccountClick(restartApp: (String) -> Unit) = viewModelScope.launch {

            storageService.deleteAllTeamsForUser(accountService.currentUserId)
            accountService.deleteAccount()
            restartApp("SPLASH_SCREEN")
        }

}