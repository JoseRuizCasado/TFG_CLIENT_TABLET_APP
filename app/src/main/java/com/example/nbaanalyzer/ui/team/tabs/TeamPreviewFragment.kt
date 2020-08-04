package com.example.nbaanalyzer.ui.team.tabs

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nbaanalyzer.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.formatter.StackedValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate


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
        barDataSet.colors = listOf(Color.rgb(144, 202, 249))
        val barData = BarData(barDataSet)
        barChart.data = barData

        val pieChart = fragmentLayout.findViewById<PieChart>(R.id.team_preview_pie_chart)
        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = false
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)

        pieChart.dragDecelerationFrictionCoef = 0.95f

        val pieCenterText = SpannableString("Team score distribution \n by position")
        pieCenterText.setSpan(ForegroundColorSpan(activity!!.resources.getColor(R.color.colorPrimary)),
            0, pieCenterText.length, 0)
        pieChart.centerText = pieCenterText

        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)

        pieChart.setTransparentCircleColor(Color.WHITE)
        pieChart.setTransparentCircleAlpha(110)

        pieChart.holeRadius = 58f
        pieChart.transparentCircleRadius = 61f

        pieChart.setDrawCenterText(true)

        pieChart.rotationAngle = 0f
        pieChart.isRotationEnabled = true
        pieChart.isHighlightPerTapEnabled = true

        pieChart.animateY(1400, Easing.EaseInOutQuad)

        pieChart.legend.isEnabled = false

        pieChart.setEntryLabelColor(Color.WHITE)
        pieChart.setEntryLabelTextSize(12f)

        val pieEntriesList = ArrayList<PieEntry>()
        pieEntriesList.add(PieEntry(1098f, "PG"))
        pieEntriesList.add(PieEntry(529f, "SG"))
        pieEntriesList.add(PieEntry(752f, "SF"))
        pieEntriesList.add(PieEntry(1030f, "PG"))
        pieEntriesList.add(PieEntry(932f, "C"))

        val pieDataSet = PieDataSet(pieEntriesList, "Score per position")

        val colors =  ColorTemplate.MATERIAL_COLORS.toMutableList()
        colors.add(Color.rgb(255, 167, 38))
        pieDataSet.colors = colors

        val pieData = PieData(pieDataSet)
        pieData.setValueFormatter(PercentFormatter(pieChart))
        pieData.setValueTextSize(11f)
        pieData.setValueTextColor(Color.WHITE)

        pieChart.data = pieData
        pieChart.highlightValues(null)

        val stackedBarChart = fragmentLayout.findViewById<BarChart>(R.id.team_preview_stacked_bar_chart)

        stackedBarChart.description.isEnabled = false

        stackedBarChart.setPinchZoom(false)
        stackedBarChart.setDrawGridBackground(false)
        stackedBarChart.setDrawBarShadow(false)

        stackedBarChart.setDrawValueAboveBar(false)
        stackedBarChart.isHighlightFullBarEnabled = false

        val stackedLeftAxis = stackedBarChart.axisLeft
        stackedLeftAxis.axisMinimum = 0f
        stackedLeftAxis.setDrawGridLines(false)
        stackedBarChart.axisRight.isEnabled = false

        val stackedXLabels = stackedBarChart.xAxis
        stackedXLabels.position = XAxis.XAxisPosition.BOTTOM
        stackedXLabels.setDrawGridLines(false)

        val positions = ArrayList<String>()
        positions.add("PG")
        positions.add("SG")
        positions.add("SF")
        positions.add("PF")
        positions.add("C")
        stackedXLabels.valueFormatter = IndexAxisValueFormatter(positions)
        stackedXLabels.labelCount = 5

        val stackedBarEntries = ArrayList<BarEntry>()
        stackedBarEntries.add(BarEntry(0f, floatArrayOf(1000f, 98f)))
        stackedBarEntries.add(BarEntry(1f, floatArrayOf(264.5f, 264.5f)))
        stackedBarEntries.add(BarEntry(2f, floatArrayOf(652f, 100f)))
        stackedBarEntries.add(BarEntry(3f, floatArrayOf(230f, 800f)))
        stackedBarEntries.add(BarEntry(4f, floatArrayOf(890f, 42f)))

        val stackedBarDataSet = BarDataSet(stackedBarEntries, "")
        stackedBarDataSet.stackLabels = (arrayOf("Starters", "Subs"))
        stackedBarDataSet.colors = listOf(Color.rgb(144, 202, 249), Color.rgb(229, 115, 115))
        stackedBarDataSet.setDrawIcons(false)

        val stackedBarData = BarData(stackedBarDataSet)
        stackedBarData.setValueFormatter(StackedValueFormatter(false, "", 1))
        stackedBarChart.data = stackedBarData

        stackedBarChart.legend.verticalAlignment = Legend.LegendVerticalAlignment.CENTER;
        stackedBarChart.legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT;
        stackedBarChart.legend.orientation = Legend.LegendOrientation.VERTICAL;
        stackedBarChart.legend.setDrawInside(false);

        return fragmentLayout
    }


}
