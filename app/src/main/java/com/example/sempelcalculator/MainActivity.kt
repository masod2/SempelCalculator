package com.example.sempelcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    lateinit var nu1ET: EditText
    lateinit var nu2ET: EditText
    lateinit var calculateButton: Button
    lateinit var resultTV: TextView
    lateinit var operation_menu: AutoCompleteTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nu1ET = findViewById(R.id.Nu_1ET)
        nu2ET = findViewById(R.id.Nu_2ET)
        calculateButton = findViewById(R.id.CalculateButton)
        resultTV = findViewById(R.id.Result_TV)
        operation_menu = findViewById(R.id.operation_menu)


        val listItem = listOf("plus", "minus", "multiplication")
        val adabter = ArrayAdapter(this, R.layout.list_item_text_view, listItem)
        operation_menu.setAdapter(adabter)

        calculateButton.setOnClickListener {

            val firstNumber = nu1ET.text.toString().toDouble()
            val SecondNumber = nu2ET.text.toString().toDouble()
            val selectionOperation = operation_menu.text.toString()


            var result = 0.0
            when (selectionOperation){
            "plus" -> { result = firstNumber.plus(SecondNumber) }
            "minus" -> { result = firstNumber.minus(SecondNumber) }
            "multiplication" -> { result = firstNumber.times(SecondNumber) }

        }
        resultTV.setText(result.toString())
    }
}
}