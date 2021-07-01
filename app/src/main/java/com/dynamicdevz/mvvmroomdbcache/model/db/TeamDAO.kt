package com.dynamicdevz.mvvmroomdbcache.model.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dynamicdevz.mvvmroomdbcache.model.Team

//2. Create Dao(Data Access Object) - For CRUD operations
@Dao
interface TeamDAO {

    @Insert
    fun insertNewTeam(vararg team: Team)

    @Query("SELECT * FROM teams")
    fun getAllTeams(): List<Team>

    @Delete
    fun deleteTeam(team: Team)
//    public void insertNewTeam(Team.. team)

}