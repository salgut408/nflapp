package com.sgut.android.nationalfootballleague.domain.domainmodels

import com.sgut.android.nationalfootballleague.Franchise3
import com.sgut.android.nationalfootballleague.Logos3
import com.sgut.android.nationalfootballleague.NextEvent3
import com.sgut.android.nationalfootballleague.Record3

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
    val logos: List<Logos3>? = listOf(),
    val record: Record3? = Record3(),
    val franchise: Franchise3? = Franchise3(),
    val nextEvent: List<NextEvent3>? = listOf(),
    val standingSummary: String = "",
)