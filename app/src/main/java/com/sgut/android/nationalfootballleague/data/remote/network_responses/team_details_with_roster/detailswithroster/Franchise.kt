package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailsFranchiseModel


data class Franchise3(

    @SerializedName("\$ref") var ref: String? = null,
    @SerializedName("id") val id: String? = null,
    @SerializedName("uid") val uid: String? = null,
    @SerializedName("slug") val slug: String? = null,
    @SerializedName("location") val location: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("nickname") val nickname: String? = null,
    @SerializedName("abbreviation") val abbreviation: String? = null,
    @SerializedName("displayName") val displayName: String? = null,
    @SerializedName("shortDisplayName") val shortDisplayName: String? = null,
    @SerializedName("color") val color: String? = null,
    @SerializedName("isActive") val isActive: Boolean? = null,
    @SerializedName("venue") val venue: Venue3? = Venue3(),
)

 fun Franchise3.asDomain() : FullTeamDetailsFranchiseModel {
     return FullTeamDetailsFranchiseModel(
         id = id ?: "",
         uid = uid ?: "",
         slug = slug ?: "",
         location = location ?: "",
         name = name ?: "",
         abbreviation = abbreviation ?: "",
         displayName = displayName ?: "",
         shortDisplayName = shortDisplayName ?: "",
         color = color ?: "",
         isActive = isActive ?: true,
         venue = venue?.asDomain()


     )
 }