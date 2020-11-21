package com.amaljoe.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
/**
* This activity displays the result on the screen
* and rolls the dice
**/
class MainActivity : AppCompatActivity() {
    // Create an object for dice
    private var dice: Dice = Dice(6)
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        result = findViewById(R.id.textView)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    // Function which rolls the dice
    private fun rollDice() {
        result.text = dice.roll().toString()
    }
}

/**
 * This class has all the logic for rolling the dice
 * and stores the number of sides in it
 **/
class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}