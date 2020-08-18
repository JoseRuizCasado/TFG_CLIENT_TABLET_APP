package com.example.nbaanalyzer.ui.player.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.ui.player.PlayerActivity
import com.squareup.picasso.Picasso


class PlayerShotCharts : Fragment() {


    private val baseURL = "http://10.0.2.2:8000"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Picasso.get().isLoggingEnabled = true
        // Inflate the layout for this fragment
        val frameLayout = inflater.inflate(R.layout.fragment_player_shot_charts, container, false)

        val imageViewLeft = frameLayout.findViewById<ImageView>(R.id.player_shot_chart)
        val imageViewRight = frameLayout.findViewById<ImageView>(R.id.player_shot_chart2)
        val playerID = (activity as PlayerActivity).playerID

        Picasso.get().load(baseURL+"/media/${playerID}-scatter.png").into(imageViewLeft)
        Picasso.get().load(baseURL+"/media/${playerID}-hexbin.png").into(imageViewRight)

        return frameLayout
    }

}
