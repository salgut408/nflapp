package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Position (

  @SerializedName("id"           ) var id           : String  = "",
  @SerializedName("name"         ) var name         : String  = "",
  @SerializedName("displayName"  ) var displayName  : String  = "",
  @SerializedName("abbreviation" ) var abbreviation : String  = "",
  @SerializedName("leaf"         ) var leaf         : Boolean? = null,
  @SerializedName("parent"       ) var parent       : Parent3?  = Parent3()

)