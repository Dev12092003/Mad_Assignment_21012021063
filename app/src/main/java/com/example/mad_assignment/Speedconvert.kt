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

class Speedconvert : AppCompatActivity() {
    private lateinit var editTextValue: EditText
    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner
    private lateinit var textViewResult: TextView

    private val units = listOf(
        "Meters/Second", "Kilometers/Hour", "Miles/Hour", "Feet/Second"
        // Add more speed units here
    )

    private val speedConversionFactors = mapOf(
        "Meters/Second" to mapOf(
            "Kilometers/Hour" to 3.6, "Miles/Hour" to 2.23694, "Feet/Second" to 3.28084
        ),
        "Kilometers/Hour" to mapOf(
            "Meters/Second" to 0.277778, "Miles/Hour" to 0.621371, "Feet/Second" to 0.911344
        ),
        "Miles/Hour" to mapOf(
            "Meters/Second" to 0.44704, "Kilometers/Hour" to 1.60934, "Feet/Second" to 1.46667
        ),
        "Feet/Second" to mapOf(
            "Meters/Second" to 0.3048, "Kilometers/Hour" to 1.09728, "Miles/Hour" to 0.681818
        )
        // Add more speed unit conversions here
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speedconvert)
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
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setupListeners() {
        // Add a TextWatcher to the EditText to listen for text changes
        editTextValue.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Trigger the unit conversion when text changes
                convertUnit()
            }

            override fun afterTextChanged(s: Editable?) {
                // Do nothing
            }
        })

        spinnerFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Trigger the unit conversion when the spinner selection changes
                convertUnit()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        spinnerTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Trigger the unit conversion when the spinner selection changes
                convertUnit()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }

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

        val directConversionFactor = speedConversionFactors[fromUnit]?.get(toUnit)

        if (directConversionFactor != null) {
            return value * BigDecimal(directConversionFactor.toString())
        }

        for (commonUnit in units) {
            val factor1 = speedConversionFactors[fromUnit]?.get(commonUnit)
            val factor2 = speedConversionFactors[toUnit]?.get(commonUnit)

            if (factor1 != null && factor2 != null) {
                return value * BigDecimal(factor1.toString()) / BigDecimal(factor2.toString())
            }
        }

        return BigDecimal.ZERO
    }
}



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
//class SpeedConvert : AppCompatActivity() {
//
//    private lateinit var editTextValue: EditText
//    private lateinit var spinnerFrom: Spinner
//    private lateinit var spinnerTo: Spinner
//    private lateinit var textViewResult: TextView
//
//    private val units = listOf(
//        "Meters/Second", "Kilometers/Hour", "Miles/Hour", "Feet/Second"
//        // Add more speed units here
//    )
//
//    private val speedConversionFactors = mapOf(
//        "Meters/Second" to mapOf(
//            "Kilometers/Hour" to 3.6, "Miles/Hour" to 2.23694, "Feet/Second" to 3.28084
//        ),
//        "Kilometers/Hour" to mapOf(
//            "Meters/Second" to 0.277778, "Miles/Hour" to 0.621371, "Feet/Second" to 0.911344
//        ),
//        "Miles/Hour" to mapOf(
//            "Meters/Second" to 0.44704, "Kilometers/Hour" to 1.60934, "Feet/Second" to 1.46667
//        ),
//        "Feet/Second" to mapOf(
//            "Meters/Second" to 0.3048, "Kilometers/Hour" to 1.09728, "Miles/Hour" to 0.681818
//        )
//        // Add more speed unit conversions here
//    )
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_speed_convert)
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
//        val directConversionFactor = speedConversionFactors[fromUnit]?.get(toUnit)
//
//        if (directConversionFactor != null) {
//            return value * directConversionFactor.toBigDecimal()
//        }
//
//        for (commonUnit in units) {
//            val factor1 = speedConversionFactors[fromUnit]?.get(commonUnit)
//            val factor2 = speedConversionFactors[toUnit]?.get(commonUnit)
//
//            if (factor1 != null && factor2 != null) {
//                return value * (factor1.toBigDecimal() / factor2.toBigDecimal())
//            }
//        }
//
//        return BigDecimal.ZERO
//    }
//}