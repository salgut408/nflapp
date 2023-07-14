package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsSource (

  @SerializedName("href" ) var href : String? = null,
  @SerializedName("headline" ) var headline : String? = null,
  @SerializedName("thumbnail" ) var thumbnail : String? = null,
  @SerializedName("links" ) var links : GameDetailsLinks? = null




)