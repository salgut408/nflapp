package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class NFLTeamsResponse (

  @SerializedName("sports" ) var sports : List<Sports>?

)