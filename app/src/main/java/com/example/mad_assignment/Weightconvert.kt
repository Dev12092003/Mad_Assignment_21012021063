package com.example.mad_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Weightconvert : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weightconvert)

        //"Kilogram" to mapOf("Gram" to 1000.0, "Pound" to 2.20462)
        //"Gram" to mapOf("Kilogram" to 0.001, "Pound" to 0.00220462)
        //"Pound" to mapOf("Kilogram" to 0.453592, "Gram" to 453.592)
    }
}