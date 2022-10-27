package com.sgut.android.nationalfootballleague.data.remote.api

import com.sgut.android.nationalfootballleague.NFLTeamsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NflApi {
    @GET("sports/football/nfl/teams")
    suspend fun getAllNflTeams(): Response<NFLTeamsResponse>
}