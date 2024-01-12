package fr.ugatir.cda1_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val buttonPhotos=findViewById<Button>(R.id.buttonPhotos)
        buttonPhotos.setOnClickListener {
            startActivity(Intent(this,PhotosActivity::class.java))
        }

        val buttonRoll=findViewById<Button>(R.id.buttonRoll)
        buttonRoll.setOnClickListener {
            startActivity(Intent(this,RollDiceActivity::class.java))
        }

        val buttonLogin=findViewById<Button>(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

        val buttonStudents=findViewById<Button>(R.id.buttonStudents)
        buttonStudents.setOnClickListener {
            startActivity(Intent(this,StudentActivity::class.java))
        }

        val buttonStudentsWs=findViewById<Button>(R.id.buttonStudentsWs)
        buttonStudentsWs.setOnClickListener {
            startActivity(Intent(this,StudentWsActivity::class.java))
        }

        val buttonCreate=findViewById<Button>(R.id.buttonCreate)
        buttonCreate.setOnClickListener {
            startActivity(Intent(this,CreateActivity::class.java))
        }

        val buttonTabbar=findViewById<Button>(R.id.buttonTabbar)
        buttonTabbar.setOnClickListener {
            startActivity(Intent(this,TabbarActivity::class.java))
        }
    }
}