package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Record (

  @SerializedName("items" ) var items : List<Items> = listOf()

)