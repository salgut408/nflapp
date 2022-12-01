package com.sgut.android.nationalfootballleague.log_in

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.commoncomposables.NavigationScreens
import com.sgut.android.nationalfootballleague.commoncomposables.snackbar.SnackbarManager
import com.sgut.android.nationalfootballleague.data.service.AccountService
import com.sgut.android.nationalfootballleague.utils.isValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.sgut.android.nationalfootballleague.R.string as AppText

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val accountService: AccountService,
    ) : ViewModel() {

    private val _showSnackbar = mutableStateOf(false)
    val showSnackbar
        get() = _showSnackbar


    var uiState = mutableStateOf(LoginUiState())
        private set

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
        if (!email.isValidEmail()) {
            _showSnackbar.value = true
            return
        }

        if (password.isBlank()) {
            _showSnackbar.value = true
            return
        }

        viewModelScope.launch {
            accountService.authenticate(email, password)
            openAndPopUp(NavigationScreens.SettingsScreen.route, NavigationScreens.SignUpScreen.route )
        }
    }

    fun onForgotPasswordClick() {
        if (!email.isValidEmail()) {
            _showSnackbar.value = true
            return
        }

        viewModelScope.launch {
            accountService.sendRecoveryEmail(email)
            _showSnackbar.value = true
        }
    }

    fun dismissSnackbar() {
        _showSnackbar.value = false
    }
}
