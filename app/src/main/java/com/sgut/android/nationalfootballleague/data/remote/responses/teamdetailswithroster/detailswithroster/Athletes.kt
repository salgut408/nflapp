package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import java.util.Objects


data class Athletes (

  @SerializedName("id"             ) var id             : String           = "",
  @SerializedName("uid"            ) var uid            : String         = "",
  @SerializedName("guid"           ) var guid           : String         = "",
  @SerializedName("type"           ) var type           : String           = "",
  @SerializedName("alternateIds"   ) var alternateIds   : AlternateIds?     = AlternateIds(),
  @SerializedName("firstName"      ) var firstName      : String           = "",
  @SerializedName("lastName"       ) var lastName       : String           = "",
  @SerializedName("fullName"       ) var fullName       : String           = "",
  @SerializedName("displayName"    ) var displayName    : String           = "",
  @SerializedName("shortName"      ) var shortName      : String           = "",
  @SerializedName("weight"         ) var weight         : Int?              = null,
  @SerializedName("displayWeight"  ) var displayWeight  : String           = "",
  @SerializedName("height"         ) var height         : Int?              = null,
  @SerializedName("displayHeight"  ) var displayHeight  : String           = "",
  @SerializedName("age"            ) var age            : Int?              = null,
  @SerializedName("dateOfBirth"    ) var dateOfBirth    : String           = "",
  @SerializedName("debutYear"      ) var debutYear      : Int?              = null,
//  @SerializedName("links"          ) var links3          : List<Links3>  = listOf(),
  @SerializedName("birthPlace"     ) var birthPlace     : BirthPlace?       = BirthPlace(),
//  @SerializedName("college"        ) var college        : College?          = College(),
  @SerializedName("slug"           ) var slug           : String           = "",
  @SerializedName("headshot"       ) var headshot       : Headshot         = Headshot(),
  @SerializedName("jersey"         ) var jersey         : String           = "",
  @SerializedName("position"       ) var position       : Position         = Position(),
  @SerializedName("injuries"       ) var injuries       : List<Injury>? = listOf(),
  @SerializedName("linked"         ) var linked         : Boolean?          = null,
//  @SerializedName("teams"          ) var teams          : List<Teams>  = listOf(),
//  @SerializedName("projections"    ) var projections    : Projections?      = Projections(),
  @SerializedName("experience"     ) var experience     : Experience?       = Experience(),
//  @SerializedName("collegeAthlete" ) var collegeAthlete : CollegeAthlete?   = CollegeAthlete(),
  @SerializedName("active"         ) var active         : Boolean?          = null,
//  @SerializedName("eventLog"       ) var eventLog       : EventLog?         = EventLog(),
  @SerializedName("draft"          ) var draft          : Draft?            = Draft(),
//  @SerializedName("status"         ) var status         : Status?           = Status()
  @SerializedName("flag"         ) var flag         : Flag?          = Flag()
)

data class Flag(
    @SerializedName("href"         ) var href         : String?           = ""

)

  data class Injury (
    @SerializedName("shortComment"         ) var shortComment         : String?           = null,
    @SerializedName("longComment"         ) var longComment         : String?           = null,
    @SerializedName("status"         ) var injuryStatus         : String?           = null,
    @SerializedName("details"         ) var detail         : Details?         = null,


    )

data class Details (
  @SerializedName("type"         ) var type         : String?           = null,
  @SerializedName("location"         ) var location         : String?           = null,
  @SerializedName("side"         ) var side         : String?           = null,
  @SerializedName("detail"         ) var detail         : String?           = null,
  @SerializedName("returnDate"         ) var returnDate         : String?           = null,
  )


























