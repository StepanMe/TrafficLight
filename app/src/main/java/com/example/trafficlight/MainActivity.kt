package com.example.trafficlight

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {

    //These variables would be buttons
    //Эти переменные станут кнопками
    var redLight: Button? = null
    var yellowLight: Button? = null
    var greenLight: Button? = null
    var startButton: Button? = null

    //lightStep variable initialisation (current "step"/light)
    //Инициализируем переменную lightStep (текущий режим светофора)
    var lightStep: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variables initialisation (assign real buttons to variables)
        //Инициализируем переменные (привязываем реальные кнопки к переменным)
        redLight = findViewById<Button>(R.id.button)
        yellowLight = findViewById<Button>(R.id.button2)
        greenLight = findViewById<Button>(R.id.button3)
        startButton = findViewById<Button>(R.id.button4)
    }

    fun startButtonPressed(view: View) {
        //Every time button pressed, we check the value i.e. current step of traffic light and...
        //При каждом нажатии кнопки определяем режим работы светофора. И...
        when (lightStep) {
            //... if all lights are off: switch the GREEN light on, increase lightStep variable
            //... если светофор выключен: включаем зелёный свет, увеличиваем значение переменной lightStep
            0 -> {
                greenLight?.setBackgroundResource(R.color.colorGreen)
                lightStep++
                return
            }
            //... if GREEN light is already ON: switch the YELLOW light on, increase lightStep variable
            //... если уже горит зелёный: включаем жёлтый, увеличиваем значение переменной lightStep
            1 -> {
                yellowLight?.setBackgroundResource(R.color.colorYellow)
                lightStep += 1
                return
            }
            //... if GREEN & YELLOW lights are already ON: switch the RED light on, increase lightStep variable
            //... если уже горят зелёный и жёлтый: включаем красный, увеличиваем значение переменной lightStep
            2 -> {
                redLight?.setBackgroundResource(R.color.colorRed)
                lightStep += 1
                return
            }
            //... if all lights are already ON: switch them off, reset lightStep variable value to 0
            //... если горят все сигналы светофора: выключаем его, сбрасываем значение переменной lightStep на 0
            else -> {
                greenLight?.setBackgroundResource(R.color.colorOff)
                yellowLight?.setBackgroundResource(R.color.colorOff)
                redLight?.setBackgroundResource(R.color.colorOff)
                lightStep = 0
            }
        }

    }
}
