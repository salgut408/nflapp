package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel


data class Articles(

    @SerializedName("dataSourceIdentifier")
    val dataSourceIdentifier: String? ="",
    @SerializedName("images")
    val images: List<ArticleImages> = listOf(),
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("published")
    val published: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("premium")
    val premium: Boolean? = false,
    @SerializedName("links")
    val links: ArticleLinks? = ArticleLinks(),
    @SerializedName("lastModified")
    val lastModified: String? = "",
    @SerializedName("headline")
    val headline: String? = "",
    @SerializedName("byline")
    val byline: String? = "",

    )

fun Articles.asDomain(): ArticleDomianModel {
    return ArticleDomianModel(
      images = images.map { it.asDomain() },
      description = description,
      published = published ?: "",
      headline = headline ?:"",
      byline = byline ?:"",
        links = links ?: ArticleLinks(),
        dataSourceIdentifier = dataSourceIdentifier?:""
    )
}