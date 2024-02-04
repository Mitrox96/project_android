package fr.ugatir.cda1_android;

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import org.json.JSONObject

class ScannerQrCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val integrator = IntentIntegrator(this)
        integrator.setPrompt("Scannez le QR Code")
        integrator.setBeepEnabled(true)
        integrator.initiateScan()
    }

    fun writeSharedPref(key: String, value: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("account", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result: IntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result.contents != null) {
            val qrData = result.contents

            val json = JSONObject(qrData)

            val firstName = json.getString("firstName")
            val lastName = json.getString("lastName")
            val email = json.getString("email")
            val address = json.getString("address")
            val zipcode = json.getString("zipcode")
            val city = json.getString("city")
            val cardRef = json.getString("cardRef")

            writeSharedPref("firstName", firstName.toString())
            writeSharedPref("name", lastName.toString())
            writeSharedPref("email", email.toString())
            writeSharedPref("address", address.toString())
            writeSharedPref("postalCode", zipcode.toString())
            writeSharedPref("city", city.toString())
            writeSharedPref("fidelityCard", cardRef.toString())

            val createForm = true
            startActivity(Intent(this,AccountCreationFormActivity::class.java).putExtra("CREATE_KEY", createForm))
            finish()
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
