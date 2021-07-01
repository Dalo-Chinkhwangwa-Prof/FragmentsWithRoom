package com.dynamicdevz.mvvmroomdbcache

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dynamicdevz.mvvmroomdbcache.databinding.TeamItemLayoutBinding
import com.dynamicdevz.mvvmroomdbcache.model.Team

class FootballAdapter(): RecyclerView.Adapter<FootballAdapter.TeamViewHolder>(){
    inner class TeamViewHolder(val binding: TeamItemLayoutBinding): RecyclerView.ViewHolder(binding.root)
    var list: List<Team> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = TeamItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = list[position]
        holder.binding.apply {
            textView.text = team.teamName
            textView2.text = team.teamCity
        }
    }

    override fun getItemCount(): Int = list.size


}