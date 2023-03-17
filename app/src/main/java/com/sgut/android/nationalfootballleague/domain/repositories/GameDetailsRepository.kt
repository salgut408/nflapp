package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsModel

interface GameDetailsRepository {
    suspend fun getGameDetails(
        sport: String,
        league: String,
        event: String
    ): GameDetailsModel

//    suspend fun getGameDetailsBoxScore(
//        sport: String,
//        league: String,
//        event: String
//    ): GameDetailsBoxScore
//
//    suspend fun getGameDetailsPlays(
//        sport: String,
//        league: String,
//        event: String
//    ): List<Plays>



}