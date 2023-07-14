package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Video(

  @SerializedName("source")
  val source: String = "",
  @SerializedName("id")
  val id: Int? = null,
  @SerializedName("guid")
  val guid: String? = null,
  @SerializedName("headline")
  val headline: String? = null,
  @SerializedName("caption")
  val caption: String? = null,
  @SerializedName("description")
  val description: String? = null,


  @SerializedName("duration")
  val duration: Int? = null,
  @SerializedName("posterImages")
  val posterImages: PosterImages? = PosterImages(),
  @SerializedName("images")
  val images: List<GameDetailsImages> = listOf(),
  @SerializedName("thumbnail")
  val thumbnail: String? = null,
  @SerializedName("links")
  val links: GameDetailsLinks? = GameDetailsLinks(),
  @SerializedName("title")
  val title: String? = null,

  )