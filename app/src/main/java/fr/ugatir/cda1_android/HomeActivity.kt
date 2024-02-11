package fr.ugatir.cda1_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.text = "Accueil"

        val createForm = false
        val imageViewSettings = findViewById<ImageView>(R.id.imageViewSettings)
        imageViewSettings.setOnClickListener {
            startActivity(Intent(this,AccountCreationFormActivity::class.java).putExtra("CREATE_KEY", createForm))
        }
        val buttonPhotos=findViewById<Button>(R.id.buttonPhotos)
        buttonPhotos.setOnClickListener {
            startActivity(Intent(this,PhotosActivity::class.java))
        }


        val buttonLogin=findViewById<Button>(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

        val buttonStudents=findViewById<Button>(R.id.buttonStudents)
        buttonStudents.setOnClickListener {
            startActivity(Intent(this, GenerateQRActivity::class.java))
        }


        val buttonTabbar=findViewById<Button>(R.id.buttonTabbar)
        buttonTabbar.setOnClickListener {
            startActivity(Intent(this,AccountCreationFormActivity::class.java))
        }
    }
}