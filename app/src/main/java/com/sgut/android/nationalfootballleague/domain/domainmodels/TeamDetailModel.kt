package com.sgut.android.nationalfootballleague.domain.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*

data class TeamDetailModel(
    val id: String = "",
    val uid: String = "",
    val slug: String = "",
    val location: String = "",
    val name: String = "",
    val abbreviation: String = "",
    val displayName: String = "",
    val shortDisplayName: String = "",
    val color: String = "",
    val alternateColor: String = "",
    val isActive: Boolean? = null,
    val logos2: List<Logos3>? = listOf(),
    val record: Record3? = Record3(),
    val groups: Groups3? = Groups3(),
    val links2: List<Links3>? = listOf(),
    val franchise: Franchise3? = Franchise3(),
    val nextEvent: List<NextEvent3>? = listOf(),
    val standingSummary: String = "",
)