import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.ugatir.cda1_android.MovieAdapter
import fr.ugatir.cda1_android.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL

class MoviesHomeFragment : Fragment() {

    private val moviesList = mutableListOf<Movie>()
    private lateinit var movieAdapter: MovieAdapter

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

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewMovies)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        movieAdapter = MovieAdapter(moviesList)
        recyclerView.adapter = movieAdapter

        GlobalScope.launch(Dispatchers.Main) {
            val jsonString = withContext(Dispatchers.IO) {
                URL("https://ugarit-online.000webhostapp.com/epsi/films/movies.json").readText()
            }

            parseJson(jsonString)
            movieAdapter.notifyDataSetChanged()
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
}
