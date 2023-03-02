package com.sgut.android.nationalfootballleague.data.db.team

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(team: TeamDbObj): Long

    @Delete
    suspend fun delete(team: TeamDbObj)

//    //this returns unsorted list from db
//    @Query("SELECT * FROM item_table")
//    fun getAllInfoFromDb(): Flow<List<ItemDomainModel>>


}