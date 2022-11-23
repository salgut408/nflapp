package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class TeamScoreboard (

  @SerializedName("id" ) var id : String? = null,
  @SerializedName("abbreviation" ) var abbreviation : String? = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("logos"            ) var logos            : ArrayList<Logos> = arrayListOf(),
  @SerializedName("color"            ) var color            : String?          = null,





  )