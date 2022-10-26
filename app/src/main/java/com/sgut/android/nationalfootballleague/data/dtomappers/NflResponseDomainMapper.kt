package com.sgut.android.nationalfootballleague.data.dtomappers

import com.sgut.android.nationalfootballleague.NFLTeamsResponse
import com.sgut.android.nationalfootballleague.Teams
import com.sgut.android.nationalfootballleague.data.domainmodels.NflResponseDomainModel

class NflResponseDomainMapper: DomainMapper<NFLTeamsResponse, NflResponseDomainModel> {
    override fun mapToDomainModel(model: NFLTeamsResponse): NflResponseDomainModel {
        return NflResponseDomainModel(
            sports = model.sports
        )
    }
}