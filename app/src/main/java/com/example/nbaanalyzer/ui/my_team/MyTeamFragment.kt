package com.example.nbaanalyzer.ui.my_team

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nbaanalyzer.MainActivity
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.TabsAdapter
import com.example.nbaanalyzer.ui.my_team.tabs.BoxscoreFragment
import com.example.nbaanalyzer.ui.my_team.tabs.TeamPreviewFragment


/**
 * My Team section [Fragment] subclass.
 */
class MyTeamFragment : Fragment() {

    private lateinit var appBar: AppBarLayout
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_team, container, false)

        // Change the toolbar title with selected team name
        (activity as MainActivity).title = "Boston Celtics"

        // Create tabs in toolbar
        if (savedInstanceState == null){
            insertTabs(container)

            // Setup the ViewPager
            viewPager = view.findViewById(R.id.my_team_view_pager)
            populateViewPager(viewPager)
            tabLayout.setupWithViewPager(viewPager)

        }

        return view
    }

    private fun populateViewPager(viewPager: ViewPager?) {
        val tabsAdapter: TabsAdapter =
            TabsAdapter(fragmentManager)
        tabsAdapter.addFragment(TeamPreviewFragment(), getString(R.string.tab_team_preview))
        tabsAdapter.addFragment(BoxscoreFragment(), getString(R.string.tab_boxscore))
        viewPager?.adapter = tabsAdapter
    }

    private fun insertTabs(container: ViewGroup?) {
        val fatherView = container!!.parent as View
        appBar = fatherView.findViewById(R.id.app_bar_main)
        tabLayout = TabLayout(activity)
        tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"))
        appBar.addView(tabLayout)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        appBar.removeView(tabLayout)
    }

}
