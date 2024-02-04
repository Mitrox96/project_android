package fr.ugatir.cda1_android

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class AccountCreationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_creation)

        val buttonScanQrCode=findViewById<Button>(R.id.buttonQrCode)
        buttonScanQrCode.setOnClickListener {
            startActivity(Intent(this,ScannerQrCodeActivity::class.java))
        }
        val createForm = true
        val buttonCreationAccount=findViewById<Button>(R.id.buttonFillOutTheFormManually)
        buttonCreationAccount.setOnClickListener {
            startActivity(Intent(this,AccountCreationFormActivity::class.java).putExtra("CREATE_KEY", createForm))
        }
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences: SharedPreferences = getSharedPreferences("account", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.remove("firstName")
        editor.remove("name")
        editor.remove("email")
        editor.remove("address")
        editor.remove("postalCode")
        editor.remove("city")
        editor.remove("fidelityCard")

        Log.d("SharedPreferences", "After removal: ${sharedPreferences.all}")
        editor.apply()

    }
}