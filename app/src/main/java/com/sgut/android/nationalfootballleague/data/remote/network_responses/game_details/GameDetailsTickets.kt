package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsTickets (

  @SerializedName("ticketName" ) var ticketName : String? = null,
  @SerializedName("ticketLink" ) var ticketLink : String? = null,
  @SerializedName("type"       ) var type       : String? = null

)