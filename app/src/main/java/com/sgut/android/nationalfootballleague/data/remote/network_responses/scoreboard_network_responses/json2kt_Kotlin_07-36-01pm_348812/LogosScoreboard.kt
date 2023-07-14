package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.LogosModel


data class LogosScoreboard (

  @SerializedName("href"        ) var href        : String?           = null,
  @SerializedName("width"       ) var width       : Int?              = null,
  @SerializedName("height"      ) var height      : Int?              = null,
  @SerializedName("alt"         ) var alt         : String?           = null,
  @SerializedName("rel"         ) var rel         : ArrayList<String> = arrayListOf(),
  @SerializedName("lastUpdated" ) var lastUpdated : String?           = null

)

fun LogosScoreboard.asDomain() : LogosModel {
  return LogosModel(
    href = href ?: "",
    alt =  alt ?: "",
    rel = rel,
    width = width ?: 0,
    height = height ?: 0

  )
}