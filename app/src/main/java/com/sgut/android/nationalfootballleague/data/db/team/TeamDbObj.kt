package com.sgut.android.nationalfootballleague.data.db.team

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "teams_table")
data class TeamDbObj(
    val id: String = "",
    @PrimaryKey(autoGenerate = false)
    val uid: String = "",
    val abbreviation: String = "",
    val displayName: String = "",
    val shortDisplayName: String = "",
    val name: String = "",
    val nickname: String = "",
    val color: String = "",
    val alternateColor: String = "",
    var isFavorite: Boolean = false,
    val logo: String = "",
)
