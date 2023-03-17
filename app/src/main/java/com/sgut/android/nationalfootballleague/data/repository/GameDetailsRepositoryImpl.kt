package com.sgut.android.nationalfootballleague.data.repository

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsModel
import com.sgut.android.nationalfootballleague.domain.repositories.GameDetailsRepository

class GameDetailsRepositoryImpl():GameDetailsRepository {
    override suspend fun getGameDetails(
        sport: String,
        league: String,
        event: String,
    ): GameDetailsModel {
        TODO("Not yet implemented")
    }

}