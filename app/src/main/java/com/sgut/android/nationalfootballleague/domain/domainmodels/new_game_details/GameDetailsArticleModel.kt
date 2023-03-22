package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.GameDetailsImages

data class GameDetailsArticleModel(
    val description: String = "",
    val source: String = "",
    val id: Int = 0,
    val headline: String = "",
    val images: List<GameDetailsImages> = listOf(),
    val published: String = "",
    val lastModified: String = "",
    val story: String = "",
)
