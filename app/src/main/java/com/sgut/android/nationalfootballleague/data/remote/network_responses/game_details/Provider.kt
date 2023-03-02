package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Provider (

  @SerializedName("id"       ) var id       : String? = null,
  @SerializedName("name"     ) var name     : String? = null,
  @SerializedName("priority" ) var priority : Int?    = null

)