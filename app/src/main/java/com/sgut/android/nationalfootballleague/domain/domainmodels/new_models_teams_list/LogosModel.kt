package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list


 interface DefaultLogo{
     val href: String
 }
data class LogosModel(
   override val href: String = "",
    val alt: String = "",
    val rel: List<String> = listOf(),
    val width: Int = 0,
    val height: Int = 0,
): DefaultLogo
