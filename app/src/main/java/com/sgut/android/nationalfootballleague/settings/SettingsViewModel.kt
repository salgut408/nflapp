package com.sgut.android.nationalfootballleague.settings

import androidx.lifecycle.ViewModel
import com.sgut.android.nationalfootballleague.data.service.AccountService
import com.sgut.android.nationalfootballleague.data.service.StorageService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val accountService: AccountService,
    private val storageService: StorageService
): ViewModel() {
    val uiState = accountService.currentUser.map {
        SettingsUiState(it.isAnonymous)
    }
}