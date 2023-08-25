package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.golf.Flag

data class AthleteGolf(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("flag")
    val flag: Flag = Flag(),
    @SerializedName("fullName")
    val fullName: String = "",
    @SerializedName("shortName")
    val shortName: String = ""
)