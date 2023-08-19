package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class VenueModel(
    val address: AddressModel = AddressModel(),
    val capacity: Int = 0,
    val fullName: String = "",
    val id: String = "",
    val indoor: Boolean = false
)