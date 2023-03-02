package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import com.sgut.android.nationalfootballleague.data.domainmodels.ArticleModel
import com.sgut.android.nationalfootballleague.data.domainmodels.ScoreboardResponseEventModel

data class ScoreboardUiState (
    var scoreboardUiStateEvents  : ScoreboardResponseEventModel = ScoreboardResponseEventModel(),
    var currentSport: String = "",
    var currentLeague: String = "",
    var currentArticles: List<ArticleModel> = listOf(),

)