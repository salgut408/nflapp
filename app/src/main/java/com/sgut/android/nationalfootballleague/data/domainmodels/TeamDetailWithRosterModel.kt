package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*

data class TeamDetailWithRosterModel(

    val id: String = "",
    val uid: String = "",
    val slug: String = "",
    val location: String = "",
    val name: String = "",
    val nickname: String = "",
    val abbreviation: String = "",
    val displayName: String = "",
    val shortDisplayName: String = "",
    val color: String = "",
    val alternateColor: String = "",
    val isActive: Boolean? = null,
    val logos: List<Logos3> = listOf(),
    val record: Record3? = Record3(),
    val athletes: List<Athletes> = listOf(),
    val groups: Groups3? = Groups3(),
    val links: List<Links3> = listOf(),
    var franchise: Franchise3? = Franchise3(),
    val nextEvent: List<NextEvent3> = listOf(),
    val standingSummary: String = "",

    )
