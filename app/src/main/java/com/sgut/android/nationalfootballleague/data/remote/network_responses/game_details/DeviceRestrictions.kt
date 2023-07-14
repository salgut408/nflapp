package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class DeviceRestrictions (

  @SerializedName("type"    ) var type    : String?           = null,
  @SerializedName("devices" ) var devices : ArrayList<String> = arrayListOf()

)