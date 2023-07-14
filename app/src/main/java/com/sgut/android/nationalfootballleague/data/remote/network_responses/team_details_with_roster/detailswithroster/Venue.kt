package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.VenueModel


data class Venue3 (

  @SerializedName("fullName" )
  val fullName : String  = "",
  @SerializedName("address"  )
  val address  : Address3? = Address3(),
  @SerializedName("images"  )
  val images3: List<Images3> = listOf()

)

fun Venue3.asDomain(): VenueModel {
  return VenueModel(
    fullName = fullName,
    address = address?.asDomain(),
    images3 = images3
  )
}