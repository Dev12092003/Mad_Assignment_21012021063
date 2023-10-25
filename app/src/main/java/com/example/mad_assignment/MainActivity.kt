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


package com.example.mad_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    private lateinit var inputValueEditText: EditText
    private lateinit var inputUnitEditText: EditText
    private lateinit var outputUnitEditText: EditText
    private lateinit var convertButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputValueEditText = findViewById(R.id.inputValue)
        inputUnitEditText = findViewById(R.id.inputUnit)
        outputUnitEditText = findViewById(R.id.outputUnit)
        convertButton = findViewById(R.id.convertButton)
        resultTextView = findViewById(R.id.resultTextView)

        convertButton.setOnClickListener {
            val inputValue = inputValueEditText.text.toString()
            if (inputValue.isDigitsOnly()) {
                val inputUnit = inputUnitEditText.text.toString()
                val outputUnit = outputUnitEditText.text.toString()

                val result = calculateResult(inputValue, inputUnit, outputUnit)

                resultTextView.text = result.toString()
            } else {
                resultTextView.text = "Invalid input value"
            }
        }
    }

    private fun calculateResult(inputValue: String, inputUnit: String, outputUnit: String): Double {
        val weightConversions = mapOf(
            "kg" to 2.20462262,
            "lb" to 1 / 2.20462262,
            "g" to 1 / 1000,
            "oz" to 1 / 28.3495
        )

        var conversionFactor = weightConversions[inputUnit]
        if (conversionFactor == null) {
            throw Exception("Invalid input unit")
        }

        return inputValue.toDouble() * conversionFactor
    }
}
//package com.example.mad_assignment
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import androidx.core.text.isDigitsOnly
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var inputValueEditText: EditText
//    private lateinit var inputUnitEditText: EditText
//    private lateinit var outputUnitEditText: EditText
//    private lateinit var convertButton: Button
//    private lateinit var resultTextView: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        inputValueEditText = findViewById(R.id.inputValue)
//        inputUnitEditText = findViewById(R.id.inputUnit)
//        outputUnitEditText = findViewById(R.id.outputUnit)
//        convertButton = findViewById(R.id.convertButton)
//        resultTextView = findViewById(R.id.resultTextView)
//
//        convertButton.setOnClickListener {
//            val inputValue = inputValueEditText.text.toString()
//            if (inputValue.isDigitsOnly()) {
//                val inputUnit = inputUnitEditText.text.toString()
//                val outputUnit = outputUnitEditText.text.toString()
//
//                val result = calculateResult(inputValue, inputUnit, outputUnit)
//
//                resultTextView.text = result.toString()
//            } else {
//                resultTextView.text = "Invalid input value"
//            }
//        }
//    }
//
//    private fun calculateResult(inputValue: String, inputUnit: String, outputUnit: String): Double {
//        val weightConversions = mapOf(
//            "kg" to 2.20462262,
//            "lb" to 1 / 2.20462262,
//            "g" to 1 / 1000,
//            "oz" to 1 / 28.3495
//        )
//
//        var conversionFactor = weightConversions[inputUnit]
//        if (conversionFactor == null) {
//            throw Exception("Invalid input unit")
//        }
//
//        return inputValue.toDouble() * conversionFactor
//    }
//}

//package com.example.mad_assignment
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import androidx.core.text.isDigitsOnly
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var inputValueEditText: EditText
//    private lateinit var inputUnitEditText: EditText
//    private lateinit var outputUnitEditText: EditText
//    private lateinit var convertButton: Button
//    private lateinit var resultTextView: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        inputValueEditText = findViewById(R.id.inputValue)
//        inputUnitEditText = findViewById(R.id.inputUnit)
//        outputUnitEditText = findViewById(R.id.outputUnit)
//        convertButton = findViewById(R.id.convertButton)
//        resultTextView = findViewById(R.id.resultTextView)
//
//        convertButton.setOnClickListener {
//            val inputValue = inputValueEditText.text.toString()
//            if (inputValue.isDigitsOnly()) {
//                val inputUnit = inputUnitEditText.text.toString()
//                val outputUnit = outputUnitEditText.text.toString()
//
//                val result = calculateResult(inputValue, inputUnit, outputUnit)
//
//                resultTextView.text = result.toString()
//            } else {
//                resultTextView.text = "Invalid input value"
//            }
//        }
//    }
//
//    private fun calculateResult(inputValue: String, inputUnit: String, outputUnit: String): Double {
//        val weightConversions = mapOf(
//            "kg" to 2.20462262,
//            "lb" to 1 / 2.20462262,
//            "g" to 1 / 1000,
//            "oz" to 1 / 28.3495
//        )
//
//        var conversionFactor = weightConversions[inputUnit]
//        if (conversionFactor == null) {
//            throw Exception("Invalid input unit")
//        }
//
//        return inputValue.toDouble() * conversionFactor
//    }
//}



//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import com.example.mad_assignment.R
//
//data class Unit(val name: String, val conversionFactor: Double)
//
//class MainActivity : AppCompatActivity() {
//
//    val units = listOf(
//        Unit("Meters", 1.0),
//        Unit("Feet", 3.28084),
//        Unit("Kilometers", 0.001),
//        Unit("Miles", 0.000621371),
//        Unit("Kilograms", 1.0),
//        Unit("Grams", 1000.0),
//        Unit("Pounds", 2.20462),
//        Unit("Ounces", 35.274)
//        // Add more units as needed
//    )
//
//    lateinit var inputValue: EditText
//    lateinit var inputUnit: EditText
//    lateinit var outputUnit: EditText
//    lateinit var convertButton: Button
//    lateinit var resultTextView: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        inputValue = findViewById(R.id.inputValue)
//        inputUnit = findViewById(R.id.inputUnit)
//        outputUnit = findViewById(R.id.outputUnit)
//        convertButton = findViewById(R.id.convertButton)
//        resultTextView = findViewById(R.id.resultTextView)
//
//        convertButton.setOnClickListener {
//            val inputValueText = inputValue.text.toString()
//            val inputUnitText = inputUnit.text.toString()
//            val outputUnitText = outputUnit.text.toString()
//
//            val inputValue = inputValueText.toDoubleOrNull() ?: 0.0
//            val inputUnit = units.find { it.name == inputUnitText }
//            val outputUnit = units.find { it.name == outputUnitText }
//
//            if (inputUnit != null && outputUnit != null) {
//                val convertedValue = inputValue * (inputUnit.conversionFactor / outputUnit.conversionFactor)
//                resultTextView.text = "Result: $convertedValue ${outputUnit.name}"
//            } else {
//                resultTextView.text = "Invalid units"
//            }
//        }
//    }
//}