package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.ProviderModel


data class Provider(

  @SerializedName("id")
  val id: String? = null,
  @SerializedName("name")
  val name: String? = null,
  @SerializedName("priority")
  val priority: Int? = null,

  )

fun Provider.asDomain(): ProviderModel {
  return ProviderModel(
    id = id ?: "",
    name = name ?: "",
    priority = priority ?: 0
  )
}