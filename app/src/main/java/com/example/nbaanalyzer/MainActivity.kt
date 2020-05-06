package com.example.nbaanalyzer

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.nbaanalyzer.ui.help.HelpFragment
import com.example.nbaanalyzer.ui.my_team.MyTeamFragment
import com.example.nbaanalyzer.ui.teams.TeamsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Create the app toolbar
        addToolBar()

        // Prepare NavigationView to select item
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        if(navigationView != null){
            setUpDrawer(navigationView)
            // Item selection by default
            itemSelection(navigationView.menu.getItem(0))
        }

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

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

}
