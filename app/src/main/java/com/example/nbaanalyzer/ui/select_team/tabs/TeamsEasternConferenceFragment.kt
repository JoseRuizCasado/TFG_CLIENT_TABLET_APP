package com.example.nbaanalyzer.ui.select_team.tabs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.nbaanalyzer.MainActivity
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.TeamSelectionAdapter
import com.example.nbaanalyzer.Utils



/**
 * [Fragment] to show eastern conference Teams.
 */
class TeamsEasternConferenceFragment : Fragment() {

    private lateinit var recycler: RecyclerView
    private lateinit var teamSelectionAdapter: TeamSelectionAdapter
    private var utils:Utils = Utils()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_select_your_team_eastern, container, false)
        recycler = view.findViewById(R.id.select_your_tem_easter_recycler)

        teamSelectionAdapter = TeamSelectionAdapter(utils.easternTeams){
            Toast.makeText(activity, "${it.teamName} pressed, with id: ${it.teamId}", Toast.LENGTH_SHORT).show()
            // Logic to save selected team id in preferences to load it
            val sharedPreferencesEditor = activity?.applicationContext?.getSharedPreferences("MyPref", Context.MODE_PRIVATE)?.edit()
            sharedPreferencesEditor?.putInt("teamId", it.teamId)
            sharedPreferencesEditor?.apply()


            // Load main activity
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        recycler.adapter = teamSelectionAdapter
        return view
    }

}
