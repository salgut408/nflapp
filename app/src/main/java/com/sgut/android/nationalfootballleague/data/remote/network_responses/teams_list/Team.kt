package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Team (

  @SerializedName("id"               ) var id               : String          = "",
  @SerializedName("uid"              ) var uid              : String          = "",
  @SerializedName("slug"             ) var slug             : String          = "",
  @SerializedName("abbreviation"     ) var abbreviation     : String          = "",
  @SerializedName("displayName"      ) var displayName      : String          = "",
  @SerializedName("shortDisplayName" ) var shortDisplayName : String          = "",
  @SerializedName("name"             ) var name             : String          = "",
  @SerializedName("nickname"         ) var nickname         : String          = "",
  @SerializedName("location"         ) var location         : String          = "",
  @SerializedName("color"            ) var color            : String          = "",
  @SerializedName("alternateColor"   ) var alternateColor   : String          = "",
  @SerializedName("isActive"         ) var isActive         : Boolean?         = null,
  @SerializedName("isAllStar"        ) var isAllStar        : Boolean?         = null,
  @SerializedName("logos"            ) var logos            : ArrayList<Logos> = arrayListOf(),
  @SerializedName("links"            ) var links            : ArrayList<Links> = arrayListOf()

)