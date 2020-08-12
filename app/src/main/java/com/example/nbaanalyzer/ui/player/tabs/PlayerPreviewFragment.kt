package com.example.nbaanalyzer.ui.player.tabs

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nbaanalyzer.R
import com.example.nbaanalyzer.api.ClusterData
import com.example.nbaanalyzer.api.DefendData
import com.example.nbaanalyzer.api.DefendDataResponse
import com.example.nbaanalyzer.api.RestAPI
import com.example.nbaanalyzer.ui.player.PlayerActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.charts.CombinedChart.DrawOrder
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PlayerPreviewFragment : Fragment() {

    private lateinit var radarChart: RadarChart
    private lateinit var combinedChart: CombinedChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentLayout = inflater.inflate(R.layout.fragment_player_preview, container, false)

        val playerActivity = activity as PlayerActivity
        fragmentLayout.findViewById<TextView>(R.id.player_preview_position).text = playerActivity.playerPosition
        fragmentLayout.findViewById<TextView>(R.id.player_preview_play_style).text = getClusterLabel(playerActivity.cluster, playerActivity.playerPosition)
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
        combinedChart = fragmentLayout.findViewById(R.id.player_preview_combined_chart)

        val playerId = (activity as PlayerActivity).playerID
        val position = (activity as PlayerActivity).playerPosition
        getPlayerDefendData(playerId, position)

        setUpRadarChart(offRtg, defRtg, drp, tsp, efgp)



        return fragmentLayout
    }

    private fun setUpCombinedChart(defendData: DefendDataResponse, position: String) {

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
        lineEntries.add(Entry(0f, defendData.clusterData.cluster0.success.toFloat() / defendData.clusterData.cluster0.failure.toFloat()))
        lineEntries.add(Entry(1f, defendData.clusterData.cluster1.success.toFloat() / defendData.clusterData.cluster1.failure.toFloat()))
        lineEntries.add(Entry(2f, defendData.clusterData.cluster2.success.toFloat() / defendData.clusterData.cluster2.failure.toFloat()))
        lineEntries.add(Entry(3f, defendData.clusterData.cluster3.success.toFloat() / defendData.clusterData.cluster3.failure.toFloat()))
        lineEntries.add(Entry(4f, defendData.clusterData.cluster4.success.toFloat() / defendData.clusterData.cluster4.failure.toFloat()))
        if (position == "SG")
            lineEntries.add(Entry(5f, defendData.clusterData.cluster5.success.toFloat() / defendData.clusterData.cluster5.failure.toFloat()))

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

        barEntries.add(BarEntry(0f, defendData.playerData.cluster0.success.toFloat() / defendData.playerData.cluster0.failure.toFloat()))
        barEntries.add(BarEntry(1f, defendData.playerData.cluster1.success.toFloat() / defendData.playerData.cluster1.failure.toFloat()))
        barEntries.add(BarEntry(2f, defendData.playerData.cluster2.success.toFloat() / defendData.playerData.cluster2.failure.toFloat()))
        barEntries.add(BarEntry(3f, defendData.playerData.cluster3.success.toFloat() / defendData.playerData.cluster3.failure.toFloat()))
        barEntries.add(BarEntry(4f, defendData.playerData.cluster4.success.toFloat() / defendData.playerData.cluster4.failure.toFloat()))
        if (position == "SG")
            barEntries.add(BarEntry(5f, defendData.playerData.cluster5.success.toFloat() / defendData.playerData.cluster5.failure.toFloat()))

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

        combinedChart.xAxis.axisMaximum = combinedData.xMax + 1f
        combinedChart.animateXY(1400, 1400)
        combinedChart.data = combinedData
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
        radarChart.yAxis.axisMinimum = 12f

        // radarChart.description.textColor = Color.WHITE
        radarChart.description = null
        radarChart.legend.isEnabled = false
    }

    private fun getPlayerDefendData(playerId: Int, position: String){
        doAsync {
            val api = RestAPI()
            val response = api.getPlayerDefendData(playerId, position).execute()
            val defendData:  DefendDataResponse= if (response.isSuccessful){
                response.body()!!
            }else{
                val clusterData = ClusterData(0, 0)
                val defData = DefendData(clusterData, clusterData, clusterData, clusterData, clusterData, clusterData)
                DefendDataResponse(defData, defData)
            }
            uiThread { initializeCombinedChart(defendData, position) }
        }
    }

    private fun initializeCombinedChart(defendData: DefendDataResponse, position: String) {
        setUpCombinedChart(defendData, position)
    }

    private fun getClusterLabel(cluster: Int, position: String): String{
        var label = "Insufficient Info"

        if (cluster > 0 ){
            when (position){
                "PG" -> when (cluster){
                    0 -> label = "Scorer Playmaker"
                    1 -> label = "Secondary Scorer"
                    2 -> label = "Playmaker"
                    3 -> label = "Accurate Scorer"
                    4 -> label = "Defender"
                }
                "SG" -> when (cluster){
                    0 -> label = "3 and D"
                    1 -> label = "Secondary Shooter"
                    2 -> label = "Inefficient Scorer"
                    3 -> label = "Efficient Scorer"
                    4 -> label = "Efficient Shooter"
                    5 -> label = "Defender"
                }
                "SF" -> when (cluster){
                    0 -> label = "Athletic"
                    1 -> label = "2 Side Dominator"
                    2 -> label = "Inefficient Scorer"
                    3 -> label = "Efficient Scorer"
                    4 -> label = "3 Points Shooter"
                }
                "PF" -> when (cluster){
                    0 -> label = "Two Side"
                    1 -> label = "Primary Scorer"
                    2 -> label = "Open 4"
                    3 -> label = "2 Side Dominator"
                    4 -> label = "Role Player"
                    5 -> label = "Efficient Shooter"
                }
                "C" -> when (cluster){
                    0 -> label = "Role Defender"
                    1 -> label = "Scorer and Defender"
                    2 -> label = "2 Side Dominator"
                    3 -> label = "Open 5"
                    4 -> label = "Defender"
                }
            }

        }

        return label
    }


}
