package com.sgut.android.nationalfootballleague.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.sgut.android.nationalfootballleague.commoncomposables.RegularCardEditor
import com.sgut.android.nationalfootballleague.utils.card
import com.sgut.android.nationalfootballleague.utils.spacer
import com.sgut.android.nationalfootballleague.R.string as AppText

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val uiState = viewModel.uiState.collectAsState(initial = SettingsUiState(false))


    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.spacer())

        if(uiState.value.isAnonymousAccount) {
            RegularCardEditor(title = AppText.sign_in,  content = "", modifier = Modifier.card()) {
//                viewModel.onLogInClick()
            }
            RegularCardEditor(AppText.create_account,  "", Modifier.card()) {
//                viewModel.onSignUpClick(openScreen)
            }
        } else {
//            SignOutCard {
////                viewModel.onSignOutClick(restartApp)
//            }
//            DeleteMyAccountCard {
//                viewModel.onDeleteMyAccountClick(restartApp)
//            }
        }

    }




}