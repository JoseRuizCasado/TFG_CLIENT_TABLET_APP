package com.example.nbaanalyzer.ui.team.tabs

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.api.BestDefendersResponse
import com.example.nbaanalyzer.api.RestAPI
import com.example.nbaanalyzer.ui.team.TeamDetailsActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * A simple [Fragment] subclass.
 */
class DefendInformFragment : Fragment() {

    lateinit var opPG: TextView
    lateinit var opSG: TextView
    lateinit var opSF: TextView
    lateinit var opPF: TextView
    lateinit var opC: TextView
    lateinit var defPG: TextView
    lateinit var defSG: TextView
    lateinit var defSF: TextView
    lateinit var defPF: TextView
    lateinit var defC: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentLayout = inflater.inflate(R.layout.fragment_defend_inform, container, false)

        opPG = fragmentLayout.findViewById(R.id.player_preview_opponent_pg_starter)
        opSG = fragmentLayout.findViewById(R.id.player_preview_opponent_sg_starter)
        opSF = fragmentLayout.findViewById(R.id.player_preview_opponent_sf_starter)
        opPF = fragmentLayout.findViewById(R.id.player_preview_opponent_pf_starter)
        opC = fragmentLayout.findViewById(R.id.player_preview_opponent_c_starter)

        defPG = fragmentLayout.findViewById(R.id.player_preview_defender_pg)
        defSG = fragmentLayout.findViewById(R.id.player_preview_defender_sg)
        defSF = fragmentLayout.findViewById(R.id.player_preview_defender_sf)
        defPF = fragmentLayout.findViewById(R.id.player_preview_defender_pf)
        defC = fragmentLayout.findViewById(R.id.player_preview_defender_pf2)

        val teamID = activity!!.getSharedPreferences("MyPref", Context.MODE_PRIVATE).getInt("teamId", -1)
        val selectedTeam = (activity as TeamDetailsActivity).selectedTeam
        getDefendInfo(teamID, selectedTeam)

        return fragmentLayout
    }

    private fun getDefendInfo(teamID: Int, opponentTemID: Int){
        doAsync{
            val api = RestAPI()
            val response = api.getDefendInform(teamID, opponentTemID).execute()
            val defendData = if (response.isSuccessful){
                response.body()!!
            }else{
                BestDefendersResponse("-", "-", "-", "-",
                    "-", "-", "-", "-", "-", "-")
            }
            uiThread { setUpInfo(defendData) }
        }

    }

    private fun setUpInfo(defendData: BestDefendersResponse) {
        opPG.text = defendData.op_pg_name
        opSG.text = defendData.op_sg_name
        opSF.text = defendData.op_sf_name
        opPF.text = defendData.op_pf_name
        opC.text = defendData.op_c_name

        defPG.text = defendData.pg_name
        defSG.text = defendData.sg_name
        defSF.text = defendData.sf_name
        defPF.text = defendData.pf_name
        defC.text = defendData.c_name
    }

}
