package com.sgut.android.nationalfootballleague.splashscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.FirebaseException
import com.sgut.android.nationalfootballleague.data.service.AccountService
import com.sgut.android.nationalfootballleague.data.service.LogService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val accountService: AccountService,
): ViewModel() {

    val showError = mutableStateOf(false)

    init{}

      fun onAppStart (
        openAndPopUp: (String, String) -> Unit

    ) = viewModelScope.launch {

        showError.value = false
        if(accountService.hasUser){
            openAndPopUp("detailScreen", "splashScreen")
        } else {
            createAnonymousAccount(openAndPopUp)
        }
    }

    private suspend fun createAnonymousAccount(
        openAndPopUp: (String, String) -> Unit
    ) {
        try {
            accountService.createAnonymousAccount()
        } catch (ex: FirebaseException) {
            showError.value = true
            throw ex
        }
        openAndPopUp("DetailsScreen", "SplashScreen")
    }

}