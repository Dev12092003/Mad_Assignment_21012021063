//package com.example.mad_assignment
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//    }
//}
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

data class Unit(val name: String, val conversionFactor: Double)

class MainActivity : AppCompatActivity() {

    val units = listOf(
        Unit("Meters", 1.0),
        Unit("Feet", 3.28084),
        Unit("Kilometers", 0.001),
        Unit("Miles", 0.000621371),
        Unit("Kilograms", 1.0),
        Unit("Grams", 1000.0),
        Unit("Pounds", 2.20462),
        Unit("Ounces", 35.274)
        // Add more units as needed
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        convertButton.setOnClickListener {
            val inputValue = inputValue.text.toString().toDoubleOrNull() ?: 0.0
            val inputUnitName = inputUnit.text.toString()
            val outputUnitName = outputUnit.text.toString()

            val inputUnit = units.find { it.name == inputUnitName }
            val outputUnit = units.find { it.name == outputUnitName }

            if (inputUnit != null && outputUnit != null) {
                val convertedValue = inputValue * (inputUnit.conversionFactor / outputUnit.conversionFactor)
                resultTextView.text = "Result: $convertedValue ${outputUnit.name}"
            } else {
                resultTextView.text = "Invalid units"
            }
        }
    }
}