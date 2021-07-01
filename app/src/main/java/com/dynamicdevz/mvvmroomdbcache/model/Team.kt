package com.dynamicdevz.mvvmroomdbcache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//1. Create entity, which is actually a table
@Entity(tableName = "Teams")
data class Team(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "teamId")
    val teamID: Int,
    @ColumnInfo(name = "teamCity")
    val teamCity: String,
    @ColumnInfo(name = "teamName")
    val teamName: String,
    @ColumnInfo(name = "players")
    val players: Int
    ){
    constructor(teamCity: String, teamName: String, players: Int): this(0, teamCity, teamName, players)
}
