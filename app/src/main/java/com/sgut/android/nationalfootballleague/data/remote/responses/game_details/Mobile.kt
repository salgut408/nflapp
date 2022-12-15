package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Mobile (

  @SerializedName("leagues" ) var leagues : Leagues? = Leagues()

)