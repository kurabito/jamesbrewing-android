package com.jamesbrewing.calculators

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText

//const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ogfgButton: Button = findViewById(R.id.buttonOGFG)
        ogfgButton.setOnClickListener {
            calcABVOGFG(ogfgButton)
        }

        val sgBrixButton: Button = findViewById(R.id.buttonSGBrix)
        sgBrixButton.setOnClickListener {
            calcABVOGFG(sgBrixButton)
        }
    }

    fun calcABVOGFG(view: View) {
//        val message = "message"
//        val intent = Intent(this, ABVOGFGActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, message)
//        }
//    fun calcABVOGFG() {
        val intent = Intent(this, ABVOGFGActivity::class.java).apply {
        }
        startActivity(intent)
    }

    fun calcABVSGBrix(view: View) {
        val intent = Intent(this, ABVSGBrixActivity::class.java).apply {
        }
        startActivity(intent)
    }
}