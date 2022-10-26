package com.sgut.android.nationalfootballleague.data.dtomappers

import com.sgut.android.nationalfootballleague.NFLTeamsResponse
import com.sgut.android.nationalfootballleague.Teams
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel

class NflToTeamDomainModelMapper : DomainMapper<NFLTeamsResponse, TeamDomainModel> {
    override fun mapToDomainModel(model: NFLTeamsResponse): TeamDomainModel {
        return TeamDomainModel(
            abbreviation = model.sports[0].leagues[0].teams[0].team?.abbreviation,
            alternateColor = model.sports[0].leagues[0].teams[0].team?.alternateColor,
            color = model.sports[0].leagues[0].teams[0].team?.color,
            displayName =model.sports[0].leagues[0].teams[0].team?.displayName,
            id = model.sports[0].leagues[0].teams[0].team?.id,
            isActive = model.sports[0].leagues[0].teams[0].team?.isActive,
            isAllStar = model.sports[0].leagues[0].teams[0].team?.isAllStar,
            logos = model.sports[0].leagues[0].teams[0].team?.logos,
            name = model.sports[0].leagues[0].teams[0].team?.name,
            nickname = model.sports[0].leagues[0].teams[0].team?.nickname,
            shortDisplayName = model.sports[0].leagues[0].teams[0].team?.shortDisplayName,
            slug = model.sports[0].leagues[0].teams[0].team?.slug,
            uid = model.sports[0].leagues[0].teams[0].team?.uid

        )
    }

    fun toTeamsDomain(model: Teams) : TeamDomainModel {
        return TeamDomainModel(
            abbreviation = model.team?.abbreviation,
            alternateColor = model.team?.alternateColor,
            color = model.team?.color,
            displayName = model.team?.displayName,
            id = model.team?.id,
            isActive = model.team?.isActive,
            isAllStar = model.team?.isAllStar,
            logos = model.team?.logos,
            name = model.team?.name,
            nickname = model.team?.nickname,
            shortDisplayName = model.team?.shortDisplayName,
            slug = model.team?.slug,
            uid = model.team?.uid
        )
    }

    fun toDomainList(initial: NFLTeamsResponse): List<TeamDomainModel> {

        return initial.sports[0].leagues[0].teams.map { toTeamsDomain(it) }

    }





















}