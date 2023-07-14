package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class FullViewLink (

  @SerializedName("text" ) val text : String? = null,
  @SerializedName("href" ) val href : String? = null

)