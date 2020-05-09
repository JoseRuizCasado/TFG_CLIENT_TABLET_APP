package com.example.nbaanalyzer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.nbaanalyzer.models.Team
import kotlinx.android.synthetic.main.item_teams_list.view.*


/*
* Adapter to show teams in the selection.
*/
class TeamSelectionAdapter(private val teamsList: ArrayList<Team>, private val listener: (Team) -> Unit)
    : RecyclerView.Adapter<TeamSelectionAdapter.ViewHolder?>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var teamName: TextView = v.itemTeamName
        var teamIcon: ImageView = v.itemIcon

        fun bind(team: Team, listener: (Team) -> Unit) = with(itemView) {
            teamName.text = team.teamName
            setOnClickListener { listener(team) }
        }

    }

    override fun getItemCount(): Int {
        return teamsList.size
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_teams_list, viewGroup, false))


    override fun onBindViewHolder(
        viewHolder: ViewHolder,
        i: Int
    ) {
        viewHolder.bind(teamsList[i], listener)
    }
}