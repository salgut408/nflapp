package com.sgut.android.nationalfootballleague.data.service

import com.sgut.android.nationalfootballleague.domain.domainmodels.TeamDomainModel
import kotlinx.coroutines.flow.Flow

interface StorageService {
    val teams: Flow<List<TeamDomainModel>>

    suspend fun getTeam(teamId: String): TeamDomainModel?

    suspend fun saveTeam(team: TeamDomainModel): String
    suspend fun updateTeam(team: TeamDomainModel)
    suspend fun deleteTeam(teamId: String)
    suspend fun deleteAllTeamsForUser(userId: String)
}