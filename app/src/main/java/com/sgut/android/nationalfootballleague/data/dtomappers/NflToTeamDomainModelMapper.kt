package com.sgut.android.nationalfootballleague.data.dtomappers

import com.sgut.android.nationalfootballleague.NFLTeamsResponse
import com.sgut.android.nationalfootballleague.Teams
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel

class NflToTeamDomainModelMapper : DomainMapper<NFLTeamsResponse, TeamDomainModel> {
    override fun mapToDomainModel(model: Teams): TeamDomainModel {
        return TeamDomainModel(
            abbreviation = model.team?.abbreviation,
            alternateColor = model.team?.alternateColor,
            color = model.team?.color,
            displayName =model.team?.displayName,
            id = model.team?.id,
            isActive = model.team?.isActive,
            isAllStar =model.team?.isAllStar,
            logos = model.team?.logos,
            name = model.team?.name,
            nickname = model.team?.nickname,
            shortDisplayName = model.team?.shortDisplayName,
            slug = model.team?.slug,
            uid = model.team?.uid,

        )
    }
    fun toDomainList(initial: NFLTeamsResponse): List<TeamDomainModel> {
        return initial.sports[0].leagues[0].teams.map{mapToDomainModel(it)}
    }
}