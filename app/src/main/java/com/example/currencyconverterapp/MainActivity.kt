package com.example.currencyconverterapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import java.nio.channels.FileChannel.MapMode

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var egyptianPound: String = "Egyptian Pound"
    private var americanDollar: String = "American Dollar"
    private var AED: String = "AED "
    private var GBP: String = "GBP"
    private var Euro: String = "Euro"
    private var values = mapOf(
        americanDollar to 1.0,
        egyptianPound to 48.33,
        AED to 3.67,
        GBP to 0.78,
        Euro to 0.92
    )
    private lateinit var toDropDownMenu: AutoCompleteTextView
    private lateinit var fromDropDownMenu: AutoCompleteTextView
    private lateinit var convertBtn: Button
    private lateinit var amountEt: TextInputEditText
    private lateinit var resultTv: TextInputEditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //  var convertBtn1 = findViewById<Button>(R.id.convert_button)
        initializeViews()
        popDropDownMenu()

     amountEt.addTextChangedListener {
       calculateResult()
     }
        fromDropDownMenu.setOnItemClickListener{ adapterView, view, i, l ->
            calculateResult()
        }
        toDropDownMenu.setOnItemClickListener{ adapterView, view, i, l ->
            calculateResult()
        }


        /*
        convertBtn.setOnClickListener {

            //  بياخد القيمه من amountET بواسطه كلمه .text

            // val amount = amountEt.text.toString().toDouble()





            //        دا اللي بياخد القيمه من edit text بتاع  to
            val currencyToField = toDropDownMenu.text.toString()

            //    دا اللي بياخد القيمه من edit text بتاع  from
            val currencyFromField = fromDropDownMenu.text.toString()


            /* These are the currency rates for the year 2024, July */

//            var resultAmount = when (currencyToField) {
//                egyptianPound -> amount.times(48.33)
//                AED -> amount.times(13.16)
//                GBP -> amount.times(62.21)
//                else -> amount.times(1)
//            }


            // بيحط القيمه في EditTv بتاع result  بواسطه كلمه setText

            // resultTv.setText(resultAmount.toString())
        }
         */

    }

    private fun calculateResult() {
        if (amountEt.text.toString().isNotEmpty()) {
            var amount = amountEt.text.toString().toDouble()

            var toValue = values[toDropDownMenu.text.toString()]

            var fromValue = values[fromDropDownMenu.text.toString()]
            var result = amount.times(toValue!!.div(fromValue!!))
            var resultFormat = String.format("%.3f", result)
            resultTv.setText(resultFormat)
        } else {
            amountEt.error = "amount filed required"
        }
    }

    private fun popDropDownMenu() {
        val listOfCountry = listOf(egyptianPound, americanDollar, AED, GBP, Euro)
        val adapter = ArrayAdapter(this, R.layout.drop_down_list_item, listOfCountry)
        toDropDownMenu.setAdapter(adapter)
        fromDropDownMenu.setAdapter(adapter)

    }

    private fun initializeViews() {
        convertBtn = findViewById(R.id.convert_button)
        amountEt = findViewById(R.id.amount_et)
        resultTv = findViewById(R.id.result_et)
        toDropDownMenu = findViewById(R.id.autoComplete_tv2)
        fromDropDownMenu = findViewById(R.id.autoComplete_tv)
    }


}



