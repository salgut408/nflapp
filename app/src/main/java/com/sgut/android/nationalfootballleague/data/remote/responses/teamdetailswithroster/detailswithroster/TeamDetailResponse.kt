package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class TeamDetailResponse2 (

  @SerializedName("team" ) var team : Team3? = Team3()

)