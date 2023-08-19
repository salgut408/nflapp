package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.DefaultStatusInterface

data class StatusTennisModelX(
    val period: Int = 0,
   override val type: TypeTennisModelX = TypeTennisModelX()
): DefaultStatusInterface