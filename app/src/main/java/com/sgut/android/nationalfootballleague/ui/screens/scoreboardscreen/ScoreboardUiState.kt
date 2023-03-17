package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel

data class ScoreboardUiState (
    val currentSport: String = "",
    val currentLeague: String = "",
    val currentArticles: List<ArticleDomianModel> = listOf(),
    val scoreboardModelUiState: ScoreboardModel = ScoreboardModel()
    )