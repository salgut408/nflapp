package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.full_athlete.FullAthleteModel

interface AthleteRepository {
    suspend fun getAthlete(sport: String, league: String, athleteId: String): FullAthleteModel

}