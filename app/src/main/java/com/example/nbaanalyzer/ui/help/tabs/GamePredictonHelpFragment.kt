package com.example.nbaanalyzer.ui.help.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.nbaanalyzer.R

/**
 * A simple [Fragment] subclass.
 */
class GamePredictonHelpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val helpFragment = inflater.inflate(R.layout.fragment_game_predicton_help, container, false)

        return helpFragment
    }

}
