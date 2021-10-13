package com.jamesbrewing.calculators

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

//const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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