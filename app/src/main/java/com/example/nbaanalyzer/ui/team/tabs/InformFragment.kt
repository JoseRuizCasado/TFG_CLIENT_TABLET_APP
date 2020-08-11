package com.example.nbaanalyzer.ui.team.tabs

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.Utils
import com.example.nbaanalyzer.api.InformResponse
import com.example.nbaanalyzer.api.RestAPI
import com.example.nbaanalyzer.ui.player.PlayerActivity
import com.example.nbaanalyzer.ui.team.TeamDetailsActivity
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.android.synthetic.main.fragment_inform.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.text.DecimalFormat
import java.util.*
import kotlin.math.abs

/**
 * Inform [Fragment], compares teams advance statistics.
 */
class InformFragment : Fragment() {

    private val utils = Utils()
    lateinit var barChart: HorizontalBarChart
    lateinit var textLocal: TextView
    lateinit var textVisitor: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val informLayOut = inflater.inflate(R.layout.fragment_inform, container, false)

        val teamId = activity!!.getSharedPreferences("MyPref", Context.MODE_PRIVATE).getInt("teamId", -1)
        val selectedTeam = (activity as TeamDetailsActivity).selectedTeam

        informLayOut.informTextLocal.text = utils.getTeamById(teamId)
        informLayOut.informTextVisitor.text = utils.getTeamById(selectedTeam)

        textLocal = informLayOut.informTexWinLocal
        textVisitor = informLayOut.informTexWinVisitor

        barChart = informLayOut.findViewById(R.id.inform_bar_chart)

        val opponentTeamID = (activity as TeamDetailsActivity).selectedTeam
        val teamID = activity!!.getSharedPreferences("MyPref", Context.MODE_PRIVATE).getInt("teamId", -1)
        getInform(teamID, opponentTeamID)

        return informLayOut
    }

    private fun setUpBarChart(informResponse: InformResponse) {

        textLocal.text = informResponse.localPrediction
        textVisitor.text = informResponse.visitorPrediction

        barChart.setDrawGridBackground(false)
        barChart.description.isEnabled = false

        barChart.setPinchZoom(false)

        barChart.setDrawBarShadow(false)
        barChart.setDrawValueAboveBar(true)
        barChart.isHighlightFullBarEnabled = false

        barChart.axisLeft.isEnabled = false
        barChart.axisRight.setDrawGridLines(false)
        barChart.axisRight.setDrawZeroLine(true)
        barChart.axisRight.valueFormatter = CustomFormatter()
        barChart.axisRight.textSize = 9f
        barChart.axisRight.isEnabled = false

        val xAxis: XAxis = barChart.xAxis
        xAxis.position = XAxisPosition.BOTH_SIDED
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(false)
        xAxis.textSize = 9f
        xAxis.axisMinimum = 0f
        xAxis.axisMaximum = 110f
        xAxis.setCenterAxisLabels(true)
        xAxis.labelCount = 13
        xAxis.granularity = 10f
        xAxis.valueFormatter = LabelFormatter()

        barChart.legend.isEnabled = false

        barChart.animateY(1500)

        val barEntries = ArrayList<BarEntry>()
        barEntries.add(BarEntry(5f, floatArrayOf(-informResponse.localOffRtg, informResponse.visitorOffRtg)))
        barEntries.add(BarEntry(15f, floatArrayOf(-informResponse.localFloor * 100, informResponse.visitorFloor * 100)))
        barEntries.add(BarEntry(25f, floatArrayOf(-informResponse.localDefRtg, informResponse.visitorDefRtg)))
        barEntries.add(BarEntry(35f, floatArrayOf(-informResponse.localPace, informResponse.visitorPace)))
        barEntries.add(BarEntry(45f, floatArrayOf(-informResponse.localTS * 100, informResponse.visitorTS * 100)))
        barEntries.add(BarEntry(55f, floatArrayOf(-informResponse.localeFG * 100, informResponse.visitoreFG * 100)))
        barEntries.add(BarEntry(65f, floatArrayOf(-informResponse.local3FGARate * 100, informResponse.visitor3FGARate * 100)))
        barEntries.add(BarEntry(75f, floatArrayOf(-informResponse.localFTARate * 100, informResponse.visitorFTARate * 100)))
        barEntries.add(BarEntry(85f, floatArrayOf(-informResponse.localOR, informResponse.visitorOR)))
        barEntries.add(BarEntry(95f, floatArrayOf(-informResponse.localDR, informResponse.visitorDR)))
        barEntries.add(BarEntry(105f, floatArrayOf(-informResponse.localTOV, informResponse.visitorTOV)))

        val barDataSet = BarDataSet(barEntries, "Advanced stats")
        barDataSet.setDrawIcons(false)
        barDataSet.valueFormatter = CustomFormatter()
        barDataSet.valueTextSize = 7f
        barDataSet.axisDependency = YAxis.AxisDependency.RIGHT
        barDataSet.setColors(
            Color.rgb(67, 67, 72),
            Color.rgb(124, 181, 236)
        )
        barDataSet.stackLabels = arrayOf(
            "Team", "Opponent"
        )

        val barData = BarData(barDataSet)
        barData.barWidth = 8.5f
        barChart.data = barData
    }

    private class CustomFormatter internal constructor(): ValueFormatter() {
        private val mFormat: DecimalFormat = DecimalFormat("###")
        override fun getFormattedValue(value: Float): String {
            return mFormat.format(abs(value).toDouble())
        }

    }

    private class LabelFormatter internal constructor(): ValueFormatter() {
        private val mFormat: DecimalFormat = DecimalFormat("###")
        private val stats = listOf("OffRtg", "Floor%", "DefRtg", "Pace", "TS%", "eFG%", "3PTRate", "FTRate",
                                   "OR%", "DR%", "TO%")
        override fun getFormattedValue(value: Float): String {
            if (value.toInt()%10 == 0){
                val n = abs(value.toInt()/10)
                return if (n < 11) stats[n] else ""
            }
            return ""
        }
    }

    private fun getInform(teamID: Int, opponentTeamID: Int){
        doAsync {
            val api = RestAPI()
            val response = api.getInform(teamID, opponentTeamID).execute()
            val inform = if (response.isSuccessful){
                response.body()!!
            }else{
                InformResponse(0f, 0f, 0f, 0f, 0f,
                    0f, 0f, 0f, 0f, 0f,
                    0f, 0f, 0f, 0f, 0f,
                    0f, 0f, 0f, 0f, 0f,
                    0f, 0f, 0f, 0f, 0f,
                0f, "", "")
            }

            uiThread { setUpBarChart(inform) }
        }
    }

}
