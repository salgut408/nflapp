package com.sgut.android.nationalfootballleague.data.dtomappers

import com.sgut.android.nationalfootballleague.Team2
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailModel

class TeamDetailNetworkToModelMapper: DomainMapper <Team2, TeamDetailModel> {
    override fun mapToDomainModel(model: Team2): TeamDetailModel {
        return TeamDetailModel(
            abbreviation = model.abbreviation,
            alternateColor = model.alternateColor,
            color = model.color,
            displayName = model.displayName,
            franchise = model.franchise,
            groups = model.groups,
            id = model.id,
            isActive = model.isActive,
            links2 = model.links2,
            location = model.location,
            logos2 = model.logos2,
            name = model.name,
            nextEvent = model.nextEvent,
            record = model.record,
            shortDisplayName = model.shortDisplayName,
            slug = model.slug,
            standingSummary = model.standingSummary,
            uid = model.uid
        )
    }
}