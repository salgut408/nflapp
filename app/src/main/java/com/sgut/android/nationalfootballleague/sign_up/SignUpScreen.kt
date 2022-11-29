package com.sgut.android.nationalfootballleague.sign_up

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.hilt.navigation.compose.hiltViewModel
import com.sgut.android.nationalfootballleague.commoncomposables.BasicButton
import com.sgut.android.nationalfootballleague.commoncomposables.EmailField
import com.sgut.android.nationalfootballleague.commoncomposables.PasswordField
import com.sgut.android.nationalfootballleague.commoncomposables.RepeatPasswordField
import com.sgut.android.nationalfootballleague.utils.basicButton
import com.sgut.android.nationalfootballleague.utils.fieldModifier
import com.sgut.android.nationalfootballleague.R.string as AppText

@Composable
fun SignUpScreen(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState
    val fieldModifier = Modifier.fieldModifier()

    Column(
        modifier = modifier.fillMaxWidth().fillMaxHeight().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailField(uiState.email, viewModel::onEmailChange, fieldModifier)
        PasswordField(uiState.password, viewModel::onPasswordChange, fieldModifier)
        RepeatPasswordField(uiState.repeatPassword, viewModel::onRepeatPasswordChange, fieldModifier)

        BasicButton(AppText.create_account, Modifier.basicButton()) {
            viewModel.onSignUpClick(openAndPopUp)
        }
    }
}