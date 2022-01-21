package com.example.madlcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var a = 0
        val tvDisplay = findViewById<TextView>(R.id.tvCounter)

        val increment = findViewById<Button>(R.id.btnInc)
        val decrement = findViewById<Button>(R.id.btnDec)
        val progress = findViewById<com.mikhaellopez.circularprogressbar.CircularProgressBar>(R.id.circularProgressBar)

        increment.setOnClickListener {
            a++
            if(a%100==0){
                progress.progressMax = (a+100).toFloat()
            }
            tvDisplay.text = a.toString()
            progress.progress = a.toFloat()
        }

        decrement.setOnClickListener {
            if(a<=0){
                Toast.makeText(this,"You've reached the minimum threshold",Toast.LENGTH_SHORT).show()
                progress.progressMax = 100f
            }
            else {
                a--
                tvDisplay.text = a.toString()
                progress.progress = a.toFloat()
            }
        }
    }
}