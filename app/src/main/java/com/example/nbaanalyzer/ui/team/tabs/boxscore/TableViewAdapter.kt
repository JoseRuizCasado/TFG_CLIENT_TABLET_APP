package com.example.nbaanalyzer.ui.team.tabs.boxscore

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.models.Player
import kotlinx.android.synthetic.main.item_boxscore_table.view.*

class TableViewAdapter(private val playerStatisticsList: List<Player>, private val listener: (Player) -> Unit): RecyclerView.Adapter<TableViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_boxscore_table, parent, false)
        return  ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return playerStatisticsList.size
    }

    override fun onBindViewHolder(holder: TableViewAdapter.ViewHolder, position: Int) {

        val player = playerStatisticsList[position]
        val resource = if (position%2 != 0) R.drawable.boxscore_table_content_cell_grey_background
        else R.drawable.boxscore_table_content_cell_white_background
        holder.itemView.setBackgroundResource(resource)
        holder.itemView.apply {
            setContentBackground(item_boxscore_player_id)
            setContentBackground(item_boxscore_player_name)
            setContentBackground(item_boxscore_player_position)
            setContentBackground(item_boxscore_mpg)
            setContentBackground(item_boxscore_fgm)
            setContentBackground(item_boxscore_fga)
            setContentBackground(item_boxscore_fgp)
            setContentBackground(item_boxscore_3pm)
            setContentBackground(item_boxscore_3pa)
            setContentBackground(item_boxscore_3pp)
            setContentBackground(item_boxscore_2pm)
            setContentBackground(item_boxscore_2pa)
            setContentBackground(item_boxscore_2pp)
            setContentBackground(item_boxscore_efficient_field_goals)
            setContentBackground(item_boxscore_ftm)

            item_boxscore_player_id.text = player.id.toString()
            item_boxscore_player_name.text = player.name
            item_boxscore_player_position.text = player.position
            item_boxscore_mpg.text = player.mpg.toString()
            item_boxscore_fgm.text = player.fgm.toString()
            item_boxscore_fga.text = player.fga.toString()
            item_boxscore_fgp.text = player.fgp.toString()
            item_boxscore_3pm.text = player.threepm.toString()
            item_boxscore_3pa.text = player.threepa.toString()
            item_boxscore_3pp.text = player.threepp.toString()
            item_boxscore_2pm.text = player.twoopm.toString()
            item_boxscore_2pa.text = player.twoopa.toString()
            item_boxscore_2pp.text = player.twoopp.toString()
            item_boxscore_efficient_field_goals.text = player.efficientfg.toString()
            item_boxscore_ftm.text = player.ftm.toString()

            setOnClickListener { listener(player) }

        }

    }

    private fun setContentBackground(textView: TextView){

        textView.setTextColor(Color.parseColor("#17408B"))
    }
}