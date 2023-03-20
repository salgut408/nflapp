package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsRegulation(

  @SerializedName("periods")
  val periods: Int? = null,
  @SerializedName("displayName")
  val displayName: String? = null,
  @SerializedName("slug")
  val slug: String? = null,
  @SerializedName("clock")
  val clock: Int? = null,

  )