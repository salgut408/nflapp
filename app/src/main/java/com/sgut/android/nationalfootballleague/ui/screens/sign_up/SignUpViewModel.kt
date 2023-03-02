package com.sgut.android.nationalfootballleague.ui.screens.sign_up

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.ui.navigation.NavigationScreens
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.snackbar.SnackbarManager
import com.sgut.android.nationalfootballleague.data.service.AccountService
import com.sgut.android.nationalfootballleague.utils.isValidEmail
import com.sgut.android.nationalfootballleague.utils.isValidPassword
import com.sgut.android.nationalfootballleague.utils.passwordMatches
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.sgut.android.nationalfootballleague.R.string as AppText
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val accountService: AccountService
): ViewModel() {

    var uiState = mutableStateOf(SignUpUiState())

    private val email
        get() = uiState.value.email

    private val password
        get() = uiState.value.password

    fun onEmailChange(newValue: String) {
     uiState.value =   uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
      uiState.value =  uiState.value.copy(password = newValue)
    }

    fun onRepeatPasswordChange(newValue: String) {
        uiState.value =  uiState.value.copy(repeatPassword = newValue)
    }

    fun onSignUpClick(openAndPopUp:(String, String)-> Unit) {
        if(!email.isValidEmail()){
            SnackbarManager.showMessage(AppText.email_error)
        }

        if (!password.isValidPassword()) {
            SnackbarManager.showMessage(AppText.password_error)
            return
        }


        if (!password.passwordMatches(uiState.value.repeatPassword)) {
            SnackbarManager.showMessage(AppText.password_match_error)

            return
        }

        viewModelScope.launch {
            accountService.linkAccount(email, password)
            openAndPopUp(NavigationScreens.SettingsScreen.route, NavigationScreens.SignUpScreen.route )
        }
    }




}