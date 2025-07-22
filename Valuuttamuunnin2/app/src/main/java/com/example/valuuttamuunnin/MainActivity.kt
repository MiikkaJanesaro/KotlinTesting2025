package com.example.valuuttamuunnin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var btnUSD : Button
    lateinit var btnSEK : Button
    lateinit var btnGBP : Button
    lateinit var editText: EditText
    lateinit var resultOutput: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnUSD= findViewById(R.id.btn_usd)
        btnSEK= findViewById(R.id.btn_sek)
        btnGBP= findViewById(R.id.btn_gbp)
        editText = findViewById(R.id.ed_a)
        resultOutput = findViewById(R.id.result_tv)

        btnUSD.setOnClickListener(this)
        btnSEK.setOnClickListener(this)
        btnGBP.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        val input = editText.text.toString()

        if (input.isBlank()) {
            resultOutput.text = "Please enter a number"
            return
        }

        if (input.isBlank()) {
            resultOutput.text = "Please enter a number"
            return
        }

        val a = input.toDoubleOrNull()
        if (a == null) {
            resultOutput.text = "Invalid number format"
            return
        }

        var result = 0.0
        var currency = 0
        var currencyLabel = ""
        when(v?.id){
            R.id.btn_usd -> {
                result = a*1.11
                currency = 1
                currencyLabel = "$"
            }
            R.id.btn_sek -> {
                result = a*10.89
                currency = 2
                currencyLabel = "kr"
            }
            R.id.btn_gbp -> {
                result = a*0.84
                currency = 3
                currencyLabel = "£"
            }
        }
        val formattedResult = String.format("%.2f", result)
        resultOutput.text = "Result is $formattedResult $currencyLabel"
    }
}