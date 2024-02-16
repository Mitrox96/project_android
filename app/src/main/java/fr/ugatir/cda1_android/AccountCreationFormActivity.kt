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
        val editTextLastName = findViewById<EditText>(R.id.editTextLastName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextAddress = findViewById<EditText>(R.id.editTextAddress)
        val editTextZipCode = findViewById<EditText>(R.id.editTextZipCode)
        val editTextCity = findViewById<EditText>(R.id.editTextCity)
        val editTextCardRef = findViewById<EditText>(R.id.editTextCardRef)

        editTextFirstName.setText(readSharedPref("firstName"))
        editTextLastName.setText(readSharedPref("lastName"))
        editTextEmail.setText(readSharedPref("email"))
        editTextAddress.setText(readSharedPref("address"))
        editTextZipCode.setText(readSharedPref("zipcode"))
        editTextCity.setText(readSharedPref("city"))
        editTextCardRef.setText(readSharedPref("cardRef"))

        if (
            !receivedBooleanCreateAccountForm
        ){
            textViewTitle.text = "Mon compte"
            buttonSaveModifications.text = "Enregistrer les modifications"
        }
        val buttonCreate = findViewById<Button>(R.id.buttonCreateAccount)

        buttonCreate.setOnClickListener {
            if (editTextFirstName.length() != 0 &&
                editTextLastName.length() != 0 &&
                editTextEmail.length() != 0 &&
                editTextAddress.length() != 0 &&
                editTextZipCode.length() != 0 &&
                editTextCity.length() != 0 &&
                editTextCardRef.length() != 0
            ) {
            writeSharedPref("firstName", editTextFirstName.text.toString())
            writeSharedPref("lastName", editTextLastName.text.toString())
            writeSharedPref("email", editTextEmail.text.toString())
            writeSharedPref("address", editTextAddress.text.toString())
            writeSharedPref("zipcode", editTextZipCode.text.toString())
            writeSharedPref("city", editTextCity.text.toString())
            writeSharedPref("cardRef", editTextCardRef.text.toString())

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
