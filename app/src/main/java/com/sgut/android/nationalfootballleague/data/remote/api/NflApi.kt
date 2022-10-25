package com.sgut.android.nationalfootballleague.data.remote.api

import com.sgut.android.nationalfootballleague.NFLTeamsResponse
import retrofit2.Response

interface NflApi {
    suspend fun getAllNflTeams(): Response<NFLTeamsResponse>
}