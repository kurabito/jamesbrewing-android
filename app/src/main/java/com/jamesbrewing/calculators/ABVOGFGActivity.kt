package com.jamesbrewing.calculators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

class ABVOGFGActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abvogfg)

        displayABV()

        val ogText = findViewById<EditText>(R.id.editTextNumberOG)
        ogText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                displayABV()
            }
        })

        val fgText = findViewById<EditText>(R.id.editTextNumberFG)
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
        val ogText = findViewById<EditText>(R.id.editTextNumberOG)
        val og = ogText.text.toString().toDouble()
        val fgText = findViewById<EditText>(R.id.editTextNumberFG)
        val fg = fgText.text.toString().toDouble()
        findViewById<TextView>(R.id.textViewABV).apply {
            text = abv(og, fg)
        }
    }
}

