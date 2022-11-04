package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Record3 (

  @SerializedName("items" ) var items : List<Items3> = listOf()

)