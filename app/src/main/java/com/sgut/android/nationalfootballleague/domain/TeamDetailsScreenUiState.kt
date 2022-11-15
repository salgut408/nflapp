package com.sgut.android.nationalfootballleague.domain

import com.sgut.android.nationalfootballleague.Team3

data class TeamDetailsScreenUiState(
    val isLoading: Boolean = false,
    val throwError: Boolean = false,
    val team: Team3? = null

)
