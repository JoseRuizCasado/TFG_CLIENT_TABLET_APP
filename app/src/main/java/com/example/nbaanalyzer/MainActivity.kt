package com.example.nbaanalyzer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.fragment.app.Fragment
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.nbaanalyzer.api.RestAPI
import com.example.nbaanalyzer.api.responses.TeamDataResponse
import com.example.nbaanalyzer.api.services.TeamAPIService
import com.example.nbaanalyzer.ui.help.HelpFragment
import com.example.nbaanalyzer.ui.team.MyTeamFragment
import com.example.nbaanalyzer.ui.select_team.SelectYourTeamActivity
import com.example.nbaanalyzer.ui.teams.TeamsFragment
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Load my team id
        val sharedPreferences = applicationContext.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val selectedTeamId= sharedPreferences.getInt("teamId", -1)
        Toast.makeText(this, "Team id: $selectedTeamId", Toast.LENGTH_SHORT).show()
        if (selectedTeamId == -1){
            val intent = Intent(this, SelectYourTeamActivity::class.java)
            startActivity(intent)
        }else{
            setContentView(R.layout.activity_main)

            // Create the app toolbar
            addToolBar()

            // Prepare NavigationView to select item
            val navigationView = findViewById<NavigationView>(R.id.nav_view)
            if(navigationView != null){
                setUpDrawer(navigationView)
                // Item selection by default
                val menuOption = sharedPreferences.getInt("menuOption", 0)
                itemSelection(navigationView.menu.getItem(menuOption))
                sharedPreferences.edit().remove("menuOption").apply()
            }

            drawerLayout = findViewById(R.id.drawer_layout)


        }


    }

    private fun setUpDrawer(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            itemSelection(menuItem)
            drawerLayout.closeDrawers()
            true
        }
    }

    private fun itemSelection(menuItem: MenuItem) {
        var genericFragment: Fragment? = null
        val fragmentManager = supportFragmentManager

        when (menuItem.itemId){
            R.id.nav_item_my_team -> genericFragment = MyTeamFragment()
            R.id.nav_item_teams -> genericFragment = TeamsFragment()
            R.id.nav_item_help -> genericFragment = HelpFragment()
        }

        if (genericFragment != null){
            fragmentManager.beginTransaction().replace(R.id.principal_container, genericFragment).commit()
        }

        menuItem.isCheckable = true
        menuItem.isChecked = true
        title = menuItem.title
    }

    private fun addToolBar() {
        val toolbar = findViewById<Toolbar?>(R.id.tool_bar_main)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_dehaze_white_24dp)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        applicationContext.getSharedPreferences("MyPref", Context.MODE_PRIVATE).edit().remove("menuOption").apply()
    }

}
