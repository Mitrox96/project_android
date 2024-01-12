package fr.ugatir.cda1_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class PhotosActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)
        val buttonNature = findViewById<Button>(R.id.buttonNature)
        buttonNature.setOnClickListener {
            val intent =Intent(this,ImageActivity::class.java)
            intent.putExtra("title",getString(R.string.txtNature))
            val url = "https://www.radiofrance.fr/s3/cruiser-production/2021/11/583b3917-c531-4786-8170-9ce8b1d1a81a/1200x680_gettyimages-1265067608.jpg";
            intent.putExtra("imgUrl",url)
            startActivity(intent)
        }

        val buttonSpace = findViewById<Button>(R.id.buttonSpace)
        buttonSpace.setOnClickListener {
            val intent =Intent(this,ImageActivity::class.java)
            intent.putExtra("title",getString(R.string.txtSpace))
            val url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPcgn9vZMaa34hXm9YrNtMINd0poGOzuKJVl4x_6iq4V0iQ4RIQdiZeR6SLmOrTHU6t9M&usqp=CAU";
            intent.putExtra("imgUrl",url)
            startActivity(intent)
        }
        showBack()
        setHeaderTitle(getString(R.string.txtPhotos))
    }
}