package com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.BasketballCoordinateModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.BasketballPlayModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.NewsModel

data class News(

    @SerializedName("header")
    val header: String? = null,
    @SerializedName("link")
    val link: GameDetailsLink? = GameDetailsLink(),
    @SerializedName("articles")
    val articles: List<Articles> = listOf(), // same as ArticleDomianModel

)

fun News.asDomain(): NewsModel {
    return NewsModel(
        header = header ?: "",
        link = link,
        articles = articles.map { it.asDomain() }
    )
}


data class NetworkPlays(

    @SerializedName("id")
  val id: String? = null,
    @SerializedName("sequenceNumber")
  val sequenceNumber: String? = null,
    @SerializedName("text")
  val text: String? = null,
    @SerializedName("awayScore")
  val awayScore: Int? = null,
    @SerializedName("homeScore")
  val homeScore: Int? = null,
    @SerializedName("period")
  val period: Period? = Period(),
    @SerializedName("clock")
  val clock: Clock? = Clock(),
    @SerializedName("scoringPlay")
  val scoringPlay: Boolean? = null,
    @SerializedName("scoreValue")
  val scoreValue: Int? = null,
    @SerializedName("team")
  val team: Team? = Team(),
    @SerializedName("wallclock")
  val wallclock: String? = null,
    @SerializedName("shootingPlay")
  val shootingPlay: Boolean? = null,
    @SerializedName("coordinate")
  val coordinate: Coordinate? = Coordinate(),

    )

fun NetworkPlays.asDomain(): BasketballPlayModel {
    return BasketballPlayModel(
        id = id ?: "",
        text = text ?: "",
        awayScore = awayScore ?: 0,
        homeScore = homeScore ?: 0,
        period = period?.number ?: 0,
        clock = clock?.displayValue ?: "",
        scoringPlay = scoringPlay ?: false,
        scoreValue = scoreValue ?: 0,
        team = team?.asDomainModel(),
        wallclock = wallclock ?: "",
        coordinate = coordinate?.asDomain()
    )
}


data class Coordinate(

  @SerializedName("x")
  val x: Int? = null,
  @SerializedName("y")
  val y: Int? = null,

  )

fun Coordinate.asDomain(): BasketballCoordinateModel {
    return BasketballCoordinateModel(
        x = x ?: 0,
        y = y ?: 0
    )
}