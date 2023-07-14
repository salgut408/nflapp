package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("alternateColor")
    val alternateColor: String = "",


    @SerializedName("color")
    val color: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("franchise")
    val franchise: Franchise = Franchise(),
    @SerializedName("groups")
    val groups: Groups = Groups(),
    @SerializedName("guid")
    val guid: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("isActive")
    val isActive: Boolean = false,
    @SerializedName("isAllStar")
    val isAllStar: Boolean = false,
    @SerializedName("links")
    val links: List<LinkXX> = listOf(),
    @SerializedName("location")
    val location: String = "",
    @SerializedName("logos")
    val logos: List<Logo> = listOf(),
    @SerializedName("name")
    val name: String = "",


    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("uid")
    val uid: String = ""
)