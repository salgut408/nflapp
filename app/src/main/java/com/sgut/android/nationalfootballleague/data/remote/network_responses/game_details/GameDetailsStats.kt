package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsStats (

  @SerializedName("name"             ) var name             : String? = null,
  @SerializedName("displayName"      ) var displayName      : String? = null,
  @SerializedName("shortDisplayName" ) var shortDisplayName : String? = null,
  @SerializedName("description"      ) var description      : String? = null,
  @SerializedName("abbreviation"     ) var abbreviation     : String? = null,
  @SerializedName("type"             ) var type             : String? = null,
  @SerializedName("value"            ) var value            : Int?    = null,
  @SerializedName("displayValue"     ) var displayValue     : String? = null

)