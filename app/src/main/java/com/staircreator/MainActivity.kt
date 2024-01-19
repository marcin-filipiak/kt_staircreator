package com.staircreator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.floor
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //złapanie przycisku na interface
        val button = findViewById<Button>(R.id.button)

        //złapanie edita i viewa
        val k_x = findViewById<EditText>(R.id.x)
        val k_y = findViewById<EditText>(R.id.y)
        val k_x_st = findViewById<EditText>(R.id.x_step)
        val k_h_st = findViewById<TextView>(R.id.y_step)
        val k_st = findViewById<TextView>(R.id.steps)

        button.setOnClickListener(View.OnClickListener {
            //pobranie tekstu z edit
            var xst = k_x_st.text.toString().toDouble()
            var x = k_x.text.toString().toDouble()
            var y = k_y.text.toString().toDouble()

            if (xst == 0.0) {
                xst = 20.0
            }



            var st = 0.0
            var hst = 0.0
            var end = false


            do {
                xst += 0.001
                st = (x / xst) + 1
                st = round(st * 100.0) / 100.0
                hst = y / st
                hst = round(hst * 100.0) / 100.0

                if (xst >= x) {
                    end = true
                }
                if (floor(st) == st) {
                    if (hst <= 20 && hst >= 16) {
                        if (xst <= 30 && xst >= 25) {
                            end = true
                        }
                    }
                }


            } while (end == false)


            //ustawienie tekstu na edit
            k_x_st.setText(xst.toString())

            //ustawienie tekstu na textview
            k_h_st.setText("Step height " + hst.toString())
            k_st.setText("Steps " + st.toString())
        })


    }
}