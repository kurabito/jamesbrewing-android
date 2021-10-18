package com.jamesbrewing.calculators

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.NumberPicker
import android.widget.TextView
import kotlin.math.round

class StrikeWaterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strike_water)

        displayTemp()

        val grainText = findViewById<EditText>(R.id.editTextGrain)
        grainText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                displayTemp()
            }
        })

        val targetText = findViewById<EditText>(R.id.editTextTarget)
        targetText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                displayTemp()
            }
        })

        val ratioText = findViewById<EditText>(R.id.editTextRatio)
        ratioText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                displayTemp()
            }
        })
    }

    private fun invalidInput(result: TextView, temp: TextView, message: String) {
        result.text = message
        temp.visibility = View.GONE
    }

    private fun strikeTemp(grain: Double, target: Double, ratio: Double): String {
        return String.format("%.1f", (0.2 / ratio * (target - grain) + target))
    }

    private fun displayTemp() {
        val result = findViewById<TextView>(R.id.textViewResult)
        val temp = findViewById<TextView>(R.id.textViewTemp)

        val grainText = findViewById<EditText>(R.id.editTextGrain)
        val grain : Double =
            try {
                grainText.text.toString().toDouble()
            }
            catch (e: NumberFormatException) {
                invalidInput(result, temp, getString(R.string.grain_invalid))
                return
            }

        val targetText = findViewById<EditText>(R.id.editTextTarget)
        val target : Double =
            try {
                targetText.text.toString().toDouble()
            }
            catch (e: NumberFormatException) {
                invalidInput(result, temp, getString(R.string.target_invalid))
                return
            }

        val ratioText = findViewById<EditText>(R.id.editTextRatio)
        val ratio : Double =
            try {
                ratioText.text.toString().toDouble()
            }
            catch (e: NumberFormatException) {
                invalidInput(result, temp, getString(R.string.ratio_invalid))
                return
            }
        if (ratio == 0.0)
        {
            invalidInput(result, temp, getString(R.string.ratio_invalid))
            return
        }
        else {}

        result.text = getString(R.string.strike_temp)
        temp.text = strikeTemp(grain, target, ratio)
        temp.visibility = View.VISIBLE
    }
}