package fr.ugatir.cda1_android

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class AccountCreationFormActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_creation_form)
        val receivedBooleanCreateAccountForm = intent.getBooleanExtra("CREATE_KEY", false)

        val imageViewSettings = findViewById<ImageView>(R.id.imageViewSettings)
        imageViewSettings.visibility = View.INVISIBLE

        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        val buttonSaveModifications = findViewById<Button>(R.id.buttonCreateAccount)
        textViewTitle.text = "Création de compte"
        setHeaderTitle(getString(R.string.txtCreate))
        showBack()

        val editTextFirstName = findViewById<EditText>(R.id.editTextFirstName)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextAddress = findViewById<EditText>(R.id.editTextAddress)
        val editTextPostalCode = findViewById<EditText>(R.id.editTextPostalCode)
        val editTextCity = findViewById<EditText>(R.id.editTextCity)
        val editTextFidelityCard = findViewById<EditText>(R.id.editTextFidelityCard)

        editTextFirstName.setText(readSharedPref("firstName"))
        editTextName.setText(readSharedPref("name"))
        editTextEmail.setText(readSharedPref("email"))
        editTextAddress.setText(readSharedPref("address"))
        editTextPostalCode.setText(readSharedPref("postalCode"))
        editTextCity.setText(readSharedPref("city"))
        editTextFidelityCard.setText(readSharedPref("fidelityCard"))

        if (
            !receivedBooleanCreateAccountForm
        ){
            textViewTitle.text = "Mon compte"
            buttonSaveModifications.text = "Enregistrer les modifications"
        }
        val buttonCreate = findViewById<Button>(R.id.buttonCreateAccount)

        buttonCreate.setOnClickListener {
            if (editTextFirstName.length() != 0 &&
                editTextName.length() != 0 &&
                editTextEmail.length() != 0 &&
                editTextAddress.length() != 0 &&
                editTextPostalCode.length() != 0 &&
                editTextCity.length() != 0 &&
                editTextFidelityCard.length() != 0
            ) {
            writeSharedPref("firstName", editTextFirstName.text.toString())
            writeSharedPref("name", editTextName.text.toString())
            writeSharedPref("email", editTextEmail.text.toString())
            writeSharedPref("address", editTextAddress.text.toString())
            writeSharedPref("postalCode", editTextPostalCode.text.toString())
            writeSharedPref("city", editTextCity.text.toString())
            writeSharedPref("fidelityCard", editTextFidelityCard.text.toString())

            startActivity(Intent(this,HomeActivity::class.java))
            finish()
            }
            else
            {
                showValidationError(this)
            }
        }
    }
    private fun showValidationError(context: Context) {
        Toast.makeText(context, "Veuillez renseigner toutes les informations", Toast.LENGTH_SHORT).show()
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
