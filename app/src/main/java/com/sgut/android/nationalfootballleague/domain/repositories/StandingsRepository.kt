package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.StandingsModel

interface StandingsRepository {
    suspend fun getStandings(
        sport: String,
        league: String,
        type: String
    ): StandingsModel

}