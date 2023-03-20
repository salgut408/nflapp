package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.DomainLogoModel


data class GameDetailsLogos(

  @SerializedName("href")
  val href: String? = null,
  @SerializedName("width")
  val width: Int? = null,
  @SerializedName("height")
  val height: Int? = null,
  @SerializedName("alt")
  val alt: String? = null,
  @SerializedName("rel")
  val rel: ArrayList<String> = arrayListOf(),
  @SerializedName("lastUpdated")
  val lastUpdated: String? = null,

  )

fun GameDetailsLogos.asDomainLogo(): DomainLogoModel {
  return DomainLogoModel(
    width = width ?: 0,
    height = height ?: 0,
    href = href ?: ""
    )
}