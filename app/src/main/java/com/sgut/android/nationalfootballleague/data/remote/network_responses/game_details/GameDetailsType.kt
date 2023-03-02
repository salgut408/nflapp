package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsType(

  @SerializedName("id") var id: String = "",
  @SerializedName("name") var name: String = "",
  @SerializedName("completed") var completed: Boolean = false,
  @SerializedName("description") var description: String = "",
  @SerializedName("detail") var gameTimeDetail: String = "",
  @SerializedName("shortDetail") var shortGameTimeDetail: String = "",
  @SerializedName("text") var text: String = "",
  @SerializedName("abbreviation") var abbreviation: String = "",





  )