package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import com.sgut.android.nationalfootballleague.domain.domainmodels.ArticleModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.ScoreboardResponseEventModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel

data class ScoreboardUiState (
    val scoreboardUiStateEvents  : ScoreboardResponseEventModel = ScoreboardResponseEventModel(),
    val currentSport: String = "",
    val currentLeague: String = "",
    val currentArticles: List<ArticleModel> = listOf(),
    val scoreboardModelUiState: ScoreboardModel = ScoreboardModel()
    )