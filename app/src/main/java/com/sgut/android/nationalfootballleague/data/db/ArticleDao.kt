package com.sgut.android.nationalfootballleague.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: ArticleDbObject)

//    @Query("SELECT * FROM article_table")
//     fun getAllSavedArticles(): Flow<List<ArticleDbObject>>

    @Delete
    suspend fun delete(article: ArticleDbObject)



}