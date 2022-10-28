package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class TeamDetailResponse (

  @SerializedName("team" ) var team : Team? = Team()

)