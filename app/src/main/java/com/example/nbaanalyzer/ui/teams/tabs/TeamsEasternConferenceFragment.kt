package com.example.nbaanalyzer.ui.teams.tabs

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.TeamSelectionAdapter
import com.example.nbaanalyzer.Utils
import com.example.nbaanalyzer.ui.team.TeamDetailsActivity

/**
 * [Fragment] to show eastern teams, if you click in an item, item detail view will be opened.
 */
class TeamsEasternConferenceFragment : Fragment() {

    private lateinit var recycler: RecyclerView
    private lateinit var teamSelectionAdapter: TeamSelectionAdapter
    private var utils: Utils = Utils()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_teams_list, container, false)
        recycler = view.findViewById(R.id.teams_list)

        teamSelectionAdapter = TeamSelectionAdapter(utils.easternTeams){
            Toast.makeText(activity, "${it.teamName} pressed, with id: ${it.teamId}", Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, TeamDetailsActivity::class.java)
            intent.putExtra("teamId", it.teamId)
            startActivity(intent)
        }
        recycler.adapter = teamSelectionAdapter
        return view
    }
}
