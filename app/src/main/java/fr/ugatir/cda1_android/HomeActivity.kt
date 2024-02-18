package fr.ugatir.cda1_android

import android.view.animation.AnimationUtils
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : BaseActivity() {

    val moviesHomeFragment= MoviesHomeFragment.newInstance()
    val roomHomeFragment = RoomHomeFragment.newInstance("","")
    val myCardHomeFragment = MyCardHomeFragment.newInstance("","")
    val cartHomeFragment= CartHomeFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.text = "Accueil"

        val buttonMyCardHomeFragment= findViewById<TextView>(R.id.textViewMyCard)
        val moviesHomeFragment = findViewById<TextView>(R.id.textViewMovies)
        val roomHomeFragment = findViewById<TextView>(R.id.textViewRoomHomeFragment)
        val cartHomeFragment = findViewById<TextView>(R.id.textViewCartHomeFragment)

        val createForm = false
        val imageViewSettings = findViewById<ImageView>(R.id.imageViewSettings)
        imageViewSettings.setOnClickListener {
            startActivity(Intent(this,AccountCreationFormActivity::class.java).putExtra("CREATE_KEY", createForm))
        }

        showMyCardHomeFragment()

       moviesHomeFragment.setOnClickListener {
           showMoviesHomeFragment()
       }
        buttonMyCardHomeFragment.setOnClickListener {
            showMyCardHomeFragment()
        }

       roomHomeFragment.setOnClickListener {
            showRommHomeFragment()
        }

        cartHomeFragment.setOnClickListener {
            showCartHomeFragment()

        }
    }

    fun showMoviesHomeFragment(){
      val frManager=supportFragmentManager
      val fragmentTra= frManager.beginTransaction()
      fragmentTra.addToBackStack("Tab2")
      val textView = findViewById<TextView>(R.id.textViewMovies)
      val animation = AnimationUtils.loadAnimation(this, R.anim.animationbutton)
      textView.startAnimation(animation)
      fragmentTra.replace(R.id.layoutHome,moviesHomeFragment)
      fragmentTra.commit()

  }

    fun showRommHomeFragment(){
      val frManager=supportFragmentManager
      val fragmentTra= frManager.beginTransaction()
      fragmentTra.addToBackStack("Tab2")
      fragmentTra.replace(R.id.layoutHome,roomHomeFragment)
      val textView = findViewById<TextView>(R.id.textViewRoomHomeFragment)
      val animation = AnimationUtils.loadAnimation(this, R.anim.animationbutton)
      textView.startAnimation(animation)
      fragmentTra.commit()
  }

    fun showMyCardHomeFragment(){
        val frManager=supportFragmentManager
        val fragmentTra= frManager.beginTransaction()
        fragmentTra.addToBackStack("MyCardHomeFragment")
        val textView = findViewById<TextView>(R.id.textViewMyCard)
        val animation = AnimationUtils.loadAnimation(this, R.anim.animationbutton)
        textView.startAnimation(animation)
        fragmentTra.replace(R.id.layoutHome,myCardHomeFragment)
        fragmentTra.commit()
    }

    fun showCartHomeFragment(){
        val frManager=supportFragmentManager
        val fragmentTra= frManager.beginTransaction()
        fragmentTra.addToBackStack("Tab3")
        val textView = findViewById<TextView>(R.id.textViewCartHomeFragment)
        val animation = AnimationUtils.loadAnimation(this, R.anim.animationbutton)
        textView.startAnimation(animation)
        fragmentTra.replace(R.id.layoutHome,cartHomeFragment)
        fragmentTra.commit()
    }
}
