package com.example.nbaanalyzer.ui.player.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.nbaanalyzer.R

/**
 * A simple [Fragment] subclass.
 */
class PlayerShotCharts : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player_shot_charts, container, false)
    }

}
