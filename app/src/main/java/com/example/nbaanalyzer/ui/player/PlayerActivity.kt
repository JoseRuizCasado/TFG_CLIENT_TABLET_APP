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
import java.text.FieldPosition
import kotlin.properties.Delegates

class PlayerActivity : AppCompatActivity() {

    private lateinit var playerName: String
    lateinit var playerPosition: String
    var playedGames by Delegates.notNull<Int>()
    var playedMinutes by Delegates.notNull<Double>()
    var scoredPoints by Delegates.notNull<Double>()
    var offensiveRebounds by Delegates.notNull<Double>()
    var defensiveRebounds by Delegates.notNull<Double>()
    var blocks by Delegates.notNull<Double>()
    var turnovers by Delegates.notNull<Double>()
    var fgpp by Delegates.notNull<Double>()
    var threepp by Delegates.notNull<Double>()
    var threepr by Delegates.notNull<Double>()
    var ftp by Delegates.notNull<Double>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_player)

        playerName = intent.getStringExtra("name")!!

        tool_bar_player_activity.title = playerName
        playerPosition = intent.getStringExtra("position")!!
        playedGames = intent.getIntExtra("games", 0)
        playedMinutes = intent.getDoubleExtra("minutes", 0.0)
        scoredPoints = intent.getDoubleExtra("points", 0.0)
        offensiveRebounds = intent.getDoubleExtra("offensive_rebounds", 0.0)
        defensiveRebounds = intent.getDoubleExtra("defensive_rebounds", 0.0)
        blocks = intent.getDoubleExtra("blocks", 0.0)
        turnovers = intent.getDoubleExtra("turnovers", 0.0)
        fgpp = intent.getDoubleExtra("fg%", 0.0)
        threepp = intent.getDoubleExtra("3pt%", 0.0)
        threepr = intent.getDoubleExtra("3pt_rate", 0.0)
        ftp = intent.getDoubleExtra("ft%", 0.0)

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
