package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.AddressModel


data class Address3(

  @SerializedName("city")
  val city: String? = null,
  @SerializedName("state")
  val state: String? = null,
  @SerializedName("zipCode")
  val zipCode: String? = null,

  )

fun Address3.asDomain(): AddressModel {
    return AddressModel(
        city = city ?: "",
        state = state ?: "",
        zipCode = zipCode ?: ""
    )
}