package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class LastPlay(

    @SerializedName("alternativeType")
    val alternativeType: AlternativeType? = AlternativeType(),
    @SerializedName("atBatId")
    val atBatId: String? = "",
    @SerializedName("athletesInvolved")
    val athletesInvolved: List<AthletesInvolved>? = listOf(),
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("probability")
    val probability: Probability? = Probability(),
    @SerializedName("scoreValue")
    val scoreValue: Int? = 0,
    @SerializedName("summaryType")
    val summaryType: String? = "",
    @SerializedName("team")
    val team: TeamX? = TeamX(),
    @SerializedName("text")
    val text: String? = "",
    @SerializedName("type")
    val type: TypeX? = TypeX()
)