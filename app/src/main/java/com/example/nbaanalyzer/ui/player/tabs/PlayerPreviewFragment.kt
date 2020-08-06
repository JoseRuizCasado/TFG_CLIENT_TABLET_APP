package com.example.nbaanalyzer.ui.player.tabs

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nbaanalyzer.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.charts.CombinedChart.DrawOrder
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.DecimalFormat
import kotlin.math.abs
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class PlayerPreviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentLayout = inflater.inflate(R.layout.fragment_player_preview, container, false)

        val radarChart = fragmentLayout.findViewById<RadarChart>(R.id.player_preview_radar_chart)

        radarChart.webColorInner = Color.LTGRAY
        radarChart.webColor = Color.LTGRAY


        val radarEntries = ArrayList<RadarEntry>()
        radarEntries.add(RadarEntry(123.45f))
        radarEntries.add(RadarEntry(111.45f))
        radarEntries.add(RadarEntry(23.45f))
        radarEntries.add(RadarEntry(56.45f))
        radarEntries.add(RadarEntry(56.45f))

        val radarDataSet = RadarDataSet(radarEntries,"Player Data")
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
