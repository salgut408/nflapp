package com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.*


data class Situation(

    @SerializedName("lastPlay")
    val lastPlay: LastPlay? = LastPlay(),
    @SerializedName("balls")
    val balls: Int? = null,
    @SerializedName("strikes")
    val strikes: Int? = null,
    @SerializedName("outs")
    val outs: Int? = null,
    @SerializedName("pitcher")
    val pitcher: Pitcher? = Pitcher(),
    @SerializedName("batter")
    val batter: Batter? = Batter(),
    @SerializedName("dueUp")
    val dueUp: List<DueUpItem> = listOf(),
    @SerializedName("onSecond")
    val onSecond: OnSecond? = OnSecond()
)

data class OnSecond(
    val playerId: Int? = null
)

fun OnSecond.asDomain(): OnSecondModel {
    return OnSecondModel(
        playerId = playerId
    )
}

data class DueUpItem(
    @SerializedName("playerId")
    val playerId: String = "",
    @SerializedName("batOrder")
    val batOrder: String = "",

)

fun DueUpItem.asDomain(): DueUpItemModel {
    return DueUpItemModel(
        playerId = playerId,
        batOrder = batOrder
    )
}



fun Situation.asDomain(): SituationModel {
    return SituationModel(
        lastPlay = lastPlay?.asDomain() ,
        balls = balls ?: 0,
        strikes = strikes ?: 0,
        outs = outs ?: 0,
        pitcher = pitcher?.asDomain(),
        batter = batter?.asDomain(),
        dueUp = dueUp.map { it.asDomain() },
        onSecond = onSecond?.asDomain()
    )
}

data class LastPlay(

    @SerializedName("id")
    val id: String? = null,

    )
fun LastPlay.asDomain(): LastPlayModel {
    return LastPlayModel(
        id = id ?: ""
    )
}

data class Pitcher(
    @SerializedName("playerId")
    val playerId: Int? = null,
    )
fun Pitcher.asDomain(): PitcherModel {
    return PitcherModel(
        playerId = playerId ?: 0
    )
}

data class Batter(
    @SerializedName("playerId")
    val playerId: Int? = null,

    )
fun Batter.asDomain(): BatterModel {
    return BatterModel(
        playerId = playerId ?: 0
    )
}
