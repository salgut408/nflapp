package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class FormatScoreboard (

  @SerializedName("regulation" ) var regulation : RegulationScoreboard? = RegulationScoreboard()

)