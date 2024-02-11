package fr.ugatir.cda1_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class   ImageActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val title= intent.extras!!.getString("title","");
        val imgUrl= intent.extras!!.getString("imgUrl");

        setHeaderTitle(title)

        val imageView=findViewById<ImageView>(R.id.imageView)
        Glide.with(this).load(imgUrl).into(imageView);
        showBack()
    }
}