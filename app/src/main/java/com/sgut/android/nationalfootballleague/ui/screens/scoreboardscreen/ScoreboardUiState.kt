package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel

data class ScoreboardUiState (
    val currentSport: String = "",
    val currentLeague: String = "",
    val currentArticles: ArticlesListModel? = null,
    val scoreboardModelUiState: ScoreboardModel = ScoreboardModel(),
//    val loading: Boolean = true
    )