package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Type3 (

  @SerializedName("id"          ) var id          : String?  = null,
  @SerializedName("name"        ) var name        : String?  = null,
  @SerializedName("state"       ) var state       : String?  = null,
  @SerializedName("completed"   ) var completed   : Boolean? = null,
  @SerializedName("description" ) var description : String?  = null,
  @SerializedName("detail"      ) var detail      : String?  = null,
  @SerializedName("shortDetail" ) var shortDetail : String?  = null

)