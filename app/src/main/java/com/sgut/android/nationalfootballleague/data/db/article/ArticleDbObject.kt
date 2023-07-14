package com.sgut.android.nationalfootballleague.data.db.article

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_table")
data class ArticleDbObject(
    val story: String = "",
    @PrimaryKey(autoGenerate = false)
    val headline: String = "",
    var source: String = "",
    var description: String = "",
    var lastModified: String = "",
    var published: String = "",
)