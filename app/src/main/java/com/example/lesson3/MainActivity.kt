package com.example.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    //var for calculation
    var amount = 0.0
    var tipPercent = 0.15
    var tip = 0.0
    var total = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //When amount is changed
        editTextAmount.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                amount = if(editTextAmount.text.isNotEmpty()) editTextAmount.text.toString().toDouble() else 0.0

                calculate()
            }

            override fun afterTextChanged(s: Editable?) {
//                TODO("Not yet implemented")
            }

        })

        // when tip % is changed
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, p1: Int, p2: Boolean) {
                if (editTextAmount.text.isEmpty()){
                    return
                }
                textViewTipPercent.setText(p1.toString() + '%')
                tipPercent = (p1/ 100.00)
                calculate()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

        })
    }

    fun calculate() {
        //calc e display total amounts
        tip = amount * tipPercent
        total = amount + tip

        val currencyFormat = NumberFormat.getCurrencyInstance()


        //Display in the text view
        textViewTipAmount.setText(currencyFormat.format(tip).toString())
        textViewTotalAmount.setText(currencyFormat.format(total).toString())

    }


}