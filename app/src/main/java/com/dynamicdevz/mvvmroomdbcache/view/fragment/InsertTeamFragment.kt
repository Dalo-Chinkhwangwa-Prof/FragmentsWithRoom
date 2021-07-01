package com.dynamicdevz.mvvmroomdbcache.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dynamicdevz.mvvmroomdbcache.databinding.NewTeamFragmentLayoutBinding
import com.dynamicdevz.mvvmroomdbcache.model.Team
import com.dynamicdevz.mvvmroomdbcache.view.activity.MainActivity

class InsertTeamFragment: Fragment() {



    private lateinit var binding: NewTeamFragmentLayoutBinding
    private lateinit var insertDelegate: InsertDelegate

    interface InsertDelegate{
        fun insertNewTeam(team: Team)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        insertDelegate = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewTeamFragmentLayoutBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitButton.setOnClickListener {

            val teamCity = binding.teamCityEt.text.toString().trim()
            val teamName = binding.teamNameEt.text.toString().trim()
            val players = binding.playerCountEt.text.toString().toInt()

            val team = Team(teamCity, teamName, players)
            insertDelegate.insertNewTeam(team)

        }


    }


}