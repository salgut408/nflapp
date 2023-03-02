package com.sgut.android.nationalfootballleague.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.ArticleImages
import org.checkerframework.checker.signature.qual.IdentifierOrPrimitiveType

@Entity(tableName = "article_table")
data class ArticleDbObject(
    val story: String = "",
    @PrimaryKey(autoGenerate = false)
    val headline     : String               = "",
    var source       : String               = "",
    var description  : String               = "",
    var lastModified : String               = "",
    var published    : String              = "",

)