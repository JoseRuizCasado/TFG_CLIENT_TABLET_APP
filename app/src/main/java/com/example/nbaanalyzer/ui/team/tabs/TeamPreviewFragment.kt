package com.example.nbaanalyzer.ui.team.tabs

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nbaanalyzer.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter


/**
 * Team Preview tab [Fragment] subclass.
 */
class TeamPreviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentLayout = inflater.inflate(R.layout.fragment_team_preview, container, false)
        val radarChart = fragmentLayout.findViewById<RadarChart>(R.id.team_preview_radar_chart)

        radarChart.webColorInner = Color.LTGRAY
        radarChart.webColor = Color.LTGRAY


        val radarEntries = ArrayList<RadarEntry>()
        radarEntries.add(RadarEntry(123.45f))
        radarEntries.add(RadarEntry(111.45f))
        radarEntries.add(RadarEntry(23.45f))
        radarEntries.add(RadarEntry(56.45f))
        radarEntries.add(RadarEntry(56.45f))

        val radarDataSet = RadarDataSet(radarEntries,"Team Data")
        radarDataSet.color = Color.rgb(201, 8, 42)
        radarDataSet.fillColor = Color.rgb(201, 8, 42)
        radarDataSet.setDrawFilled(true)
        val radarData = RadarData(radarDataSet)
        radarChart.data = radarData

        radarChart.animateXY(1400, 1400, Easing.EaseInOutQuad)

        radarChart.xAxis.valueFormatter = object : ValueFormatter() {
            private val mActivities =
                arrayOf("OffRtg", "DefRtg", "OR%", "DR%", "eFG%")

            override fun getFormattedValue(value: Float): String {
                return mActivities[value.toInt() % mActivities.size]
            }
        }

        // radarChart.description.textColor = Color.WHITE
        radarChart.description = null
        radarChart.legend.isEnabled = false

        val barChart = fragmentLayout.findViewById<BarChart>(R.id.team_preview_bar_chart)

        barChart.legend.isEnabled = false
        barChart.description.isEnabled = false

        barChart.setDrawBarShadow(false)
        barChart.setDrawValueAboveBar(true)

        barChart.setPinchZoom(false)

        val players = ArrayList<String>()
        players.add("Player 1")
        players.add("Player 2")
        players.add("Player 3")
        players.add("Player 4")
        players.add("Player 5")

        val barChartXAxis = barChart.xAxis
        barChartXAxis.position = XAxis.XAxisPosition.BOTTOM
        barChartXAxis.setDrawGridLines(false)
        barChartXAxis.granularity = 1f
        barChartXAxis.valueFormatter = IndexAxisValueFormatter(players)

        val barChartLeftAxis = barChart.axisLeft
        barChartLeftAxis.setDrawGridLines(false)
        barChartLeftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        barChartLeftAxis.axisMinimum = 0f
        barChartLeftAxis.spaceTop = 15f

        barChart.axisRight.isEnabled = false

        barChart.animateY(1500)

        val barEntries = ArrayList<BarEntry>()
        barEntries.add(BarEntry(0f, 35.45f))
        barEntries.add(BarEntry(1f, 23.39f))
        barEntries.add(BarEntry(2f, 15.21f))
        barEntries.add(BarEntry(3f, 13.12f))
        barEntries.add(BarEntry(4f, 12.45f))

        val barDataSet = BarDataSet(barEntries, "Player Usage")
        val barData = BarData(barDataSet)
        barChart.data = barData

        return fragmentLayout
    }


}
