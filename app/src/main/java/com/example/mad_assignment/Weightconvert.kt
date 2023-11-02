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

class Weightconvert : AppCompatActivity() {
    private lateinit var editTextValue: EditText
    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner
    private lateinit var textViewResult: TextView

    private val units = listOf(
        "Kilogram", "Gram", "Pound"
        // Add more weight units here
    )

    private val weightConversionFactors = mapOf(
        "Kilogram" to mapOf("Gram" to 1000.0, "Pound" to 2.20462),
        "Gram" to mapOf("Kilogram" to 0.001, "Pound" to 0.00220462),
        "Pound" to mapOf("Kilogram" to 0.453592, "Gram" to 453.592)
        // Add more weight unit conversions here
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weightconvert)
        editTextValue = findViewById(R.id.editTextValue)
        spinnerFrom = findViewById(R.id.spinnerFrom)
        spinnerTo = findViewById(R.id.spinnerTo)
        textViewResult = findViewById(R.id.textViewResult)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter

        setupListeners()

        // Trigger the initial conversion
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

        val directConversionFactor = weightConversionFactors[fromUnit]?.get(toUnit)

        if (directConversionFactor != null) {
            return value * directConversionFactor.toBigDecimal()
        }

        for (commonUnit in units) {
            val factor1 = weightConversionFactors[fromUnit]?.get(commonUnit)
            val factor2 = weightConversionFactors[toUnit]?.get(commonUnit)

            if (factor1 != null && factor2 != null) {
                return value * (factor1.toBigDecimal() / factor2.toBigDecimal())
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
//class Weightconvert : AppCompatActivity() {
//    private lateinit var editTextValue: EditText
//    private lateinit var spinnerFrom: Spinner
//    private lateinit var spinnerTo: Spinner
//    private lateinit var textViewResult: TextView
//
//    private val units = listOf(
//        "Kilogram", "Gram", "Pound"
//        // Add more weight units here
//    )
//
//    private val weightConversionFactors = mapOf(
//        "Kilogram" to mapOf("Gram" to 1000.0, "Pound" to 2.20462),
//        "Gram" to mapOf("Kilogram" to 0.001, "Pound" to 0.00220462),
//        "Pound" to mapOf("Kilogram" to 0.453592, "Gram" to 453.592)
//        // Add more weight unit conversions here
//    )
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_weightconvert)
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
//        //"Kilogram" to mapOf("Gram" to 1000.0, "Pound" to 2.20462)
//        //"Gram" to mapOf("Kilogram" to 0.001, "Pound" to 0.00220462)
//        //
//    }
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
//        val directConversionFactor = weightConversionFactors[fromUnit]?.get(toUnit)
//
//        if (directConversionFactor != null) {
//            return value * directConversionFactor.toBigDecimal()
//        }
//
//        for (commonUnit in units) {
//            val factor1 = weightConversionFactors[fromUnit]?.get(commonUnit)
//            val factor2 = weightConversionFactors[toUnit]?.get(commonUnit)
//
//            if (factor1 != null && factor2 != null) {
//                return value * (factor1.toBigDecimal() / factor2.toBigDecimal())
//            }
//        }
//
//        return BigDecimal.ZERO
//    }
//}