package com.dynamicdevz.mvvmroomdbcache.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dynamicdevz.mvvmroomdbcache.FootballAdapter
import com.dynamicdevz.mvvmroomdbcache.databinding.DisplayTeamsFragmentBinding
import com.dynamicdevz.mvvmroomdbcache.model.Team

class DisplayTeamsFragment: Fragment() {

    private lateinit var binding: DisplayTeamsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DisplayTeamsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    private val adapter = FootballAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.footballRecyclerview.adapter = adapter
    }

    fun updateTeams(list: List<Team>){
        adapter.list = list
    }


}