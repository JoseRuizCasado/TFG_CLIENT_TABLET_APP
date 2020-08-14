package com.example.nbaanalyzer.ui.team

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nbaanalyzer.MainActivity
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.TabsAdapter
import com.example.nbaanalyzer.Utils
import com.example.nbaanalyzer.ui.team.tabs.MyTeamPreviewFragment
import com.example.nbaanalyzer.ui.team.tabs.boxscore.MyBoxscoreFragment
import kotlin.properties.Delegates


/**
 * My Team section [Fragment] subclass.
 */
class MyTeamFragment : Fragment() {

    private lateinit var appBar: AppBarLayout
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private var utils = Utils()
    var teamID by Delegates.notNull<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_team, container, false)

        teamID = activity!!.getSharedPreferences("MyPref", Context.MODE_PRIVATE).getInt("teamId", -1)

        // Change the toolbar title with selected team name
        (activity as MainActivity).title = utils.getTeamById(teamID)

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
        val tabsAdapter: TabsAdapter = TabsAdapter(fragmentManager)
        tabsAdapter.addFragment(MyTeamPreviewFragment(), getString(R.string.tab_team_preview))
        tabsAdapter.addFragment(MyBoxscoreFragment(), getString(R.string.tab_boxscore))
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
