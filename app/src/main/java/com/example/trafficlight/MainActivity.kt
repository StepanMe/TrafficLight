package com.example.trafficlight

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {

    var redLight: Button? = null
    var yellowLight: Button? = null
    var greenLight: Button? = null
    var startButton: Button? = null

    var lightStep: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redLight = findViewById<Button>(R.id.button)
        yellowLight = findViewById<Button>(R.id.button2)
        greenLight = findViewById<Button>(R.id.button3)
        startButton = findViewById<Button>(R.id.button4)
    }

    fun startButtonPressed(view: View) {
        when (lightStep) {
            0 -> {
                greenLight?.setBackgroundResource(R.color.colorGreen)
                lightStep++
                return
            }
            1 -> {
                yellowLight?.setBackgroundResource(R.color.colorYellow)
                lightStep = lightStep + 1
                return
            }
            2 -> {
                redLight?.setBackgroundResource(R.color.colorRed)
                lightStep = lightStep + 1
                return
            }
            else -> {
                greenLight?.setBackgroundResource(R.color.colorOff)
                yellowLight?.setBackgroundResource(R.color.colorOff)
                redLight?.setBackgroundResource(R.color.colorOff)
                lightStep = 0
            }
        }

    }
}
