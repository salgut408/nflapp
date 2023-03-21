package com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.Logos

data class Rosters(
    @SerializedName("homeAway") val homeAway: String? = null,
    @SerializedName("team") val team: RosterTeam? = RosterTeam(),
//    @SerializedName("roster") val roster: List<Roster> = listOf(),
)

//data class Roster(
////    @SerializedName("active"    ) val active    : Boolean?         = null,
////    @SerializedName("starter"   ) val starter   : Boolean?         = null,
////    @SerializedName("athlete"   ) val athlete   : Athlete?         = Athlete(),
////    @SerializedName("position"  ) val position  : Position?        = Position(),
////    @SerializedName("batOrder"  ) val batOrder  : Int?             = null,
////    @SerializedName("subbedIn"  ) val subbedIn  : Boolean?         = null,
////    @SerializedName("subbedOut" ) val subbedOut : Boolean?         = null,
////    @SerializedName("stats"     ) val stats     : ArrayList<Stats> = arrayListOf(),
////    @SerializedName("jersey"    ) var jersey    : String?          = null
//
//)

data class RosterTeam(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("abbreviation")
    val abbreviation: String? = null,
    @SerializedName("displayName")
    val displayName: String? = null,
    @SerializedName("color")
    val color: String? = null,
    @SerializedName("alternateColor")
    val alternateColor: String? = null,
    @SerializedName("logos")
    val logos: ArrayList<Logos> = arrayListOf(),

    )
