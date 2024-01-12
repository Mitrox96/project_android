package fr.ugatir.cda1_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        showBack()
        setHeaderTitle(getString(R.string.txtLogin))

        val buttonLogin=findViewById<Button>(R.id.buttonLogin)
        val editTextTextEmailAddress=findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextTextPassword=findViewById<EditText>(R.id.editTextTextPassword)
        buttonLogin.setOnClickListener(View.OnClickListener {
            Toast.makeText(application,editTextTextEmailAddress.text.toString()+"/"+editTextTextPassword.text.toString(),Toast.LENGTH_LONG).show()
        })
    }
}