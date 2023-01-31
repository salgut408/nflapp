package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.ArticleCategories
import com.sgut.android.nationalfootballleague.ArticleImages
import com.sgut.android.nationalfootballleague.Links
import com.sgut.android.nationalfootballleague.data.db.ArticleDbObject

data class ArticleModel(
    var images: List<ArticleImages> = listOf(),
    var description: String = "",
    var published: String = "",
    var type: String = "",
    var headline: String = "",
    var byline: String = "",
    )

fun ArticleModel.asDatabaseEntity(): ArticleDbObject {
    return ArticleDbObject(
        images = images,
        description = description,
        published = published,
        type = type,
        headline = headline,
        byline = byline,

    )
}
