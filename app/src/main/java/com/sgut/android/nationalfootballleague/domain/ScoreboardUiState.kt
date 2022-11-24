package com.sgut.android.nationalfootballleague.domain

import com.sgut.android.nationalfootballleague.EventsScoreboard
import com.sgut.android.nationalfootballleague.data.domainmodels.ScoreboardResponseEventModel

data class ScoreboardUiState (
    var scoreboardUiStateEvents  : ScoreboardResponseEventModel = ScoreboardResponseEventModel()

)