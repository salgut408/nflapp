package com.sgut.android.nationalfootballleague.data.domainmodels

import com.sgut.android.nationalfootballleague.Logos

data class TeamDomainModel(
    var id:               String = "",
    var uid:              String = "",
    var slug:             String = "",
    var abbreviation:     String = "",
    var displayName:      String = "",
    var shortDisplayName: String = "",
    var name:             String = "",
    var nickname:         String = "",
    var location:         String = "",
    var color:            String = "",
    var alternateColor:   String = "",
    var logos:            ArrayList<Logos>? = arrayListOf(),
)