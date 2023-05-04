package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.InningPrefix

data class GameDetailsStatusModel (
    val type: GameDetailsTypeModel? = GameDetailsTypeModel(),
    val periodPrefix: InningPrefix? = InningPrefix.PRE
)