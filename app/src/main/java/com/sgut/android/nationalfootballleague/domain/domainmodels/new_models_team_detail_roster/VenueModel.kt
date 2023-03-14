package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster

import com.sgut.android.nationalfootballleague.Address3
import com.sgut.android.nationalfootballleague.Images3

data class VenueModel(
    val fullName : String  = "",
    val address  : Address3? = Address3(),
    val images3: List<Images3> = listOf()

    )
