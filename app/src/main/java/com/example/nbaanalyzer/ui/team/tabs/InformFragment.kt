package com.example.nbaanalyzer.ui.team.tabs

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.Utils
import com.example.nbaanalyzer.ui.team.TeamDetails
import kotlinx.android.synthetic.main.fragment_inform.*
import kotlinx.android.synthetic.main.fragment_inform.view.*

/**
 * Inform [Fragment], compares teams advance statistics.
 */
class InformFragment : Fragment() {

    private val utils = Utils()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_inform, container, false)

        val teamId = activity!!.getSharedPreferences("MyPref", Context.MODE_PRIVATE).getInt("teamId", -1)
        val selectedTeam = (activity as TeamDetails).selectedTeam

        val text = "${utils.getTeamById(teamId)} VS ${utils.getTeamById(selectedTeam)}"

        view.inform_textView.text = text

        return view
    }
}
