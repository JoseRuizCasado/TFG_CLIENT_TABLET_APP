package com.example.nbaanalyzer

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * A {@link FragmentStatePagerAdapter} that manages the section fragments and
 * tabs title
 */
class TabsAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    private val fragments: MutableList<Fragment> = ArrayList()
    private val fragmentsTitles: MutableList<String> = ArrayList()


    override fun getItem(p0: Int): Fragment {
        return fragments[p0]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    fun addFragment(fragment: Fragment, title: String){
        fragments.add(fragment)
        fragmentsTitles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentsTitles[position]
    }

}