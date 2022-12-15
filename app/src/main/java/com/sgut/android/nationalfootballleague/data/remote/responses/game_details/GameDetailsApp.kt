package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsApp (

  @SerializedName("sportscenter" ) var sportscenter : Sportscenter? = Sportscenter()

)