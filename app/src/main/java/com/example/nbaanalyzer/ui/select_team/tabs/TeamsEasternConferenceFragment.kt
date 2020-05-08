package com.example.nbaanalyzer.ui.select_team.tabs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.nbaanalyzer.MainActivity
import com.example.nbaanalyzer.R


/**
 * A simple [Fragment] subclass.
 */
class TeamsEasternConferenceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_select_your_team_eastern, container, false)
        val button = view.findViewById<Button>(R.id.button)
        button!!.setOnClickListener {
            Toast.makeText(activity, "Button Pressed", Toast.LENGTH_SHORT).show()

            // Logic to save selected team id in preferences to load it
            val sharedPreferencesEditor = activity?.applicationContext?.getSharedPreferences("MyPref", Context.MODE_PRIVATE)?.edit()
            sharedPreferencesEditor?.putInt("teamId", 1)
            sharedPreferencesEditor?.apply()


            // Load main activity
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        return view
    }

}
