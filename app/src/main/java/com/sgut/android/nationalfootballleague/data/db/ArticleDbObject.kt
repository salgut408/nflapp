package com.sgut.android.nationalfootballleague.data.db

import com.sgut.android.nationalfootballleague.ArticleImages

data class ArticleDbObject(
    var images: List<ArticleImages> = listOf(),
    var description: String = "",
    var published: String = "",
    var type: String = "",
    var headline: String = "",
    var byline: String = "",
)