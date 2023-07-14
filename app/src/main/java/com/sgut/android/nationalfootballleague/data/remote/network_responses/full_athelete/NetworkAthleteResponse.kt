package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class NetworkAthleteResponse(
    @SerializedName("athlete")
    val athlete: Athlete = Athlete(),
    @SerializedName("league")
    val league: League = League(),
    @SerializedName("playerSwitcher")
    val playerSwitcher: PlayerSwitcher = PlayerSwitcher(),
    @SerializedName("quicklinks")
    val quicklinks: List<Quicklink> = listOf(),
    @SerializedName("season")
    val season: SeasonXX = SeasonXX(),
    @SerializedName("standings")
    val standings: StandingsXX = StandingsXX(),
    @SerializedName("ticketsInfo")
    val ticketsInfo: TicketsInfo = TicketsInfo()
)