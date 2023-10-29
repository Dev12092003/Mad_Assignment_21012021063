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

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

//    private lateinit var editTextValue: EditText
//    private lateinit var spinnerFrom: Spinner
//    private lateinit var spinnerTo: Spinner
//    private lateinit var textViewResult: TextView
//
//    private val units = listOf(
//        "Meter", "Centimeter", "Inch", "Foot", "Yard", "Kilometer", "Gram", "Kilogram", "Pound","Mm"
//        // Add more units here
//    )
//
//    // Define conversion factors between units as BigDecimal
////    private val conversionFactors: Map<Pair<String, String>, BigDecimal> = mapOf(
////        Pair("Meter", "Centimeter") to BigDecimal("100.0"),
////        Pair("Centimeter", "Inch") to BigDecimal("0.393701"),
////        Pair("Inch", "Foot") to BigDecimal("1.0").divide(BigDecimal("12.0"), 10, BigDecimal.ROUND_HALF_UP),
////        Pair("Foot", "Yard") to BigDecimal("1.0").divide(BigDecimal("3.0"), 10, BigDecimal.ROUND_HALF_UP),
////        Pair("Yard", "Meter") to BigDecimal("0.9144"),
////        Pair("Meter", "Kilometer") to BigDecimal("0.001"),
////        Pair("Gram", "Kilogram") to BigDecimal("0.001"),
////        Pair("Kilogram", "Pound") to BigDecimal("2.20462")
////        // Add more unit conversions here
////    )
//    private val conversionFactors = mapOf(
//            "Meter" to mapOf("Centimeter" to 100.0, "Kilometer" to 0.001),
//            "Centimeter" to mapOf("Inch" to 0.393701),
//            "Mm" to mapOf("Centimeter" to 0.10),
//            "Inch" to mapOf("Foot" to 1.0 / 12.0),
//            "Foot" to mapOf("Yard" to 1.0 / 3.0),
//            "Yard" to mapOf("Meter" to 0.9144),
//            "Gram" to mapOf("Kilogram" to 0.001),
//            "Kilogram" to mapOf("Pound" to 2.20462),
//            // Add more unit conversions here
//        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cardView=findViewById<CardView>(R.id.lenghtbtn)
        cardView.setOnClickListener{
            val intent=Intent(this,Lengthconvert::class.java)
            startActivity(intent)
        }
        val weight=findViewById<CardView>(R.id.weightbtnn)
        weight.setOnClickListener{
            val intent=Intent(this,Weightconvert::class.java)
            startActivity(intent)
        }


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
        }
    }

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
//        val directConversionFactor = conversionFactors[fromUnit]?.get(toUnit)
//
//        if (directConversionFactor != null) {
//            return value * directConversionFactor.toBigDecimal()
//        }
//
//        for (commonUnit in units) {
//            val factor1 = conversionFactors[fromUnit]?.get(commonUnit)
//            val factor2 = conversionFactors[toUnit]?.get(commonUnit)
//
//            if (factor1 != null && factor2 != null) {
//                return value * (factor1.toBigDecimal() / factor2.toBigDecimal())
//            }
//        }
//
//        return BigDecimal.ZERO
//    }
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



//}

