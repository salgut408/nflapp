package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.DefaultLogo

data class LogoTennisModel(
    val alt: String = "",
    val height: Int = 0,
   override val href: String = "",
    val lastUpdated: String = "",
    val width: Int = 0
): DefaultLogo