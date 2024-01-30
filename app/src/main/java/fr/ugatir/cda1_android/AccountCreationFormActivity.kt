package fr.ugatir.cda1_android

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AccountCreationFormActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        setHeaderTitle(getString(R.string.txtCreate))
        showBack()

        val edEmail = findViewById<EditText>(R.id.editTextEmail)
        val edNom = findViewById<EditText>(R.id.editTextName)
        val edAdrees = findViewById<EditText>(R.id.editTextAddress)

        edEmail.setText(readSharedPref("email"))
        edNom.setText(readSharedPref("nom"))
        edAdrees.setText(readSharedPref("address"))

        val buttonCreate = findViewById<Button>(R.id.buttonCreate)

        buttonCreate.setOnClickListener {
            writeSharedPref("email", edEmail.text.toString())
            writeSharedPref("nom", edNom.text.toString())
            writeSharedPref("address", edAdrees.text.toString())

            // Ajoutez ici le code pour traiter la création du compte
            // par exemple, vous pourriez appeler une fonction pour envoyer les données à votre backend
        }
    }

    fun writeSharedPref(key: String, value: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("account", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun readSharedPref(key: String): String {
        val sharedPreferences: SharedPreferences = getSharedPreferences("account", Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, "").toString()
    }
}
