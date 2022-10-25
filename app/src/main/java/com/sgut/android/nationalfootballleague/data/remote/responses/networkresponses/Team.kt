package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Team (

  @SerializedName("id"               ) var id               : String?          = null,
  @SerializedName("uid"              ) var uid              : String?          = null,
  @SerializedName("slug"             ) var slug             : String?          = null,
  @SerializedName("abbreviation"     ) var abbreviation     : String?          = null,
  @SerializedName("displayName"      ) var displayName      : String?          = null,
  @SerializedName("shortDisplayName" ) var shortDisplayName : String?          = null,
  @SerializedName("name"             ) var name             : String?          = null,
  @SerializedName("nickname"         ) var nickname         : String?          = null,
  @SerializedName("location"         ) var location         : String?          = null,
  @SerializedName("color"            ) var color            : String?          = null,
  @SerializedName("alternateColor"   ) var alternateColor   : String?          = null,
  @SerializedName("isActive"         ) var isActive         : Boolean?         = null,
  @SerializedName("isAllStar"        ) var isAllStar        : Boolean?         = null,
  @SerializedName("logos"            ) var logos            : ArrayList<Logos> = arrayListOf(),
  @SerializedName("links"            ) var links            : ArrayList<Links> = arrayListOf()

)