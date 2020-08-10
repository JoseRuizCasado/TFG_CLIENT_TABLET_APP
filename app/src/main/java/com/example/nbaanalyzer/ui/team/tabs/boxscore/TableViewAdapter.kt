package com.example.nbaanalyzer.ui.team.tabs.boxscore

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.api.PlayerDataResponse
import kotlinx.android.synthetic.main.item_boxscore_table.view.*

class TableViewAdapter(private val playerStatisticsList: List<PlayerDataResponse>, private val listener: (PlayerDataResponse) -> Unit): RecyclerView.Adapter<TableViewAdapter.ViewHolder>() {

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
            setContentBackground(item_boxscore_player_played_games)
            setContentBackground(item_boxscore_mpg)
            setContentBackground(item_boxscore_ppg)
            setContentBackground(item_boxscore_fgm)
            setContentBackground(item_boxscore_fga)
            setContentBackground(item_boxscore_fgp)
            setContentBackground(item_boxscore_3pm)
            setContentBackground(item_boxscore_3pa)
            setContentBackground(item_boxscore_3pp)
            setContentBackground(item_boxscore_ftm)
            setContentBackground(item_boxscore_fta)
            setContentBackground(item_boxscore_ftp)
            setContentBackground(item_boxscore_assists)
            setContentBackground(item_boxscore_or)
            setContentBackground(item_boxscore_dr)
            setContentBackground(item_boxscore_steal)
            setContentBackground(item_boxscore_blk)
            setContentBackground(item_boxscore_tov)
            setContentBackground(item_boxscore_fouls)
            setContentBackground(item_boxscore_offrtg)
            setContentBackground(item_boxscore_floorp)
            setContentBackground(item_boxscore_defrtg)
            setContentBackground(item_boxscore_netrtg)
            setContentBackground(item_boxscore_tsp)
            setContentBackground(item_boxscore_efgp)
            setContentBackground(item_boxscore_ftarate)
            setContentBackground(item_boxscore_threerate)
            setContentBackground(item_boxscore_orp)
            setContentBackground(item_boxscore_drp)
            setContentBackground(item_boxscore_blkp)
            setContentBackground(item_boxscore_tovp)
            setContentBackground(item_boxscore_astp)
            setContentBackground(item_boxscore_stlp)
            setContentBackground(item_boxscore_usagep)

            item_boxscore_player_id.text = player.player_id.toString()
            item_boxscore_player_name.text = "${player.first_name} ${player.last_name}"
            item_boxscore_player_position.text = player.position
            item_boxscore_player_played_games.text = player.played_games.toString()
            item_boxscore_mpg.text = "%.2f".format((player.played_minutes_per_game) / 60)
            item_boxscore_ppg.text = "%.2f".format(player.scored_points_per_game)
            item_boxscore_fgm.text = "%.2f".format(player.field_goals_made_per_game)
            item_boxscore_fga.text = "%.2f".format(player.field_goals_attempts_per_game)
            item_boxscore_fgp.text = "%.2f".format((player.field_goals_made.toFloat() / player.field_goals_attempts.toFloat()))
            item_boxscore_3pm.text = "%.2f".format(player.three_points_field_goals_made_per_game)
            item_boxscore_3pa.text = "%.2f".format(player.three_points_field_goals_attempts_per_game)
            item_boxscore_3pp.text = "%.2f".format((player.three_points_field_goals_made.toFloat() / player.three_points_field_goals_attempts.toFloat()))
            item_boxscore_ftm.text = "%.2f".format(player.free_throws_made_per_game)
            item_boxscore_fta.text = "%.2f".format(player.free_throws_attempts_per_game)
            item_boxscore_ftp.text = "%.2f".format((player.free_throws_made.toFloat() / player.free_throws_attempts.toFloat()))
            item_boxscore_assists.text = "%.2f".format(player.assists_per_game)
            item_boxscore_or.text = "%.2f".format(player.offensive_rebounds_per_game)
            item_boxscore_dr.text = "%.2f".format(player.defensive_rebounds_per_game)
            item_boxscore_steal.text = "%.2f".format(player.steals_per_game)
            item_boxscore_blk.text = "%.2f".format(player.blocks_per_game)
            item_boxscore_tov.text = "%.2f".format(player.turnovers_per_game)
            item_boxscore_fouls.text = "%.2f".format(player.personal_fouls_per_game)
            item_boxscore_offrtg.text = "%.2f".format(player.offRtg)
            item_boxscore_floorp.text = "%.2f".format(player.floor)
            item_boxscore_defrtg.text = "%.2f".format(player.defRtg)
            item_boxscore_netrtg.text = "%.2f".format(player.netRtg)
            item_boxscore_tsp.text = "%.2f".format(player.tS)
            item_boxscore_efgp.text = "%.2f".format(player.eFG)
            item_boxscore_ftarate.text = "%.2f".format(player.fTARate)
            item_boxscore_threerate.text = "%.2f".format(player.threeFGARate)
            item_boxscore_orp.text = "%.2f".format(player.oR)
            item_boxscore_drp.text = "%.2f".format(player.dR)
            item_boxscore_drp.text = "%.2f".format(player.dR)
            item_boxscore_blkp.text = "%.2f".format(player.bLK)
            item_boxscore_tovp.text = "%.2f".format(player.tOV)
            item_boxscore_astp.text = "%.2f".format(player.aST)
            item_boxscore_stlp.text = "%.2f".format(player.sTL)
            item_boxscore_usagep.text = "%.2f".format(player.uSG)

            setOnClickListener { listener(player) }

        }

    }

    private fun setContentBackground(textView: TextView){

        textView.setTextColor(Color.parseColor("#17408B"))
    }
}