package com.sgut.android.nationalfootballleague.data.dtomappers

import com.sgut.android.nationalfootballleague.Team
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel

class NflToTeamDomainModelMapper : DomainMapper<Team, TeamDomainModel> {
    override fun mapToDomainModel(model: Team): TeamDomainModel {
        return TeamDomainModel(
            abbreviation = model.abbreviation,
            alternateColor = model.alternateColor,
            color = model.color,
            displayName =model.displayName,
            id = model.id,
            isActive = model.isActive,
            isAllStar = model.isAllStar,
            logos = model.logos,
            name = model.name,
            nickname = model.nickname,
            shortDisplayName = model.shortDisplayName,
            slug = model.slug,
            uid = model.uid

        )
    }



    fun toDomainList(initial: List<Team>): List<TeamDomainModel> {
        return initial.map { mapToDomainModel(it) }
    }





















}