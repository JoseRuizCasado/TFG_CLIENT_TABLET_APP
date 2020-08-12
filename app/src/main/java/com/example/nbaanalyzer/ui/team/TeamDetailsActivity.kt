package com.example.nbaanalyzer.ui.team

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.TabsAdapter
import com.example.nbaanalyzer.Utils
import com.example.nbaanalyzer.ui.team.tabs.DefendInformFragment
import com.example.nbaanalyzer.ui.team.tabs.boxscore.BoxscoreFragment
import com.example.nbaanalyzer.ui.team.tabs.InformFragment
import com.example.nbaanalyzer.ui.team.tabs.TeamPreviewFragment
import kotlinx.android.synthetic.main.activity_team_details.*
import kotlin.properties.Delegates

class TeamDetailsActivity : AppCompatActivity() {

    private val utils = Utils()
    var selectedTeam by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_team_details)

        selectedTeam = intent.getIntExtra("teamId", 1)

        val teamName = utils.getTeamById(selectedTeam)
        tool_bar_team_detail.title =  teamName
        val fragmentAdapter = TabsAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(TeamPreviewFragment(), "Team Preview")
        fragmentAdapter.addFragment(BoxscoreFragment(), "Boxscore")
        fragmentAdapter.addFragment(InformFragment(), "Inform")
        fragmentAdapter.addFragment(DefendInformFragment(), "Defend Info")

        team_detail_pager.adapter = fragmentAdapter
        team_detail_tabs.setupWithViewPager(team_detail_pager)

        setSupportActionBar(tool_bar_team_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val sharedPreferencesEditor = applicationContext?.getSharedPreferences("MyPref", Context.MODE_PRIVATE)?.edit()
        sharedPreferencesEditor?.putInt("menuOption", 1)
        sharedPreferencesEditor?.apply()
    }


}
