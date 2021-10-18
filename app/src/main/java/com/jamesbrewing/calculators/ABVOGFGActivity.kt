package com.jamesbrewing.calculators

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.isDigitsOnly

private var defaultColors = ColorStateList.valueOf(Color.BLACK)

class ABVOGFGActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abvogfg)

        val result = findViewById<TextView>(R.id.textViewResult)
        defaultColors = result.textColors

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

//    private fun String.isDigitsOnly() = all(Char::isDigit) && isNotEmpty()

    private fun invalidInput(result: TextView, abv: TextView, message: String) {
        result.text = message
        result.setTextColor(Color.RED)
        abv.visibility = View.GONE
    }

    private fun abv(og: Double, fg: Double): String {
        return String.format("%.1f", 100 * (og - fg) / 0.75)
    }

    private fun displayABV() {
        val result = findViewById<TextView>(R.id.textViewResult)
        val abv = findViewById<TextView>(R.id.textViewABV)

        val ogText = findViewById<EditText>(R.id.editTextNumberOG)
        val og : Double =
        try {
            ogText.text.toString().toDouble()
        }
        catch (e: NumberFormatException) {
            invalidInput(result, abv, getString(R.string.og_invalid))
            return
        }

        val fgText = findViewById<EditText>(R.id.editTextNumberFG)
        val fg : Double =
        try {
            fgText.text.toString().toDouble()
        }
        catch (e: NumberFormatException) {
            invalidInput(result, abv, getString(R.string.fg_invalid))
            return
        }

        result.text = getString(R.string.abv)
        result.setTextColor(defaultColors)
        abv.text = abv(og, fg) + getString(R.string.percent)
        abv.visibility = View.VISIBLE
    }
}