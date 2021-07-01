package com.dynamicdevz.mvvmroomdbcache.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.dynamicdevz.mvvmroomdbcache.R
import com.dynamicdevz.mvvmroomdbcache.model.Team
import com.dynamicdevz.mvvmroomdbcache.model.db.FootballDatabase
import com.dynamicdevz.mvvmroomdbcache.view.fragment.DisplayTeamsFragment
import com.dynamicdevz.mvvmroomdbcache.view.fragment.InsertTeamFragment

class MainActivity : AppCompatActivity(), InsertTeamFragment.InsertDelegate {

    private lateinit var footballDatabase: FootballDatabase
    private lateinit var displayTeamsFragment: DisplayTeamsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayTeamsFragment = supportFragmentManager.findFragmentById(R.id.display_fragment) as DisplayTeamsFragment

        footballDatabase = Room.databaseBuilder(
            this,
            FootballDatabase::class.java,
            "football.db"
        ).allowMainThreadQueries()
            .build()

        readFromDB()
//        footballDatabase.getTeamDao()
//            .insertNewTeam(Team("Barcelona", "Barcelona", 30))
//        footballDatabase.getTeamDao()
//            .insertNewTeam(Team("Madrid", "Real Madrid", 30))
//        footballDatabase.getTeamDao()
//            .insertNewTeam(Team("Manchester", "Manchester United", 30))


    }

    override fun insertNewTeam(team: Team) {
        footballDatabase.getTeamDao().insertNewTeam(team)
        readFromDB()
    }

    private fun readFromDB() {
        displayTeamsFragment.updateTeams(footballDatabase.getTeamDao().getAllTeams())
    }
}

/* SQLite Drawbacks........
* - Boiler plate code
* - Implementation takes patience
* - Writing C queries
* - Readability
* - No compile time sql checks
* */