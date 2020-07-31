package com.example.nbaanalyzer.ui.team.tabs.boxscore

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.Utils
import com.example.nbaanalyzer.ui.player.PlayerActivity

/**
 * A simple [Fragment] subclass.
 */
class BoxscoreFragment : Fragment() {

    private val utils = Utils()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_boxscore, container, false)

        // TODO: Change table header to use a vertical layout with recycler view
        val recyclerView = view.findViewById<RecyclerView>(R.id.boxscore_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TableViewAdapter(utils.playersStatistics){
            Toast.makeText(activity, "${it.name} pressed, with id: ${it.id}", Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, PlayerActivity::class.java)
            intent.putExtra("name", it.name)
            startActivity(intent)
        }


        return view
    }

}
