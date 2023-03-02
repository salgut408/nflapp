package com.sgut.android.nationalfootballleague.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sgut.android.nationalfootballleague.data.db.article.ArticleDao
import com.sgut.android.nationalfootballleague.data.db.article.ArticleDbObject
import com.sgut.android.nationalfootballleague.data.db.team.TeamDao
import com.sgut.android.nationalfootballleague.data.db.team.TeamDbObj

@Database(entities = [ArticleDbObject::class, TeamDbObj::class], version = 2, exportSchema = false)
abstract class SportsDataBase: RoomDatabase() {

    abstract fun  getArticleDao(): ArticleDao

    abstract fun  getTeamDao(): TeamDao

}