package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Team3 (

  @SerializedName("id"               ) var id               : String              = "",
  @SerializedName("uid"              ) var uid              : String             = "",
  @SerializedName("slug"             ) var slug             : String              = "",
  @SerializedName("location"         ) var location         : String              = "",
  @SerializedName("name"             ) var name             : String              = "",
  @SerializedName("nickname"         ) var nickname         : String              = "",
  @SerializedName("abbreviation"     ) var abbreviation     : String              = "",
  @SerializedName("displayName"      ) var displayName      : String              = "",
  @SerializedName("shortDisplayName" ) var shortDisplayName : String              = "",
  @SerializedName("color"            ) var color            : String              = "",
  @SerializedName("alternateColor"   ) var alternateColor   : String              = "FFFF",
  @SerializedName("isActive"         ) var isActive         : Boolean?             = null,
  @SerializedName("logos"            ) var logos            : List<Logos3>     = listOf(),
  @SerializedName("record"           ) var record           : Record3?              = Record3(),
  @SerializedName("athletes"         ) var athletes         : List<Athletes>  = listOf(),
  @SerializedName("groups"           ) var groups           : Groups3?              = Groups3(),
  @SerializedName("links"            ) var links            : List<Links3>     = listOf(),
  @SerializedName("franchise"        ) var franchise        : Franchise3?           = Franchise3(),
  @SerializedName("nextEvent"        ) var nextEvent        : List<NextEvent3> = listOf(),
  @SerializedName("standingSummary"  ) var standingSummary  : String              = ""

)

