package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.BasicScoreboardModel

data class ScoreboardUiState (
    val currentSport: String = "",
    val currentLeague: String = "",
    val currentArticles: ArticlesListModel? = null,
    val defaultScoreboardModelUiState: BasicScoreboardModel = BasicScoreboardModel(),
//    val loading: Boolean = true
    )