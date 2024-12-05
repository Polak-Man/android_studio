package com.example.super_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class Aff_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aff) // Ensure this layout exists and includes the required views.

        // Button to navigate to MainActivity
        findViewById<Button>(R.id.accueil).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Initialize LineChart
        val chart = findViewById<LineChart>(R.id.chart) // Ensure you have a LineChart in your XML layout.

        // Prepare data for the chart
        val dataObjects = arrayOf(
            YourData(1f, 2f),
            YourData(2f, 4f),
            YourData(3f, 6f)
        )

        val entries = mutableListOf<Entry>()
        for (data in dataObjects) {
            // Use property access instead of getter methods
            entries.add(Entry(data.valueX, data.valueY))
        }

        // Create a LineDataSet
        val dataSet = LineDataSet(entries, "Sample Data")
        dataSet.color = getColor(R.color.purple_500) // Adjust color as needed
        dataSet.valueTextColor = getColor(R.color.black)

        // Create LineData and bind it to the chart
        val lineData = LineData(dataSet)
        chart.data = lineData

        // Refresh the chart
        chart.invalidate()
    }
}

// Example data class for chart data points
data class YourData(val valueX: Float, val valueY: Float)
