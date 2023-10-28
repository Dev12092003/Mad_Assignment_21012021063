package com.example.mad_assignment

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal

class Lengthconvert : AppCompatActivity() {

    private lateinit var editTextValue: EditText
    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner
    private lateinit var textViewResult: TextView

    private val units = listOf(
        "Meter", "Centimeter", "Inch", "Foot",  "Kilometer",  "Milimeter"
        // Add more units here
    )

    // Define conversion factors between units as BigDecimal
//    private val conversionFactors: Map<Pair<String, String>, BigDecimal> = mapOf(
//        Pair("Meter", "Centimeter") to BigDecimal("100.0"),
//        Pair("Centimeter", "Inch") to BigDecimal("0.393701"),
//        Pair("Inch", "Foot") to BigDecimal("1.0").divide(BigDecimal("12.0"), 10, BigDecimal.ROUND_HALF_UP),
//        Pair("Foot", "Yard") to BigDecimal("1.0").divide(BigDecimal("3.0"), 10, BigDecimal.ROUND_HALF_UP),
//        Pair("Yard", "Meter") to BigDecimal("0.9144"),
//        Pair("Meter", "Kilometer") to BigDecimal("0.001"),
//        Pair("Gram", "Kilogram") to BigDecimal("0.001"),
//        Pair("Kilogram", "Pound") to BigDecimal("2.20462")
//        // Add more unit conversions here
//    )
    private val conversionFactors = mapOf(
//        "Meter" to mapOf("Centimeter" to 100.0, "Kilometer" to 0.001),
        "Meter" to mapOf("Centimeter" to 100.0, "Kilometer" to 0.001, "Foot" to 3.28084, "Inch" to 39.3701, "Millimeter" to 1000.0),
//        "Centimeter" to mapOf("Inch" to 0.393701),
        "Centimeter" to mapOf("Meter" to 0.01, "Kilometer" to 0.00001, "Inch" to 0.393701, "Foot" to 0.0328084,  "Millimeter" to 10.0),
//        "Mm" to mapOf("Centimeter" to 0.10),
        "Millimeter" to mapOf("Centimeter" to 0.1, "Meter" to 0.001, "Kilometer" to 1.0e-6, "Inch" to 0.0393701, "Foot" to 0.00328084),
//        "Inch" to mapOf("Foot" to 1.0 / 12.0),
        "Inch" to mapOf("Meter" to 0.0254, "Centimeter" to 2.54, "Kilometer" to 0.0000254, "Foot" to 0.0833333,  "Millimeter" to 25.4),
//        "Foot" to mapOf("Yard" to 1.0 / 3.0),
        "Foot" to mapOf("Meter" to 0.3048, "Centimeter" to 30.48, "Kilometer" to 0.0003048, "Inch" to 12.0,  "Millimeter" to 304.8)
//        "Yard" to mapOf("Meter" to 0.9144),
//        "Gram" to mapOf("Kilogram" to 0.001),
//        "Kilogram" to mapOf("Pound" to 2.20462),

        // Add more unit conversions here
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lengthconvert)

        editTextValue = findViewById(R.id.editTextValue)
        spinnerFrom = findViewById(R.id.spinnerFrom)
        spinnerTo = findViewById(R.id.spinnerTo)
        textViewResult = findViewById(R.id.textViewResult)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter

        spinnerFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                convertUnit()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        spinnerTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                convertUnit()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun convertUnit() {
        val fromUnit = spinnerFrom.selectedItem.toString()
        val toUnit = spinnerTo.selectedItem.toString()

        val inputText = editTextValue.text.toString()

        if (inputText.isNotBlank()) {
            val inputValue = BigDecimal(inputText)
            val result = performConversion(fromUnit, toUnit, inputValue)
            textViewResult.text = "Result: $result $toUnit"
        } else {
            textViewResult.text = "Result: "
        }
    }

    private fun performConversion(fromUnit: String, toUnit: String, value: BigDecimal): BigDecimal {
        if (fromUnit == toUnit) {
            return value
        }

        val directConversionFactor = conversionFactors[fromUnit]?.get(toUnit)

        if (directConversionFactor != null) {
            return value * directConversionFactor.toBigDecimal()
        }

        for (commonUnit in units) {
            val factor1 = conversionFactors[fromUnit]?.get(commonUnit)
            val factor2 = conversionFactors[toUnit]?.get(commonUnit)

            if (factor1 != null && factor2 != null) {
                return value * (factor1.toBigDecimal() / factor2.toBigDecimal())
            }
        }

        return BigDecimal.ZERO
    }
//    private fun performConversion(fromUnit: String, toUnit: String, value: BigDecimal): BigDecimal {
//        if (fromUnit == toUnit) {
//            return value
//        }
//
//        // Check if a direct conversion factor exists
//        val directConversionFactor = conversionFactors[fromUnit]?.get(toUnit)
//        if (directConversionFactor != null) {
//            return value.multiply(BigDecimal(directConversionFactor.toString()))
//        }
//
//        // Check for indirect conversion via a common unit
//        for (commonUnit in units) {
//            val factor1 = conversionFactors[fromUnit]?.get(commonUnit)
//            val factor2 = conversionFactors[toUnit]?.get(commonUnit)
//
//            if (factor1 != null && factor2 != null) {
//                return value.multiply(BigDecimal(factor1.toString()).divide(BigDecimal(factor2.toString()), 10, BigDecimal.ROUND_HALF_UP))
//            }
//        }
//
//        return BigDecimal.ZERO
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_lengthconvert)
//
//    }
}