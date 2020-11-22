package com.amaljoe.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
/**
* This activity displays the result on the screen
* and rolls the dice
**/
class MainActivity : AppCompatActivity() {
    // Create an object for dice
    private var dice: Dice = Dice(6)
    private lateinit var result: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        result = findViewById(R.id.imageView)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    // Function which rolls the dice
    private fun rollDice() {
        val num = dice.roll()
        val diceImage = when (num) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        result.setImageResource(diceImage)
        result.contentDescription = num.toString()
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