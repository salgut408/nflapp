package com.sgut.android.nationalfootballleague.domain

import androidx.compose.runtime.MutableState
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel

data class UiState(
    val currentSport: String = "",
    val isLoading: Boolean = true,
    val isError: Boolean = false,
)
