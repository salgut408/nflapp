package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class FullViewLink (

  @SerializedName("text" ) var text : String? = null,
  @SerializedName("href" ) var href : String? = null

)