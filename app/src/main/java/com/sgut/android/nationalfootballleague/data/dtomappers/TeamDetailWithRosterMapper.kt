package com.sgut.android.nationalfootballleague.data.dtomappers

import com.sgut.android.nationalfootballleague.Team3
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailWithRosterModel

class TeamDetailWithRosterMapper: DomainMapper<Team3, TeamDetailWithRosterModel> {
    override fun mapToDomainModel(model: Team3): TeamDetailWithRosterModel {
        return TeamDetailWithRosterModel(
            abbreviation = model.abbreviation,
            alternateColor = model.alternateColor,
            athletes = model.athletes,
            color = model.color,
            displayName = model.displayName,
            franchise = model.franchise,
            groups = model.groups,
            id = model.id,
            isActive = model.isActive,
            links = model.links,
            location = model.location,
            logos = model.logos,
            name = model.name,
            nextEvent = model.nextEvent,
            nickname = model.nickname,
            record = model.record,
            shortDisplayName = model.shortDisplayName,
            slug = model.slug,
            standingSummary = model.standingSummary,
            uid = model.uid
        )
    }
}