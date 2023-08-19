package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.racing

data class LinkModel(
    val href: String = "",
    val isExternal: Boolean = false,
    val isPremium: Boolean = false,
    val language: String = "",
    val rel: List<String> = listOf(),
    val shortText: String = "",
    val text: String = ""
)