package com.jamesbrewing.calculators

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.NumberPicker
import android.widget.TextView
import kotlin.math.round

class ABVSGBrixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abvsgbrix)

        displayABV()

        val sgText = findViewById<EditText>(R.id.editTextSG)
        sgText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                displayABV()
            }
        })

        val brixText = findViewById<EditText>(R.id.editTextBrix)
        brixText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                displayABV()
            }
        })
    }

    private fun abv(sg: Double, brix: Double): String {
        return String.format("%.1f", (1.646 * brix - 2.703 * (145-145/sg) - 1.794))
    }

    private fun displayABV() {
        val sgText = findViewById<EditText>(R.id.editTextSG)
        val sg = sgText.text.toString().toDouble()
        val brixText = findViewById<EditText>(R.id.editTextBrix)
        val brix = brixText.text.toString().toDouble()
        findViewById<TextView>(R.id.textViewABV).apply {
            text = abv(sg, brix)
        }
    }
}