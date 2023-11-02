package com.example.mad_assignment

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Intent
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
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class Volumeconvert : AppCompatActivity() {
    private lateinit var editTextValue: EditText
    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner
    private lateinit var textViewResult: TextView

    private val units = listOf(
        "Liter", "Milliliter", "Cubic Inch", "Cubic Foot", "Gallon (US)"
        // Add more volume units here
    )

    private val volumeConversionFactors = mapOf(
        "Liter" to mapOf("Milliliter" to 1000.0, "Cubic Inch" to 61.0237, "Cubic Foot" to 0.0353147, "Gallon (US)" to 0.264172),
        "Milliliter" to mapOf("Liter" to 0.001, "Cubic Inch" to 0.0610237, "Cubic Foot" to 0.0000353147, "Gallon (US)" to 0.000264172),
        "Cubic Inch" to mapOf("Liter" to 0.0163871, "Milliliter" to 16.3871, "Cubic Foot" to 0.000578704, "Gallon (US)" to 0.004329),
        "Cubic Foot" to mapOf("Liter" to 28.3168, "Milliliter" to 28316.8, "Cubic Inch" to 1728.0, "Gallon (US)" to 7.48052),
        "Gallon (US)" to mapOf("Liter" to 3.78541, "Milliliter" to 3785.41, "Cubic Inch" to 231.0, "Cubic Foot" to 0.133681)
        // Add more volume unit conversions here
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volumeconvert)
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
        val back=findViewById<FloatingActionButton>(R.id.gotoh)
        back.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
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

    private fun performConversion(fromUnit: String, toUnit: String, value: BigDecimal): BigDecimal {
        if (fromUnit == toUnit) {
            return value
        }

        val directConversionFactor = volumeConversionFactors[fromUnit]?.get(toUnit)

        if (directConversionFactor != null) {
            return value * directConversionFactor.toBigDecimal()
        }

        for (commonUnit in units) {
            val factor1 = volumeConversionFactors[fromUnit]?.get(commonUnit)
            val factor2 = volumeConversionFactors[toUnit]?.get(commonUnit)

            if (factor1 != null && factor2 != null) {
                return value * (factor1.toBigDecimal() / factor2.toBigDecimal())
            }
        }

        return BigDecimal.ZERO
    }
}


//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.view.View
//import android.widget.AdapterView
//import android.widget.ArrayAdapter
//import android.widget.EditText
//import android.widget.Spinner
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import java.math.BigDecimal
//
//class VolumeConvert : AppCompatActivity() {
//
//    private lateinit var editTextValue: EditText
//    private lateinit var spinnerFrom: Spinner
//    private lateinit var spinnerTo: Spinner
//    private lateinit var textViewResult: TextView
//
//    private val units = listOf(
//        "Liter", "Milliliter", "Cubic Inch", "Cubic Foot", "Gallon (US)"
//        // Add more volume units here
//    )
//
//    private val volumeConversionFactors = mapOf(
//        "Liter" to mapOf("Milliliter" to 1000.0, "Cubic Inch" to 61.0237, "Cubic Foot" to 0.0353147, "Gallon (US)" to 0.264172),
//        "Milliliter" to mapOf("Liter" to 0.001, "Cubic Inch" to 0.0610237, "Cubic Foot" to 0.0000353147, "Gallon (US)" to 0.000264172),
//        "Cubic Inch" to mapOf("Liter" to 0.0163871, "Milliliter" to 16.3871, "Cubic Foot" to 0.000578704, "Gallon (US)" to 0.004329),
//        "Cubic Foot" to mapOf("Liter" to 28.3168, "Milliliter" to 28316.8, "Cubic Inch" to 1728.0, "Gallon (US)" to 7.48052),
//        "Gallon (US)" to mapOf("Liter" to 3.78541, "Milliliter" to 3785.41, "Cubic Inch" to 231.0, "Cubic Foot" to 0.133681)
//        // Add more volume unit conversions here
//    )
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_volume_convert)
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
//        val directConversionFactor = volumeConversionFactors[fromUnit]?.get(toUnit)
//
//        if (directConversionFactor != null) {
//            return value * directConversionFactor.toBigDecimal()
//        }
//
//        for (commonUnit in units) {
//            val factor1 = volumeConversionFactors[fromUnit]?.get(commonUnit)
//            val factor2 = volumeConversionFactors[toUnit]?.get(commonUnit)
//
//            if (factor1 != null && factor2 != null) {
//                return value * (factor1.toBigDecimal() / factor2.toBigDecimal())
//            }
//        }
//
//        return BigDecimal.ZERO
//    }
//}