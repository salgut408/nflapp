package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class DrivesModel(
    val previous : List<PreviousModel> = listOf()

)

data class DueUpItemModel (
    val playerId: String = "",
    val batOrder: String = ""
        )







