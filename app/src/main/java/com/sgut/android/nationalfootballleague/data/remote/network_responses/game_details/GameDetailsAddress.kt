package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.AddressModel


//same as
data class GameDetailsAddress(

  @SerializedName("city")
  val city: String = "",
  @SerializedName("state")
  val state: String = "",
  @SerializedName("zipCode")
  val zipCode: String = "",

  )

fun GameDetailsAddress.asDomain(): AddressModel {
    return AddressModel(
      city = city ,
      state = state ,
      zipCode = zipCode
    )
}