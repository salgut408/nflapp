package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.DefaultScoreboardModel

data class ScoreboardUiState (
    val currentSport: String = "",
    val currentLeague: String = "",
    val currentArticles: ArticlesListModel? = null,
    val defaultScoreboardModelUiState: DefaultScoreboardModel = DefaultScoreboardModel(),
//    val loading: Boolean = true
    )