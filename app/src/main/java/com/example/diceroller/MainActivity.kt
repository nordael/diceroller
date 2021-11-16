package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //the line below shows the content of the layout content described in activity_mani.xml
        //in layout folder under ./res directory
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById<Button>(R.id.roll_button)
        rollButton.text = "Let's roll it!"
        rollButton.setOnClickListener{
            rollDice();
        }
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6) + 1
        val resultText: TextView = findViewById<TextView>(R.id.result_text)
        resultText.text = "Dice Rolled: " + randomInt.toString()
    }
}