package com.sgut.android.nationalfootballleague.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ArticleDbObject::class], version = 1, exportSchema = false)
abstract class SportsDataBase: RoomDatabase() {

    abstract fun  getArticleDao(): ArticleDao



}