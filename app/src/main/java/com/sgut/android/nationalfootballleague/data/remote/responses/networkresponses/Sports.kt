package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Sports (

  @SerializedName("id"      ) var id      : String?            = null,
  @SerializedName("uid"     ) var uid     : String?            = null,
  @SerializedName("name"    ) var name    : String?            = null,
  @SerializedName("slug"    ) var slug    : String?            = null,
  @SerializedName("leagues" ) var leagues : List<Leagues>?

)