package com.example.nbaanalyzer.ui.player

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MenuItem
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.TabsAdapter
import com.example.nbaanalyzer.ui.player.tabs.PlayerPreviewFragment
import com.example.nbaanalyzer.ui.player.tabs.PlayerShotCharts
import kotlinx.android.synthetic.main.activity_player.*
import kotlin.properties.Delegates

class PlayerActivity : AppCompatActivity() {

    private lateinit var playerName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_player)

        playerName = intent.getStringExtra("name")!!

        tool_bar_player_activity.title = playerName

        val playerFragmentAdapter = TabsAdapter(supportFragmentManager)
        playerFragmentAdapter.addFragment(PlayerPreviewFragment(), "Player Preview")
        playerFragmentAdapter.addFragment(PlayerShotCharts(), "Shot Charts")

        player_activity_pager.adapter = playerFragmentAdapter
        player_activity_tabs.setupWithViewPager(player_activity_pager)

        setSupportActionBar(tool_bar_player_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        onBackPressed()
        return true

    }
}
