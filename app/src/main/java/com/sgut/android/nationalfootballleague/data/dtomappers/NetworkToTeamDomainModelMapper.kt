package com.sgut.android.nationalfootballleague.data.dtomappers

import com.sgut.android.nationalfootballleague.Teams
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel

class NetworkToTeamDomainModelMapper : DomainMapper<Teams, TeamDomainModel> {
    override fun mapToDomainModel(model: Teams): TeamDomainModel {
        return TeamDomainModel(
            abbreviation = model.teamsz.abbreviation,
            alternateColor = model.teamsz.alternateColor,
            color = model.teamsz.color,
            displayName =model.teamsz.displayName,
            id = model.teamsz.id,
            logos = model.teamsz.logos,
            name = model.teamsz.name,
            nickname = model.teamsz.nickname,
            shortDisplayName = model.teamsz.shortDisplayName,
            slug = model.teamsz.slug,
            uid = model.teamsz.uid

        )
    }



    fun toDomainList(initial: List<Teams>): List<TeamDomainModel> {
        return initial.map { mapToDomainModel(it) }
    }





















}