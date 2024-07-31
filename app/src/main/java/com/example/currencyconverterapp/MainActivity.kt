package com.example.currencyconverterapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.nio.channels.FileChannel.MapMode

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var egyptianPound: String = "Egyptian Pound"
    private var americanDollar: String = "American Dollar"
    private var AED: String = "AED "
    private var GBP: String = "GBP"
    private var values = mapOf(
        americanDollar to 1.0,
        egyptianPound to 48.33,
        AED to 3.67,
        GBP to 0.78
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

        //دي function اللي بتعمل اكشن لل bottom وبعمل فيها كل حاجه عايز ال bottom يعملها //

        convertBtn.setOnClickListener {

            //  بياخد القيمه من amountET بواسطه كلمه .text

           // val amount = amountEt.text.toString().toDouble()



            try {
                var amount = amountEt.text.toString().toDouble()

                var toValue = values[toDropDownMenu.text.toString()]

                var fromValue  = values[fromDropDownMenu.text.toString()]
                var result = amount.times(toValue!!.div(fromValue!!))
                resultTv.setText(result.toString())
            }catch (ex:Exception)
            {
                Toast.makeText(this, "please select currency in from and to field", Toast.LENGTH_SHORT).show()
            }


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
    }

    private fun popDropDownMenu() {
        val listOfCountry = listOf(egyptianPound, americanDollar, AED, GBP)
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



