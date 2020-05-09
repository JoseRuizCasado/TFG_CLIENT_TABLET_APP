package com.example.nbaanalyzer.ui.team

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.TabsAdapter
import com.example.nbaanalyzer.Utils
import com.example.nbaanalyzer.ui.team.tabs.BoxscoreFragment
import com.example.nbaanalyzer.ui.team.tabs.TeamPreviewFragment
import kotlinx.android.synthetic.main.activity_team_details.*

class TeamDetails : AppCompatActivity() {

    private val utils = Utils()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_team_details)

        val teamName = utils.getTeamById(intent.getIntExtra("teamId", 1))
        tool_bar_team_detail.title =  teamName
        val fragmentAdapter = TabsAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(TeamPreviewFragment(), "Team Preview")
        fragmentAdapter.addFragment(BoxscoreFragment(), "Boxscore")

        team_detail_pager.adapter = fragmentAdapter
        team_detail_tabs.setupWithViewPager(team_detail_pager)

        setSupportActionBar(tool_bar_team_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
