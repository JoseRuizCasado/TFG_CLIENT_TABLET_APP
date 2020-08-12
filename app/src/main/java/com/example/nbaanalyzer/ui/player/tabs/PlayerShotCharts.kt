package com.example.nbaanalyzer.ui.player.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.example.nbaanalyzer.R
import com.squareup.picasso.Picasso


class PlayerShotCharts : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val frameLayout = inflater.inflate(R.layout.fragment_player_shot_charts, container, false)

        val imageView = frameLayout.findViewById<ImageView>(R.id.player_shot_chart)
        val imageView2 = frameLayout.findViewById<ImageView>(R.id.player_shot_chart2)

        Picasso.get().load("http://10.0.2.2:8000/media/player-preview_rRoLfDu.png").into(imageView)
        Picasso.get().load("http://10.0.2.2:8000/media/player-preview_rRoLfDu.png").into(imageView2)


        return frameLayout
    }

}
