package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Team2 (

  @SerializedName("id"               ) var id               : String?              = null,
  @SerializedName("uid"              ) var uid              : String?              = null,
  @SerializedName("slug"             ) var slug             : String?              = null,
  @SerializedName("location"         ) var location         : String?              = null,
  @SerializedName("name"             ) var name             : String?              = null,
  @SerializedName("abbreviation"     ) var abbreviation     : String?              = null,
  @SerializedName("displayName"      ) var displayName      : String?              = null,
  @SerializedName("shortDisplayName" ) var shortDisplayName : String?              = null,
  @SerializedName("color"            ) var color            : String?              = null,
  @SerializedName("alternateColor"   ) var alternateColor   : String?              = null,
  @SerializedName("isActive"         ) var isActive         : Boolean?             = null,
  @SerializedName("logos"            ) var logos2            : List<Logos2>     = listOf(),
  @SerializedName("record"           ) var record           : Record?              = Record(),
  @SerializedName("groups"           ) var groups           : Groups?              = Groups(),
  @SerializedName("links"            ) var links2            : List<Links2>     = listOf(),
  @SerializedName("franchise"        ) var franchise        : Franchise?           = Franchise(),
  @SerializedName("nextEvent"        ) var nextEvent        : List<NextEvent> = listOf(),
  @SerializedName("standingSummary"  ) var standingSummary  : String?              = null

)