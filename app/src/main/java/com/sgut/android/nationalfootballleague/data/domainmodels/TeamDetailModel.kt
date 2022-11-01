package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*

data class TeamDetailModel(

    var id: String? = null,
    var uid: String? = null,
    var slug: String? = null,
    var location: String? = null,
    var name: String? = null,
    var abbreviation: String? = null,
    var displayName: String? = null,
    var shortDisplayName: String? = null,
    var color: String? = null,
    var alternateColor: String? = null,
    var isActive: Boolean? = null,
    var logos2: List<Logos2> = listOf(),
    var record: Record? = Record(),
    var groups: Groups? = Groups(),
    var links2: List<Links2> = listOf(),
    var franchise: Franchise? = Franchise(),
    var nextEvent: List<NextEvent> = listOf(),
    var standingSummary: String? = null,
)