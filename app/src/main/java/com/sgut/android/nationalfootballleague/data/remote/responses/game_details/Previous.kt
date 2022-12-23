package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Previous (

    @SerializedName("id"                 ) var id                 : String?          = null,
    @SerializedName("description"        ) var description        : String?          = null,
    @SerializedName("team"               ) var team               : Team?            = Team(),
    @SerializedName("start"              ) var start              : Start?           = Start(),
    @SerializedName("end"                ) var end                : End?             = End(),
    @SerializedName("timeElapsed"        ) var timeElapsed        : TimeElapsed?     = TimeElapsed(),
    @SerializedName("yards"              ) var yards              : Int?             = null,
    @SerializedName("isScore"            ) var isScore            : Boolean?         = null,
    @SerializedName("offensivePlays"     ) var offensivePlays     : Int?             = null,
    @SerializedName("result"             ) var result             : String?          = null,
    @SerializedName("shortDisplayResult" ) var shortDisplayResult : String?          = null,
    @SerializedName("displayResult"      ) var displayResult      : String?          = null,
    @SerializedName("plays"              ) var plays              : ArrayList<Plays> = arrayListOf()

)

data class TimeElapsed (

    @SerializedName("displayValue" ) var displayValue : String? = null

)

data class Start (

    @SerializedName("period"   ) var period   : Period? = Period(),
    @SerializedName("clock"    ) var clock    : Clock?  = Clock(),
    @SerializedName("yardLine" ) var yardLine : Int?    = null,
    @SerializedName("text"     ) var text     : String? = null

)

data class Period (

    @SerializedName("type"   ) var type   : String? = null,
    @SerializedName("number" ) var number : Int?    = null

)

data class Clock (

    @SerializedName("displayValue" ) var displayValue : String? = null

)

data class End (

    @SerializedName("period"   ) var period   : Period? = Period(),
    @SerializedName("clock"    ) var clock    : Clock?  = Clock(),
    @SerializedName("yardLine" ) var yardLine : Int?    = null,
    @SerializedName("text"     ) var text     : String? = null

)

data class Plays (

    @SerializedName("id"             ) var id             : String?  = null,
    @SerializedName("sequenceNumber" ) var sequenceNumber : String?  = null,
    @SerializedName("type"           ) var type           : GameDetailsType?    = GameDetailsType(),
    @SerializedName("text"           ) var text           : String?  = null,
    @SerializedName("awayScore"      ) var awayScore      : Int?     = null,
    @SerializedName("homeScore"      ) var homeScore      : Int?     = null,
    @SerializedName("period"         ) var period         : Period?  = Period(),
    @SerializedName("clock"          ) var clock          : Clock?   = Clock(),
    @SerializedName("scoringPlay"    ) var scoringPlay    : Boolean? = null,
    @SerializedName("priority"       ) var priority       : Boolean? = null,
    @SerializedName("modified"       ) var modified       : String?  = null,
    @SerializedName("wallclock"      ) var wallclock      : String?  = null,
    @SerializedName("start"          ) var start          : Start?   = Start(),
    @SerializedName("end"            ) var end            : End?     = End(),
    @SerializedName("statYardage"    ) var statYardage    : Int?     = null

)

data class ScoringPlays (

    @SerializedName("id"          ) var id          : String?      = null,
    @SerializedName("type"        ) var type        : GameDetailsType?        = GameDetailsType(),
    @SerializedName("text"        ) var text        : String?      = null,
    @SerializedName("awayScore"   ) var awayScore   : Int?         = null,
    @SerializedName("homeScore"   ) var homeScore   : Int?         = null,
    @SerializedName("period"      ) var period      : Period?      = Period(),
    @SerializedName("clock"       ) var clock       : Clock?       = Clock(),
    @SerializedName("team"        ) var team        : GameDetailsTeam?        = GameDetailsTeam(),
    @SerializedName("scoringType" ) var scoringType : ScoringType? = ScoringType()

)

data class ScoringType (

    @SerializedName("name"         ) var name         : String? = null,
    @SerializedName("displayName"  ) var displayName  : String? = null,
    @SerializedName("abbreviation" ) var abbreviation : String? = null

)