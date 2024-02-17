import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import fr.ugatir.cda1_android.Movie
import fr.ugatir.cda1_android.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL

class MoviesHomeFragment : Fragment() {

    private val moviesList = mutableListOf<Movie>()

    companion object {
        fun newInstance(): MoviesHomeFragment {
            return MoviesHomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_home, container, false)

        // Fetch movie data from the web service
        GlobalScope.launch(Dispatchers.Main) {
            val jsonString = withContext(Dispatchers.IO) {
                URL("https://ugarit-online.000webhostapp.com/epsi/films/movies.json").readText()
            }

            parseJson(jsonString)
            displayMovies(view)
        }

        return view
    }

    private fun parseJson(jsonString: String) {
        val jsonObject = JSONObject(jsonString)
        val moviesArray = jsonObject.getJSONArray("movies")

        for (i in 0 until moviesArray.length()) {
            val movieObject = moviesArray.getJSONObject(i)
            val movie = Movie(
                movieObject.getString("id"),
                movieObject.getString("title"),
                movieObject.getString("description"),
                movieObject.getInt("runTime"),
                movieObject.getString("graphicUrl"),
                movieObject.getString("backdropUrl")
            )
            moviesList.add(movie)
        }
    }

    private fun displayMovies(view: View) {
        val moviesLayout: LinearLayout = view.findViewById(R.id.moviesLayout)

        for (movie in moviesList) {
            // Creating a vertical linear layout for each movie
            val movieLayout = LinearLayout(requireContext())
            movieLayout.orientation = LinearLayout.VERTICAL

            // Creating an ImageView for the movie poster
            val imageView = ImageView(requireContext())
            imageView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                resources.getDimensionPixelSize(R.dimen.movie_image_height)
            )

            // Loading image using Picasso library
            Picasso.get().load(movie.graphicUrl).into(imageView)

            // Creating a TextView for the movie title
            val titleTextView = TextView(requireContext())
            titleTextView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            titleTextView.text = movie.title
            titleTextView.textSize = 28f
            titleTextView.setTextColor(resources.getColor(android.R.color.black))

            // Adding views to the movie layout
            movieLayout.addView(imageView)
            movieLayout.addView(titleTextView)

            // Adding movie layout to the main movies layout
            moviesLayout.addView(movieLayout)
        }
    }
}
