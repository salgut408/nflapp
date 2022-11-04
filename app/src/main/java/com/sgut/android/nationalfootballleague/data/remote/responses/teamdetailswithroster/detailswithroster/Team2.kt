package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Team3 (

  @SerializedName("id"               ) var id               : String?              = null,
  @SerializedName("uid"              ) var uid              : String?              = null,
  @SerializedName("slug"             ) var slug             : String?              = null,
  @SerializedName("location"         ) var location         : String?              = null,
  @SerializedName("name"             ) var name             : String?              = null,
  @SerializedName("nickname"         ) var nickname         : String?              = null,
  @SerializedName("abbreviation"     ) var abbreviation     : String?              = null,
  @SerializedName("displayName"      ) var displayName      : String?              = null,
  @SerializedName("shortDisplayName" ) var shortDisplayName : String?              = null,
  @SerializedName("color"            ) var color            : String?              = null,
  @SerializedName("alternateColor"   ) var alternateColor   : String?              = null,
  @SerializedName("isActive"         ) var isActive         : Boolean?             = null,
  @SerializedName("logos"            ) var logos            : List<Logos3>     = listOf(),
  @SerializedName("record"           ) var record           : Record3?              = Record3(),
  @SerializedName("athletes"         ) var athletes         : List<Athletes>  = listOf(),
  @SerializedName("groups"           ) var groups           : Groups3?              = Groups3(),
  @SerializedName("links"            ) var links            : List<Links3>     = listOf(),
  @SerializedName("franchise"        ) var franchise        : Franchise3?           = Franchise3(),
  @SerializedName("nextEvent"        ) var nextEvent        : List<NextEvent3> = listOf(),
  @SerializedName("standingSummary"  ) var standingSummary  : String?              = null

)