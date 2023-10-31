package com.example.mad_assignment

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import java.math.RoundingMode

class Temperatureconvert : AppCompatActivity() {
    private lateinit var editTextValue: EditText
    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner
    private lateinit var textViewResult: TextView

    private val units = listOf(
        "Celsius", "Fahrenheit", "Kelvin"
        // Add more temperature units here
    )

//    private val temperatureConversionFactors = mapOf(
//        "Celsius" to mapOf("Fahrenheit" to BigDecimal("33.8").setScale(2), "Kelvin" to BigDecimal("274.15").setScale(2)),
//        "Fahrenheit" to mapOf("Celsius" to BigDecimal("0.55556").setScale(5), "Kelvin" to BigDecimal("255.372").setScale(3)),
//        "Kelvin" to mapOf("Celsius" to BigDecimal("0.55556").setScale(5), "Fahrenheit" to BigDecimal("1.8").setScale(2))
////        "Celsius" to mapOf("Fahrenheit" to 32.0, "Kelvin" to 273.15),
////        "Fahrenheit" to mapOf("Celsius" to -17.7778, "Kelvin" to 255.372),
////        "Kelvin" to mapOf("Celsius" to -273.15, "Fahrenheit" to -457.87)
//        // Add more temperature unit conversions here
//    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperatureconvert)
        editTextValue = findViewById(R.id.editTextValue)
        spinnerFrom = findViewById(R.id.spinnerFrom)
        spinnerTo = findViewById(R.id.spinnerTo)
        textViewResult = findViewById(R.id.textViewResult)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter

        setupListeners()
        convertUnit()
    }
    private fun setupListeners() {
        editTextValue.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                convertUnit()
            }

            override fun afterTextChanged(s: Editable?) {
                // Do nothing
            }
        })

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
//    private fun performConversion(fromUnit: String, toUnit: String, value: BigDecimal): BigDecimal {
//        if (fromUnit == toUnit) {
//            return value
//        }
//
//        val directConversionFactor = temperatureConversionFactors[fromUnit]?.get(toUnit)
//
//        if (directConversionFactor != null) {
//            return value * directConversionFactor
//        }
//
//        for (commonUnit in units) {
//            val factor1 = temperatureConversionFactors[fromUnit]?.get(commonUnit)
//            val factor2 = temperatureConversionFactors[toUnit]?.get(commonUnit)
//
//            if (factor1 != null && factor2 != null) {
//                return value.multiply(factor1).divide(factor2, 5, RoundingMode.HALF_UP)
//            }
//        }
//
//        return BigDecimal.ZERO
//    }

    private fun performConversion(fromUnit: String, toUnit: String, value: BigDecimal): BigDecimal {
        return when {
            fromUnit == "Celsius" && toUnit == "Fahrenheit" -> value.multiply(BigDecimal("1.8")).add(BigDecimal("32"))
            fromUnit == "Celsius" && toUnit == "Kelvin" -> value.add(BigDecimal("273.15"))
            fromUnit == "Fahrenheit" && toUnit == "Celsius" -> value.subtract(BigDecimal("32")).multiply(BigDecimal("0.55556"))
            fromUnit == "Fahrenheit" && toUnit == "Kelvin" -> value.subtract(BigDecimal("32")).multiply(BigDecimal("0.55556")).add(BigDecimal("273.15"))
            fromUnit == "Kelvin" && toUnit == "Celsius" -> value.subtract(BigDecimal("273.15"))
            fromUnit == "Kelvin" && toUnit == "Fahrenheit" -> value.subtract(BigDecimal("273.15")).multiply(BigDecimal("1.8")).add(BigDecimal("32"))
            else -> value // No conversion needed
        }.setScale(2, RoundingMode.HALF_UP)
    }

//    private fun performConversion(fromUnit: String, toUnit: String, value: BigDecimal): BigDecimal {
//        if (fromUnit == toUnit) {
//            return value
//        }
//
//        val directConversionFactor = temperatureConversionFactors[fromUnit]?.get(toUnit)
//
//        if (directConversionFactor != null) {
//            return value * directConversionFactor.toBigDecimal()
//        }
//
//        for (commonUnit in units) {
//            val factor1 = temperatureConversionFactors[fromUnit]?.get(commonUnit)
//            val factor2 = temperatureConversionFactors[toUnit]?.get(commonUnit)
//
//            if (factor1 != null && factor2 != null) {
//                return value * (factor1.toBigDecimal() / factor2.toBigDecimal())
//            }
//        }
//
//        return BigDecimal.ZERO
//    }
}




//class TemperatureConvert : AppCompatActivity() {
//
//    private lateinit var editTextValue: EditText
//    private lateinit var spinnerFrom: Spinner
//    private lateinit var spinnerTo: Spinner
//    private lateinit var textViewResult: TextView
//
//    private val units = listOf(
//        "Celsius", "Fahrenheit", "Kelvin"
//        // Add more temperature units here
//    )
//
//    private val temperatureConversionFactors = mapOf(
//        "Celsius" to mapOf("Fahrenheit" to 32.0, "Kelvin" to 273.15),
//        "Fahrenheit" to mapOf("Celsius" to -17.7778, "Kelvin" to 255.372),
//        "Kelvin" to mapOf("Celsius" to -273.15, "Fahrenheit" to -457.87)
//        // Add more temperature unit conversions here
//    )
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_temperature_convert)
//
//        editTextValue = findViewById(R.id.editTextValue)
//        spinnerFrom = findViewById(R.id.spinnerFrom)
//        spinnerTo = findViewById(R.id.spinnerTo)
//        textViewResult = findViewById(R.id.textViewResult)
//
//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//
//        spinnerFrom.adapter = adapter
//        spinnerTo.adapter = adapter
//
//        spinnerFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                convertUnit()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                // Do nothing
//            }
//        }
//
//        spinnerTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                convertUnit()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                // Do nothing
//            }
//        }
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun convertUnit() {
//        val fromUnit = spinnerFrom.selectedItem.toString()
//        val toUnit = spinnerTo.selectedItem.toString()
//
//        val inputText = editTextValue.text.toString()
//
//        if (inputText.isNotBlank()) {
//            val inputValue = BigDecimal(inputText)
//            val result = performConversion(fromUnit, toUnit, inputValue)
//            textViewResult.text = "Result: $result $toUnit"
//        } else {
//            textViewResult.text = "Result: "
//        }
//    }
//
//    private fun performConversion(fromUnit: String, toUnit: String, value: BigDecimal): BigDecimal {
//        if (fromUnit == toUnit) {
//            return value
//        }
//
//        val directConversionFactor = temperatureConversionFactors[fromUnit]?.get(toUnit)
//
//        if (directConversionFactor != null) {
//            return value * directConversionFactor.toBigDecimal()
//        }
//
//        for (commonUnit in units) {
//            val factor1 = temperatureConversionFactors[fromUnit]?.get(commonUnit)
//            val factor2 = temperatureConversionFactors[toUnit]?.get(commonUnit)
//
//            if (factor1 != null && factor2 != null) {
//                return value * (factor1.toBigDecimal() / factor2.toBigDecimal())
//            }
//        }
//
//        return BigDecimal.ZERO
//    }
//}