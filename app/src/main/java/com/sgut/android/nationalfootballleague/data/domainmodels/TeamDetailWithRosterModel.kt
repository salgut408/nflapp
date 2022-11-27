package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*

data class TeamDetailWithRosterModel(

    var id: String = "",
    var uid: String = "",
    var slug: String = "",
    var location: String = "",
    var name: String = "",
    var nickname: String = "",
    var abbreviation: String = "",
    var displayName: String = "",
    var shortDisplayName: String = "",
    var color: String = "",
    var alternateColor: String = "",
    var isActive: Boolean? = null,
    var logos: List<Logos3> = listOf(),
    var record: Record3? = Record3(),
    var athletes: List<Athletes> = listOf(),
    var groups: Groups3? = Groups3(),
    var links: List<Links3> = listOf(),
    var franchise: Franchise3? = Franchise3(),
    var nextEvent: List<NextEvent3> = listOf(),
    var standingSummary: String = "",

    )
