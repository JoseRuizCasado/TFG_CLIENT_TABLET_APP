package com.example.nbaanalyzer.ui.select_team

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.TabsAdapter
import com.example.nbaanalyzer.ui.select_team.tabs.TeamsEasternConferenceFragment
import com.example.nbaanalyzer.ui.select_team.tabs.TeamsWesternConferenceFragment
import kotlinx.android.synthetic.main.activity_select_your_team.*


class SelectYourTeamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_select_your_team)

        val fragmentAdapter = TabsAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(TeamsEasternConferenceFragment(), getString(R.string.tab_eastern))
        fragmentAdapter.addFragment(TeamsWesternConferenceFragment(), getString(R.string.tab_western))
        select_team_view_pager.adapter = fragmentAdapter
        select_your_team_tabs.setupWithViewPager(select_team_view_pager)

    }

}
