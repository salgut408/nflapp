package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.LogosModel


data class Logos (

  @SerializedName("href"   ) val href   : String?           = null,
  @SerializedName("alt"    ) val alt    : String?           = null,
  @SerializedName("rel"    ) val rel    : List<String> = listOf(),
  @SerializedName("width"  ) val width  : Int?              = null,
  @SerializedName("height" ) val height : Int?              = null

)


fun Logos.asDomainModel(): LogosModel{
  return LogosModel(
    href = href ?: "",
    alt = alt ?: "",
    rel = rel,
    width = width ?: 0,
    height = height ?: 0
  )
}