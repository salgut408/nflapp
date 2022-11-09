package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*

data class TeamDetailWithRosterModel(

    var id: String? = null,
    var uid: String? = null,
    var slug: String? = null,
    var location: String? = null,
    var name: String? = null,
    var nickname: String? = null,
    var abbreviation: String? = null,
    var displayName: String? = null,
    var shortDisplayName: String? = null,
    var color: String? = null,
    var alternateColor: String? = null,
    var isActive: Boolean? = null,
    var logos: List<Logos3> = listOf(),
    var record: Record3? = Record3(),
    var athletes: List<Athletes> = listOf(),
    var groups: Groups3? = Groups3(),
    var links: List<Links3> = listOf(),
    var franchise: Franchise3? = Franchise3(),
    var nextEvent: List<NextEvent3> = listOf(),
    var standingSummary: String? = null,

    )
