package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteTeamNetwork(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("alternateColor")
    val alternateColor: String = "",
    @SerializedName("athletes")
    val athletes: FullAthleteAthletesNetwork = FullAthleteAthletesNetwork(),
    @SerializedName("coaches")
    val coaches: FullAthleteCoachesNetwork = FullAthleteCoachesNetwork(),
    @SerializedName("color")
    val color: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("franchise")
    val franchise: FullAthleteFranchiseNetwork = FullAthleteFranchiseNetwork(),
    @SerializedName("groups")
    val groups: FullAthleteGroupsNetwork = FullAthleteGroupsNetwork(),
    @SerializedName("guid")
    val guid: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("isActive")
    val isActive: Boolean = false,
    @SerializedName("isAllStar")
    val isAllStar: Boolean = false,
    @SerializedName("links")
    val links: List<FullAthleteLinkNetworkXX> = listOf(),
    @SerializedName("location")
    val location: String = "",
    @SerializedName("logos")
    val logos: List<FullAthleteLogoNetwork> = listOf(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("ranks")
    val ranks: FullAthleteRanksNetwork = FullAthleteRanksNetwork(),
    @SerializedName("record")
    val record: FullAthleteRecordNetwork = FullAthleteRecordNetwork(),
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("uid")
    val uid: String = ""
)