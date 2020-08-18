package com.example.nbaanalyzer.ui.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.TabsAdapter
import com.example.nbaanalyzer.api.RestAPI
import com.example.nbaanalyzer.api.ShotChartResponse
import com.example.nbaanalyzer.ui.player.tabs.PlayerPreviewFragment
import com.example.nbaanalyzer.ui.player.tabs.PlayerShotCharts
import kotlinx.android.synthetic.main.activity_player.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import kotlin.properties.Delegates

class PlayerActivity : AppCompatActivity() {

    private lateinit var playerName: String
    lateinit var playerPosition: String
    var cluster by Delegates.notNull<Int>()
    var playedGames by Delegates.notNull<Int>()
    var playedMinutes by Delegates.notNull<Float>()
    var scoredPoints by Delegates.notNull<Float>()
    var offensiveRebounds by Delegates.notNull<Float>()
    var defensiveRebounds by Delegates.notNull<Float>()
    var blocks by Delegates.notNull<Float>()
    var turnovers by Delegates.notNull<Float>()
    var fgp by Delegates.notNull<Float>()
    var threepp by Delegates.notNull<Float>()
    var threepr by Delegates.notNull<Float>()
    var ftp by Delegates.notNull<Float>()
    var playerID by Delegates.notNull<Int>()
    var offRtg by Delegates.notNull<Float>()
    var defRtg by Delegates.notNull<Float>()
    var drp by Delegates.notNull<Float>()
    var tsp by Delegates.notNull<Float>()
    var efgp by Delegates.notNull<Float>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_player)

        playerName = intent.getStringExtra("name")!!

        tool_bar_player_activity.title = playerName
        playerID = intent.getIntExtra("player_id", 0)
        playerPosition = intent.getStringExtra("position")!!
        cluster = intent.getIntExtra("cluster", -1)
        playedGames = intent.getIntExtra("games", 0)
        playedMinutes = intent.getFloatExtra("minutes", 0f)
        scoredPoints = intent.getFloatExtra("points", 0f)
        offensiveRebounds = intent.getFloatExtra("offensive_rebounds", 0f)
        defensiveRebounds = intent.getFloatExtra("defensive_rebounds", 0f)
        blocks = intent.getFloatExtra("blocks", 0f)
        turnovers = intent.getFloatExtra("turnovers", 0f)
        fgp = intent.getFloatExtra("fg%", 0f)
        threepp = intent.getFloatExtra("3pt%", 0f)
        threepr = intent.getFloatExtra("3pt_rate", 0f)
        ftp = intent.getFloatExtra("ft%", 0f)
        offRtg = intent.getFloatExtra("OffRtg", 0f)
        defRtg = intent.getFloatExtra("DefRtg", 0f)
        drp = intent.getFloatExtra("DR%", 0f)
        tsp = intent.getFloatExtra("TS%", 0f)
        efgp = intent.getFloatExtra("eFG%", 0f)

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
