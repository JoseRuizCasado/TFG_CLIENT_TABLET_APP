package com.example.nbaanalyzer.ui.help

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.nbaanalyzer.MainActivity

import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.TabsAdapter
import com.example.nbaanalyzer.ui.help.tabs.ChartHelpFragment
import com.example.nbaanalyzer.ui.help.tabs.GamePredictonHelpFragment
import com.example.nbaanalyzer.ui.help.tabs.PlaystyleHelpFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass.
 */
class HelpFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var appBar: AppBarLayout
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val helpLayout =  inflater.inflate(R.layout.fragment_help, container, false)

        (activity as MainActivity).title = "Help"

        insertTabs(container)
        viewPager = helpLayout.findViewById(R.id.help_view_pager)
        populateViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)

        return helpLayout
    }

    private fun populateViewPager(viewPager: ViewPager?) {
        val tabsAdapter = TabsAdapter(fragmentManager)
        tabsAdapter.addFragment(ChartHelpFragment(), "Charts Info")
        tabsAdapter.addFragment(GamePredictonHelpFragment(), "Games Predictions")
        tabsAdapter.addFragment(PlaystyleHelpFragment(), "Play Style")
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
