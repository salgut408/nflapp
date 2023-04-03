package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteInfoNetwork(
    @SerializedName("athlete")
    val athlete: FullAthleteAthleteNetwork = FullAthleteAthleteNetwork(),
    @SerializedName("league")
    val league: FullAthleteLeagueNetwork = FullAthleteLeagueNetwork(),
    @SerializedName("links")
    val links: List<FullAthleteLinkNetworkXX> = listOf(),
    @SerializedName("playerSwitcher")
    val playerSwitcher: FullAthletePlayerSwitcherNetwork = FullAthletePlayerSwitcherNetwork(),
    @SerializedName("quicklinks")
    val quicklinks: List<FullAthleteQuicklinkNetwork> = listOf(),
    @SerializedName("season")
    val season: FullAthleteSeasonNetworkXX = FullAthleteSeasonNetworkXX(),
    @SerializedName("standings")
    val standings: FullAthleteStandingsNetworkXX = FullAthleteStandingsNetworkXX(),
    @SerializedName("ticketsInfo")
    val ticketsInfo: FullAthleteTicketsInfoNetwork = FullAthleteTicketsInfoNetwork()
)