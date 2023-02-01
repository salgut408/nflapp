package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.ArticleCategories
import com.sgut.android.nationalfootballleague.ArticleImages
import com.sgut.android.nationalfootballleague.Links
import com.sgut.android.nationalfootballleague.data.db.ArticleDbObject

data class ArticleModel(
    val images: List<ArticleImages> = listOf(),
    val description: String = "",
    val published: String = "",
    val type: String = "",
    val headline: String = "",
    val byline: String = "",
    )

