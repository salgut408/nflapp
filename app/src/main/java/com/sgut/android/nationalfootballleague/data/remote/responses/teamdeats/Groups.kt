package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Groups (

  @SerializedName("id"           ) var id           : String?  = null,
  @SerializedName("parent"       ) var parent       : Parent?  = Parent(),
  @SerializedName("isConference" ) var isConference : Boolean? = null

)