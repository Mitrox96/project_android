package fr.ugatir.cda1_android

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class RollDiceActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roll_dice)
        val imageViewDice= findViewById<ImageView>(R.id.imageViewDice)
        val buttonRoll=findViewById<Button>(R.id.buttonRoll)

        buttonRoll.setOnClickListener {
            val id =when(Random.nextInt(1, 7)){
                1-> R.drawable.dice_1
                2-> R.drawable.dice_2
                3-> R.drawable.dice_3
                4-> R.drawable.dice_4
                5-> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            imageViewDice.setImageResource(id)
        }
        showBack()
        setHeaderTitle(getString(R.string.txtRoll))
    }
}