//true2
//package com.example.mad_assignment
//
//import android.os.Bundle
//import android.view.View
//import android.widget.AdapterView
//import android.widget.ArrayAdapter
//import android.widget.EditText
//import android.widget.Spinner
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var editTextValue: EditText
//    private lateinit var spinnerFrom: Spinner
//    private lateinit var spinnerTo: Spinner
//    private lateinit var textViewResult: TextView
//
//    private val units = listOf(
//        "Meter", "Centimeter", "Inch", "Foot", "Yard", "Kilometer", "Gram", "Kilogram", "Pound"
//        // Add more units here
//    )
//
//    // Define conversion factors between units
//    private val conversionFactors: Map<Pair<String, String>, Double> = mapOf(
//        Pair("Meter", "Centimeter") to 100.0,
//        Pair("Centimeter", "Inch") to 0.393701,
//        Pair("Inch", "Foot") to 1.0 / 12.0,
//        Pair("Foot", "Yard") to 1.0 / 3.0,
//        Pair("Yard", "Meter") to 0.9144,
//        Pair("Meter", "Kilometer") to 0.001,
//        Pair("Gram", "Kilogram") to 0.001,
//        Pair("Kilogram", "Pound") to 2.20462
//        // Add more unit conversions here
//    )
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
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
//
////        findViewById<View>(R.id.buttonConvert).setOnClickListener {
////            convertUnit()
////        }
//    }
//
//    private fun convertUnit() {
//        val fromUnit = spinnerFrom.selectedItem.toString()
//        val toUnit = spinnerTo.selectedItem.toString()
//
//        if (editTextValue.text.isNotEmpty()) {
//            val inputValue = editTextValue.text.toString().toDouble()
//            val result = performConversion(fromUnit, toUnit, inputValue)
//            textViewResult.text = "Result: $result $toUnit"
//        } else {
//            textViewResult.text = "Result: "
//        }
//    }
//
//    private fun performConversion(fromUnit: String, toUnit: String, value: Double): Double {
//        if (fromUnit == toUnit) {
//            return value
//        }
//
//        // Check if a direct conversion factor exists
//        val directConversionFactor = conversionFactors[Pair(fromUnit, toUnit)]
//        if (directConversionFactor != null) {
//            return value * directConversionFactor
//        }
//
//        // Check for indirect conversion via a common unit
//        for (commonUnit in units) {
//            val factor1 = conversionFactors[Pair(fromUnit, commonUnit)]
//            val factor2 = conversionFactors[Pair(toUnit, commonUnit)]
//
//            if (factor1 != null && factor2 != null) {
//                return value * (factor1 / factor2)
//            }
//        }
//
//
//        return 0.0
//    }
//}
//true
//package com.example.mad_assignment
//import android.os.Bundle
//import android.view.View
//import android.widget.AdapterView
//import android.widget.ArrayAdapter
//import android.widget.EditText
//import android.widget.Spinner
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var editTextValue: EditText
//    private lateinit var spinnerFrom: Spinner
//    private lateinit var spinnerTo: Spinner
//    private lateinit var textViewResult: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        editTextValue = findViewById(R.id.editTextValue)
//        spinnerFrom = findViewById(R.id.spinnerFrom)
//        spinnerTo = findViewById(R.id.spinnerTo)
//        textViewResult = findViewById(R.id.textViewResult)
//
//        val lengthUnits = arrayOf("Meter", "Centimeter", "Inch", "Foot", "Yard", "Kilometer")
//
//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lengthUnits)
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
//
//        findViewById<View>(R.id.buttonConvert).setOnClickListener {
//            convertUnit()
//        }
//    }
//
//    private fun convertUnit() {
//        val fromUnit = spinnerFrom.selectedItem.toString()
//        val toUnit = spinnerTo.selectedItem.toString()
//
//        if (editTextValue.text.isNotEmpty()) {
//            val inputValue = editTextValue.text.toString().toDouble()
//            val result = performConversion(fromUnit, toUnit, inputValue)
//            textViewResult.text = "Result: $result $toUnit"
//        } else {
//            textViewResult.text = "Result: "
//        }
//    }
//
//    private fun performConversion(fromUnit: String, toUnit: String, value: Double): Double {
//        val conversionFactors = mapOf(
//            "Meter" to 1.0,
//            "Centimeter" to 100.0,
//            "Inch" to 39.3701,
//            "Foot" to 3.28084,
//            "Yard" to 1.09361,
//            "Kilometer" to 0.001
//        )
//
//        if (conversionFactors.containsKey(fromUnit) && conversionFactors.containsKey(toUnit)) {
//            val fromFactor = conversionFactors[fromUnit] ?: 1.0
//            val toFactor = conversionFactors[toUnit] ?: 1.0
//
//            return value * fromFactor / toFactor
//        }
//
//        return 0.0 // Default to 0 if units are not recognized
//    }
//}












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
//        return conversionFactor.toDouble() * inputValue.toDouble()
//
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