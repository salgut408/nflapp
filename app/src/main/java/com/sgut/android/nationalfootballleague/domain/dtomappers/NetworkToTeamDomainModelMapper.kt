package com.sgut.android.nationalfootballleague.domain.dtomappers

import com.sgut.android.nationalfootballleague.Teams
import com.sgut.android.nationalfootballleague.domain.domainmodels.TeamDomainModel

class NetworkToTeamDomainModelMapper : DomainMapper<Teams, TeamDomainModel> {
    override fun mapToDomainModel(model: Teams): TeamDomainModel {
        return TeamDomainModel(
            abbreviation = model.teamSingle.abbreviation,
            alternateColor = model.teamSingle.alternateColor,
            color = model.teamSingle.color,
            displayName =model.teamSingle.displayName,
            id = model.teamSingle.id,
            logos = model.teamSingle.logos,
            name = model.teamSingle.name,
            nickname = model.teamSingle.nickname,
            shortDisplayName = model.teamSingle.shortDisplayName,
            slug = model.teamSingle.slug,
            uid = model.teamSingle.uid

        )
    }



    fun toDomainList(initial: List<Teams>): List<TeamDomainModel> {
        return initial.map { mapToDomainModel(it) }
    }





















}