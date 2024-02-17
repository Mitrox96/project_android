import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import fr.ugatir.cda1_android.R

class DetailsFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_film)

        // Récupérer les données du film depuis l'intent
        val movie = intent.getParcelableExtra<Movie>("movie")

        // Afficher les détails du film
        val imageView: ImageView = findViewById(R.id.imageViewFilm)
        Picasso.get().load(movie?.graphicUrl).into(imageView)

        val titleTextView: TextView = findViewById(R.id.titleTextView)
        titleTextView.text = movie?.title

        val durationTextView: TextView = findViewById(R.id.durationTextView)
        durationTextView.text = "Durée: ${movie?.runTime} minutes"

        val descriptionTextView: TextView = findViewById(R.id.descriptionTextView)
        descriptionTextView.text = movie?.description

        val addToCartButton: Button = findViewById(R.id.addToCartButton)
        addToCartButton.setOnClickListener {
            // Ajouter la logique pour ajouter le film au panier
            // ...
        }

        // Écouteur de clic sur la flèche de retour
        val backArrowImageView: ImageView = findViewById(R.id.imageViewBackArrow)
        backArrowImageView.setOnClickListener {
            onBackPressed()
        }
    }
}
