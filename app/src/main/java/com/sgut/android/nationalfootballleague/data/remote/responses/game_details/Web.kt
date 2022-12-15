package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Web (

  @SerializedName("leagues" ) var leagues : Leagues? = Leagues()

)