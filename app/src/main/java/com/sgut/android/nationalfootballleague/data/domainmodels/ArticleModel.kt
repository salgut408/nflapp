package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.ArticleCategories
import com.sgut.android.nationalfootballleague.ArticleImages
import com.sgut.android.nationalfootballleague.Links

data class ArticleModel(
    var images: List<ArticleImages> = listOf(),
    var description: String = "",
    var published: String = "",
    var type: String? = null,
    var categories: List<ArticleCategories> = listOf(),
    var headline: String = "",
    var byline: String = "",


    )
