package com.example.bmicalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {

            if (weight.text.toString().trim().isEmpty() || height.text.toString().trim()
                    .isEmpty()
            ) {
                Toast.makeText(
                    applicationContext,
                    "Enter your Weight and Height",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                // We'll take height as an input and convert it in metres
                var h: Double = height.text.toString().toDouble() / 100
                // We'll take weight as an input in Kgs and convert to float
                var w: Double = weight.text.toString().toDouble()
                // formula to calculate BMI
                var res: Double = w / (h * h)
                // We'll output the result upto two decimal places only
                result.text = "%.2f".format(res) + "\nYou are " + BmiRes(res)
                // i want to print the above info in my Log
                Log.i("message", "+++Height is ${h}, Weight is ${w},BMI is${result.text}")  // 1) Concept of Kotlin :- String templates
            }
        }
    }

    fun BmiRes(res: Double): String {  //  2) Concept of Kotlin :- Named Parameters
        var ans = ""
        when (res) {  // 3) Concept of Kotlin :- Conditional statements(when)
            in 1..18.4.toInt() -> ans = "Underweight"
            in 18.5.toInt()..24.8.toInt() -> ans = "Normal"
            in 25..29.9.toInt() -> ans = "Overweight"
            else -> ans = "Obese"
        }
        return ans
    }

}
