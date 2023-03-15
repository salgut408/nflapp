package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import com.sgut.android.nationalfootballleague.domain.domainmodels.ArticleModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.ScoreboardResponseEventModel

data class ScoreboardUiState (
    val scoreboardUiStateEvents  : ScoreboardResponseEventModel = ScoreboardResponseEventModel(),
    val currentSport: String = "",
    val currentLeague: String = "",
    val currentArticles: List<ArticleModel> = listOf(),
    )