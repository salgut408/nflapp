package com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.Previous
import com.sgut.android.nationalfootballleague.asDomain
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.DrivesModel

data class Drives (

    @SerializedName("previous" )
    val previous : List<Previous> = listOf()


)

fun Drives.asDomain(): DrivesModel {
    return DrivesModel(
        previous = previous.map { it.asDomain() }
    )
}