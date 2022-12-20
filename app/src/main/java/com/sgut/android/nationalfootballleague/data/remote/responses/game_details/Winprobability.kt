package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Winprobability (

    @SerializedName("tiePercentage"     ) var tiePercentage     : Int?    = null,
    @SerializedName("homeWinPercentage" ) var homeWinPercentage : Double? = null,
    @SerializedName("secondsLeft"       ) var secondsLeft       : Int?    = null,
    @SerializedName("playId"            ) var playId            : String? = null

)