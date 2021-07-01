package com.dynamicdevz.mvvmroomdbcache.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dynamicdevz.mvvmroomdbcache.model.Team

//3. Create the Database as an abstract class
@Database(version = 1, entities = [Team::class])
abstract class FootballDatabase: RoomDatabase() {
    abstract fun getTeamDao(): TeamDAO
}