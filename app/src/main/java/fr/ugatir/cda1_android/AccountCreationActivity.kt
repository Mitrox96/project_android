package fr.ugatir.cda1_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AccountCreationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_creation)

        val buttonCreationAccount=findViewById<Button>(R.id.buttonFillOutTheFormManually)
        buttonCreationAccount.setOnClickListener {
            startActivity(Intent(this,AccountCreationFormActivity::class.java))
        }

    }
}