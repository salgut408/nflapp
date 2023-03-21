package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsType(

  @SerializedName("id")
  val id: String = "",
  @SerializedName("name")
  val name: String = "",
  @SerializedName("completed")
  val completed: Boolean = false,
  @SerializedName("description")
  val description: String = "",
  @SerializedName("detail")
  val gameTimeDetail: String = "",
  @SerializedName("shortDetail")
  val shortGameTimeDetail: String = "",
  @SerializedName("text")
  val text: String = "",
  @SerializedName("abbreviation")
  val abbreviation: String = "",





  )