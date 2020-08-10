package com.example.nbaanalyzer.ui.player.tabs

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.ui.player.PlayerActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.charts.CombinedChart.DrawOrder
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.DecimalFormat
import kotlin.random.Random

class PlayerPreviewFragment : Fragment() {

    lateinit var radarChart: RadarChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentLayout = inflater.inflate(R.layout.fragment_player_preview, container, false)

        val playerActivity = activity as PlayerActivity
        fragmentLayout.findViewById<TextView>(R.id.player_preview_position).text = playerActivity.playerPosition
        fragmentLayout.findViewById<TextView>(R.id.player_preview_play_style).text = "Cluster 2"
        fragmentLayout.findViewById<TextView>(R.id.player_preview_games).text = playerActivity.playedGames.toString()
        fragmentLayout.findViewById<TextView>(R.id.player_preview_minutes).text = "%.2f".format(playerActivity.playedMinutes)
        fragmentLayout.findViewById<TextView>(R.id.player_preview_points).text = "%.2f".format(playerActivity.scoredPoints)
        fragmentLayout.findViewById<TextView>(R.id.player_preview_oreb).text = "%.2f".format(playerActivity.offensiveRebounds)
        fragmentLayout.findViewById<TextView>(R.id.player_preview_dreb).text = "%.2f".format(playerActivity.defensiveRebounds)
        fragmentLayout.findViewById<TextView>(R.id.player_preview_blk).text = "%.2f".format(playerActivity.blocks)
        fragmentLayout.findViewById<TextView>(R.id.player_preview_tov).text = "%.2f".format(playerActivity.turnovers)
        fragmentLayout.findViewById<TextView>(R.id.player_preview_fg).text = "%.2f".format(playerActivity.fgp)
        fragmentLayout.findViewById<TextView>(R.id.player_preview_3pt).text = "%.2f".format(playerActivity.threepp)
        fragmentLayout.findViewById<TextView>(R.id.player_preview_3pt_rate).text = "%.2f".format(playerActivity.threepr)

        val offRtg = playerActivity.offRtg
        val defRtg = playerActivity.defRtg
        val drp = playerActivity.drp
        val tsp = playerActivity.tsp * 100
        val efgp = playerActivity.efgp * 100

        radarChart = fragmentLayout.findViewById(R.id.player_preview_radar_chart)

        setUpRadarChart(offRtg, defRtg, drp, tsp, efgp)

        val combinedChart = fragmentLayout.findViewById<CombinedChart>(R.id.player_preview_combined_chart)
        combinedChart.description.isEnabled = false
        combinedChart.setBackgroundColor(Color.WHITE)
        combinedChart.setDrawGridBackground(false)
        combinedChart.setDrawBarShadow(false)
        combinedChart.isHighlightFullBarEnabled = false

        // draw bars behind lines
        combinedChart.drawOrder = arrayOf(DrawOrder.BAR, DrawOrder.LINE)

        combinedChart.axisRight.setDrawGridLines(false)
        combinedChart.axisRight.axisMinimum = 0f
        combinedChart.axisRight.isEnabled = false

        combinedChart.axisLeft.setDrawGridLines(false)
        combinedChart.axisLeft.axisMinimum = 0f
        combinedChart.axisLeft.isEnabled = false

        combinedChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        combinedChart.xAxis.setDrawGridLines(false)
        combinedChart.xAxis.axisMinimum = -1f
        combinedChart.xAxis.granularity = 1f

        val lineEntries = ArrayList<Entry>()
        for (index in 0 until 6)
            lineEntries.add(Entry(index.toFloat(), Random.nextDouble(5.0, 15.0).toFloat()))

        val lineDataSet = LineDataSet(lineEntries, "Cluster Mean")
        lineDataSet.color = Color.rgb(23, 64, 139)
        lineDataSet.lineWidth = 2.5f
        lineDataSet.setCircleColor(Color.rgb(23, 64, 139))
        lineDataSet.circleRadius = 5f
        lineDataSet.fillColor = Color.rgb(23, 64, 139)
        lineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        lineDataSet.setDrawValues(true)
        lineDataSet.valueTextSize = 10f
        lineDataSet.valueTextColor = Color.rgb(23, 64, 139)

        lineDataSet.axisDependency = YAxis.AxisDependency.LEFT

        val lineData = LineData(lineDataSet)

        val barEntries = ArrayList<BarEntry>()

        for (index in 0 until 6)
            barEntries.add(BarEntry(index.toFloat(), Random.nextDouble(5.0, 25.0).toFloat()))

        val barDataSet = BarDataSet(barEntries, "Player defend efficiency")
        barDataSet.color = Color.rgb(229, 115, 115)
        barDataSet.valueTextColor = Color.rgb(201, 8, 42)
        barDataSet.valueTextSize = 10f
        barDataSet.axisDependency = YAxis.AxisDependency.LEFT

        val barData = BarData(barDataSet)
        barData.barWidth = 0.5f

        val combinedData = CombinedData()
        combinedData.setData(lineData)
        combinedData.setData(barData)

        combinedChart.xAxis.axisMaximum =  combinedData.xMax + 1f
        combinedChart.animateXY(1400, 1400)
        combinedChart.data = combinedData

        return fragmentLayout
    }

    private fun setUpRadarChart(offRtg: Float, defRtg: Float, drp: Float, tsp: Float, efgp: Float) {
        radarChart.webColorInner = Color.LTGRAY
        radarChart.webColor = Color.LTGRAY


        val radarEntries = ArrayList<RadarEntry>()
        radarEntries.add(RadarEntry(offRtg))
        radarEntries.add(RadarEntry(defRtg))
        radarEntries.add(RadarEntry(drp))
        radarEntries.add(RadarEntry(tsp))
        radarEntries.add(RadarEntry(efgp))

        val radarDataSet = RadarDataSet(radarEntries, "Player Data")
        radarDataSet.color = Color.rgb(201, 8, 42)
        radarDataSet.fillColor = Color.rgb(201, 8, 42)
        radarDataSet.setDrawFilled(true)
        val radarData = RadarData(radarDataSet)
        radarChart.data = radarData

        radarChart.animateXY(1400, 1400, Easing.EaseInOutQuad)

        radarChart.xAxis.valueFormatter = object : ValueFormatter() {
            private val mActivities =
                arrayOf("OffRtg", "DefRtg", "DR%", "TS%", "eFG%")

            override fun getFormattedValue(value: Float): String {
                return mActivities[value.toInt() % mActivities.size]
            }
        }

        // radarChart.description.textColor = Color.WHITE
        radarChart.description = null
        radarChart.legend.isEnabled = false
    }

    private class ClusterLabelFormatter internal constructor(): ValueFormatter() {
        private val mFormat: DecimalFormat = DecimalFormat("###")
        override fun getFormattedValue(value: Float): String {
            if (value > 0){
                return "Cluster " + value.toInt()
            }
            return ""
        }
    }

}
