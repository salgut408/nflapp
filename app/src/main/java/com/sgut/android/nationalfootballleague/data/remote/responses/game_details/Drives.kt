package com.sgut.android.nationalfootballleague.data.remote.responses.game_details

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.Previous

data class Drives (

    @SerializedName("previous" ) var previous : List<Previous> = listOf()

)