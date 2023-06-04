package com.sgut.android.nationalfootballleague.ui.screens.basics.log_in

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.BasicButton
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.BasicTextButton
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.EmailField
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.PasswordField
import com.sgut.android.nationalfootballleague.utils.basicButton
import com.sgut.android.nationalfootballleague.utils.fieldModifier
import com.sgut.android.nationalfootballleague.utils.textButton
import com.sgut.android.nationalfootballleague.R.string as AppText


@Composable
fun LoginScreen(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LogInViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState

    val showSnackbar by viewModel.showSnackbar


    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailField(
            uiState.email,
            viewModel::onEmailChange,
            Modifier.fieldModifier()
        )
        PasswordField(
            uiState.password,
            viewModel::onPasswordChange,
            Modifier.fieldModifier()
        )

        BasicButton(
            AppText.sign_in, Modifier.basicButton()
        ) {
            viewModel.onSignInClick(openAndPopUp)
        }

        Toast.makeText(LocalContext.current, "HELLO", Toast.LENGTH_SHORT).show()

        BasicTextButton(
            AppText.forgot_password,
            Modifier.textButton()
        ) {
            viewModel.onForgotPasswordClick()
        }
    }
}