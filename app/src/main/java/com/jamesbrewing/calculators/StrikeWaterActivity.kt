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

    private fun strikeTemp(grain: Double, target: Double, ratio: Double): String {
        return String.format("%.1f", (0.2 / ratio * (target - grain) + target))
    }

    private fun displayTemp() {
        val grainText = findViewById<EditText>(R.id.editTextGrain)
        val grain = grainText.text.toString().toDouble()
        val targetText = findViewById<EditText>(R.id.editTextTarget)
        val target = targetText.text.toString().toDouble()
        val ratioText = findViewById<EditText>(R.id.editTextRatio)
        val ratio = ratioText.text.toString().toDouble()
        findViewById<TextView>(R.id.textViewTemp).apply {
            text = strikeTemp(grain, target, ratio)
        }
    }
}