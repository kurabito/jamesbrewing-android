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

class ABVOGFGActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abvogfgactivity)

        displayABV()

        val ogText = findViewById<EditText>(R.id.editTextNumberDecimal)
        ogText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
//                tvSample.setText("Text in EditText : "+s)
                displayABV()
            }
        })

        val fgText = findViewById<EditText>(R.id.editTextNumberDecimal3)
        fgText.addTextChangedListener(object : TextWatcher {

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

    private fun abv(og: Double, fg: Double): String {
        return String.format("%.1f", 100 * (og - fg) / 0.75)
    }

    private fun displayABV() {
        val ogText = findViewById<EditText>(R.id.editTextNumberDecimal)
        val og = ogText.text.toString().toDouble()
        val fgText = findViewById<EditText>(R.id.editTextNumberDecimal3)
        val fg = fgText.text.toString().toDouble()
        findViewById<TextView>(R.id.textView6).apply {
            text = getString(R.string.result) + abv(og, fg) + "%"
        }
    }
}

