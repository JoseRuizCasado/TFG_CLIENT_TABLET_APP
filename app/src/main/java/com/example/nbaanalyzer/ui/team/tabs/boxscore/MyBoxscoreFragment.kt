package com.example.nbaanalyzer.ui.team.tabs.boxscore

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.Utils
import com.example.nbaanalyzer.api.RestAPI
import com.example.nbaanalyzer.api.responses.PlayerDataResponse
import com.example.nbaanalyzer.api.responses.TeamDataResponse
import com.example.nbaanalyzer.ui.player.PlayerActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MyBoxscoreFragment : Fragment() {

    private val utils = Utils()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_boxscore, container, false)

        getTeamByID(activity!!.getSharedPreferences("MyPref", Context.MODE_PRIVATE).getInt("teamId", -1))

        recyclerView = view.findViewById(R.id.boxscore_recycler_view)

        return view
    }

    private fun getTeamByID ( team_id: Int){
        doAsync {
            // Get Team data  from API
            val api = RestAPI()
            val response = api.getTeamStats(team_id).execute()
            val teamData = if (response.isSuccessful){
                response.body()!!.team
            }else {
                val player = PlayerDataResponse(-1, "", "", 0, "",
                    0, 0, "", 0,
                    0, 0, 0, 0,
                    0, 0, 0,
                    0, 0,
                    0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0f, 0f, 0f,
                    0f, 0f,
                    0f, 0f,
                    0f, 0f, 0f,
                    0f, 0f, 0f,
                    0f, 0f, 0f, 0f,
                    0f, 0f, 0f, 0f, 0f, 0f, 0f,
                    0f, 0f, 0f, 0f, 0f, 0f, 0f)
                TeamDataResponse(-1, "", "", "", "",
                    "", "", "", 0,
                    0, 0, 0, 0,
                    0, 0, 0,
                    0, 0,
                    0, 0,
                    0, 0,
                    0, 0,
                    0, 0, 0,
                    0, 0, 0, 0,
                    0, 0, 0,
                    0, 0, 0, 0,
                    0, 0, 0, 0,
                    0, 0f, 0f,
                    0f, 0f,
                    0f, 0f,
                    0f, 0f,
                    0f, 0f, 0f,
                    0f, 0f, 0f,
                    0f, 0f, 0f,
                    0f, 0f, 0f, 0f, 0f, 0f, 0f,
                    0f, 0f, 0f, 0f, 0f, 0f, arrayListOf(player))
            }

            uiThread { initializeRecyclerView(teamData) }
        }
    }

    private fun initializeRecyclerView(teamData: TeamDataResponse) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TableViewAdapter(teamData.players){
            val intent = Intent(activity, PlayerActivity::class.java)
            intent.putExtra("player_id", it.player_id)
            intent.putExtra("name", "${it.first_name} ${it.last_name}")
            intent.putExtra("position", it.position)
            intent.putExtra("games", it.played_games)
            intent.putExtra("minutes", (it.played_minutes_per_game / 60))
            intent.putExtra("points", it.scored_points_per_game)
            intent.putExtra("offensive_rebounds", it.offensive_rebounds_per_game)
            intent.putExtra("defensive_rebounds", it.defensive_rebounds_per_game)
            intent.putExtra("blocks", it.blocks_per_game)
            intent.putExtra("turnovers", it.turnovers_per_game)
            intent.putExtra("fg%", (it.field_goals_made.toFloat() / it.field_goals_attempts.toFloat()))
            intent.putExtra("3pt%", (it.three_points_field_goals_made.toFloat() / it.three_points_field_goals_attempts.toFloat()))
            intent.putExtra("3pt_rate", it.threeFGARate)
            intent.putExtra("ft%", it.fTARate)
            intent.putExtra("OffRtg", it.offRtg)
            intent.putExtra("DefRtg", it.defRtg)
            intent.putExtra("DR%", it.dR)
            intent.putExtra("TS%", it.tS)
            intent.putExtra("eFG%", it.eFG)
            startActivity(intent)
        }
    }

}
