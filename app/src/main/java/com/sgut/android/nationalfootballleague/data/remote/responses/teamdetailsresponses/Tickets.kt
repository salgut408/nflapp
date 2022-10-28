package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Tickets (

  @SerializedName("id"              ) var id              : String?          = null,
  @SerializedName("summary"         ) var summary         : String?          = null,
  @SerializedName("description"     ) var description     : String?          = null,
  @SerializedName("maxPrice"        ) var maxPrice        : Int?             = null,
  @SerializedName("startingPrice"   ) var startingPrice   : Int?             = null,
  @SerializedName("numberAvailable" ) var numberAvailable : Int?             = null,
  @SerializedName("totalPostings"   ) var totalPostings   : Int?             = null,
  @SerializedName("links"           ) var links           : List<Links> = listOf()

)