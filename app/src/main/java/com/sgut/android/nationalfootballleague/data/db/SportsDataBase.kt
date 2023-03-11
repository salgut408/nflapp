package com.sgut.android.nationalfootballleague.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sgut.android.nationalfootballleague.data.db.article.ArticleDao
import com.sgut.android.nationalfootballleague.data.db.article.ArticleDbObject
import com.sgut.android.nationalfootballleague.data.db.team.TeamDbObjFullInfo
import com.sgut.android.nationalfootballleague.data.db.team.TeamsDao

@Database(
    entities = [ArticleDbObject::class, TeamDbObjFullInfo::class],
    version = 6,
    exportSchema = false
)
abstract class SportsDataBase: RoomDatabase() {

    abstract fun  getArticleDao(): ArticleDao

    abstract fun  getTeamDao(): TeamsDao

}