package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Market (

  @SerializedName("id"   ) var id   : String? = null,
  @SerializedName("type" ) var type : String? = null

)