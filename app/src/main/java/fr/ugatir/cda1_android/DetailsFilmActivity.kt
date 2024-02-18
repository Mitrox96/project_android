package fr.ugatir.cda1_android

import Movie
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import fr.ugatir.cda1_android.BaseActivity
import fr.ugatir.cda1_android.R

class DetailsFilmActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_film)

        val movie = intent.getParcelableExtra<Movie>("movie")

        if (movie != null) {

            val imageView: ImageView = findViewById(R.id.imageViewFilm)
            Picasso.get().load(movie.graphicUrl).into(imageView)

            val titleTextView: TextView = findViewById(R.id.titleTextView)
            titleTextView.text = movie.title

            val durationTextView: TextView = findViewById(R.id.durationTextView)
            durationTextView.text = "Durée: ${movie.runTime} minutes"

            val descriptionTextView: TextView = findViewById(R.id.descriptionTextView)
            descriptionTextView.text = movie.description

            val addToCartButton: Button = findViewById(R.id.addToCartButton)
            addToCartButton.setOnClickListener {

                addToCart(movie)
            }
        } else {

            Toast.makeText(this, "Erreur: Aucun film trouvé", Toast.LENGTH_SHORT).show()
            finish()
        }

        val backArrowImageView: ImageView = findViewById(R.id.imageViewBackArrow)
        backArrowImageView.setOnClickListener {
            onBackPressed()
        }
    }

    private fun addToCart(movie: Movie) {

        val sharedPreferences = getSharedPreferences("panier", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()


        val gson = Gson()
        val movieJson = gson.toJson(movie)


        editor.putString("film_${movie.id}", movieJson)
        editor.apply()

        Toast.makeText(this, "Film ajouté au panier", Toast.LENGTH_SHORT).show()
    }
}
