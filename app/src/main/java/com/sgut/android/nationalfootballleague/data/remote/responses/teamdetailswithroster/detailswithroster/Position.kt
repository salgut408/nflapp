package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Position (

  @SerializedName("id"           ) var id           : String?  = null,
  @SerializedName("name"         ) var name         : String?  = null,
  @SerializedName("displayName"  ) var displayName  : String?  = null,
  @SerializedName("abbreviation" ) var abbreviation : String?  = null,
  @SerializedName("leaf"         ) var leaf         : Boolean? = null,
  @SerializedName("parent"       ) var parent       : Parent3?  = Parent3()

)