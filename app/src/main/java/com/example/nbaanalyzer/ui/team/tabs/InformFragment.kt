package com.example.nbaanalyzer.ui.team.tabs

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.Utils
import com.example.nbaanalyzer.ui.team.TeamDetails
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.android.synthetic.main.fragment_inform.view.*
import java.text.DecimalFormat
import java.util.*
import kotlin.math.abs

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
        val informLayOut = inflater.inflate(R.layout.fragment_inform, container, false)

        val teamId = activity!!.getSharedPreferences("MyPref", Context.MODE_PRIVATE).getInt("teamId", -1)
        val selectedTeam = (activity as TeamDetails).selectedTeam

        informLayOut.informTextLocal.text = utils.getTeamById(teamId)
        informLayOut.informTextVisitor.text = utils.getTeamById(selectedTeam)

        val text = "${utils.getTeamById(teamId)} VS ${utils.getTeamById(selectedTeam)}"

        val barChart = informLayOut.findViewById<HorizontalBarChart>(R.id.inform_bar_chart)
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
        barEntries.add(BarEntry(5f, floatArrayOf(-10f, 10f)))
        barEntries.add(BarEntry(15f, floatArrayOf(-12f, 13f)))
        barEntries.add(BarEntry(25f, floatArrayOf(-15f, 15f)))
        barEntries.add(BarEntry(35f, floatArrayOf(-17f, 17f)))
        barEntries.add(BarEntry(45f, floatArrayOf(-19f, 20f)))
        barEntries.add(BarEntry(55f, floatArrayOf(-19f, 19f)))
        barEntries.add(BarEntry(65f, floatArrayOf(-16f, 16f)))
        barEntries.add(BarEntry(75f, floatArrayOf(-13f, 14f)))
        barEntries.add(BarEntry(85f, floatArrayOf(-10f, 11f)))
        barEntries.add(BarEntry(95f, floatArrayOf(-5f, 6f)))
        barEntries.add(BarEntry(105f, floatArrayOf(-1f, 2f)))

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

        return informLayOut
    }

    private class CustomFormatter internal constructor(): ValueFormatter() {
        private val mFormat: DecimalFormat = DecimalFormat("###")
        override fun getFormattedValue(value: Float): String {
            return mFormat.format(abs(value).toDouble())
        }

    }

    private class LabelFormatter internal constructor(): ValueFormatter() {
        private val mFormat: DecimalFormat = DecimalFormat("###")
        private val stats = listOf("OffRtg", "DefRtg", "Pace", "TS%", "eFG%", "3PTRate", "FTRate",
                                   "OR%", "DR%", "BLK%", "TO%").reversed()
        override fun getFormattedValue(value: Float): String {
            if (value.toInt()%10 == 0){
                val n = abs(value.toInt()/10)
                return if (n < 11) stats[n] else ""
            }
            return ""
        }
    }

}
