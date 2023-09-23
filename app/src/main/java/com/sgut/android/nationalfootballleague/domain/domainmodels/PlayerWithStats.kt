package com.sgut.android.nationalfootballleague.domain.domainmodels

import com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats.Stats

data class PlayerWithStats(val name: String = "Sal", val stats: List<Stats>)

