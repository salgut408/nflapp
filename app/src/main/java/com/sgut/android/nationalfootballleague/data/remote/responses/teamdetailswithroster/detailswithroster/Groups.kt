package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Groups3 (

  @SerializedName("id"           ) var id           : String?  = null,
  @SerializedName("parent"       ) var parent       : Parent3?  = Parent3(),
  @SerializedName("isConference" ) var isConference : Boolean? = null

)