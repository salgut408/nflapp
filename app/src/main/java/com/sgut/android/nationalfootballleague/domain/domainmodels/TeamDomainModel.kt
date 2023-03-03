package com.sgut.android.nationalfootballleague.domain.domainmodels

import com.google.firebase.firestore.DocumentId
import com.sgut.android.nationalfootballleague.Logos
import com.sgut.android.nationalfootballleague.data.db.team.TeamDbObj

data class TeamDomainModel(
    @DocumentId
    val id: String = "",
    val uid: String = "",
    val slug: String = "",
    val abbreviation: String = "",
    val displayName: String = "",
    val shortDisplayName: String = "",
    val name: String = "",
    val nickname: String = "",
    val location: String = "",
    val color: String = "",
    val alternateColor: String = "",
    val logos: List<Logos>? = listOf(),
): TeamsDomInterface


fun TeamDomainModel.asDbModel(): TeamDbObj {
    return TeamDbObj(
        id = id,
        uid = uid,
        abbreviation = abbreviation,
        displayName = displayName,
        shortDisplayName = shortDisplayName,
        name = name,
        nickname = nickname,
        color = color,
        alternateColor = alternateColor,
        isFavorite = false,
        logo = logos?.get(0)?.href.toString()
    )
}