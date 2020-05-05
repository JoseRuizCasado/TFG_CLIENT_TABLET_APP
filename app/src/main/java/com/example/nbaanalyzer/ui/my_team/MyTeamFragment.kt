package com.example.nbaanalyzer.ui.my_team

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nbaanalyzer.MainActivity

import com.example.nbaanalyzer.R

/**
 * A simple [Fragment] subclass.
 */
class MyTeamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Change the toolbar title with selected team name
        //(activity as MainActivity).actionBar?.title = "Boston Celtics"

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_team, container, false)
    }

}
