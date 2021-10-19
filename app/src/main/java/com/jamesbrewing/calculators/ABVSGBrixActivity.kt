package com.jamesbrewing.calculators

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.NumberPicker
import android.widget.TextView
import kotlin.math.round

private var defaultColors = ColorStateList.valueOf(Color.BLACK)

class ABVSGBrixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abvsgbrix)

        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.app_name)
        actionBar.setDisplayHomeAsUpEnabled(true)

        val result = findViewById<TextView>(R.id.textViewResult)
        defaultColors = result.textColors

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun invalidInput(result: TextView, abv: TextView, message: String) {
        result.text = message
        result.setTextColor(Color.RED)
        abv.visibility = View.GONE
    }

    private fun abv(sg: Double, brix: Double): String {
        return String.format("%.1f", (1.646 * brix - 2.703 * (145-145/sg) - 1.794))
    }

    private fun displayABV() {
        val result = findViewById<TextView>(R.id.textViewResult)
        val abv = findViewById<TextView>(R.id.textViewABV)

        val sgText = findViewById<EditText>(R.id.editTextSG)
        val sg : Double =
            try {
                sgText.text.toString().toDouble()
            }
            catch (e: NumberFormatException) {
                invalidInput(result, abv, getString(R.string.sg_invalid))
                return
            }
        if (sg == 0.0)
        {
            invalidInput(result, abv, getString(R.string.sg_invalid))
            return
        }
        else {}

        val brixText = findViewById<EditText>(R.id.editTextBrix)
        val brix : Double =
            try {
                brixText.text.toString().toDouble()
            }
            catch (e: NumberFormatException) {
                invalidInput(result, abv, getString(R.string.brix_invalid))
                return
            }

        result.text = getString(R.string.abv)
        result.setTextColor(defaultColors)
        abv.text = abv(sg, brix) + getString(R.string.percent)
        abv.visibility = View.VISIBLE
    }

}