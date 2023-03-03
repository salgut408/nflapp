package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models

import com.sgut.android.nationalfootballleague.domain.domainmodels.TeamsDomInterface

data class TeamModel(
    val id: String = "",
    val uid: String = "",
    val slug: String = "",
    val abbreviation: String = "",
    val displayName: String = "",
    val shortDisplayName: String = "",
    val name: String = "",
    val nickname: String = "",
    val location: String = "",
    val color: String = "",
    val alternateColor: String = "",
    val isFavorite: Boolean = false,
    val logos: String = ""
    ) : TeamsDomInterface

