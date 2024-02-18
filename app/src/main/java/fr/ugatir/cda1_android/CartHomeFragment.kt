import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import fr.ugatir.cda1_android.R

class CartHomeFragment : Fragment() {
    private val cartItems = mutableListOf<Movie>()

    companion object {
        @JvmStatic
        fun newInstance() = CartHomeFragment().apply {
            arguments = Bundle().apply {}
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart_home, container, false)
        val cartLayout = view.findViewById<LinearLayout>(R.id.cartLayout)
        val emptyCartMessage = view.findViewById<TextView>(R.id.emptyCartMessage)

        val sharedPreferences = requireContext().getSharedPreferences("panier", Context.MODE_PRIVATE)
        val cartItemsJson = sharedPreferences.all.values
        val gson = Gson()

        // Vérifiez si le panier est vide et configurez le texte en conséquence
        if (cartItemsJson.isEmpty()) {
            emptyCartMessage.text = "Votre panier est vide"
            emptyCartMessage.visibility = View.VISIBLE
        } else {
            emptyCartMessage.visibility = View.GONE

            val inflater = LayoutInflater.from(requireContext())
            cartItemsJson.forEach { itemJson ->
                val item = gson.fromJson(itemJson.toString(), Movie::class.java)
                cartItems.add(item)
                val itemView = inflater.inflate(R.layout.cart_item_layout, cartLayout, false)

                // Configurez les vues pour afficher les détails de l'article
                val imageView = itemView.findViewById<ImageView>(R.id.imageViewCartItem)
                val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
                val descriptionTextView = itemView.findViewById<TextView>(R.id.descriptionTextView)
                val deleteButton = itemView.findViewById<Button>(R.id.deleteButton)

                Picasso.get().load(item.graphicUrl).resize(120, 120).centerCrop().into(imageView)
                titleTextView.text = item.title
                descriptionTextView.text = item.description

                deleteButton.setOnClickListener {
                    removeItemFromCart(item)
                    Toast.makeText(requireContext(), "Film supprimé du panier", Toast.LENGTH_SHORT).show()
                    refreshCartView(cartLayout, emptyCartMessage)
                }

                cartLayout.addView(itemView)
            }
        }

        return view
    }

    private fun removeItemFromCart(item: Movie) {
        val sharedPreferences = requireContext().getSharedPreferences("panier", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove(item.id.toString())
        editor.apply()
        cartItems.remove(item)
    }

    private fun refreshCartView(cartLayout: LinearLayout, emptyCartMessage: TextView) {
        cartLayout.removeAllViews()

        val inflater = LayoutInflater.from(requireContext())
        cartItems.forEach { item ->
            val itemView = inflater.inflate(R.layout.cart_item_layout, cartLayout, false)

            // Configurez les vues pour afficher les détails de l'article
            val imageView = itemView.findViewById<ImageView>(R.id.imageViewCartItem)
            val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
            val descriptionTextView = itemView.findViewById<TextView>(R.id.descriptionTextView)
            val deleteButton = itemView.findViewById<Button>(R.id.deleteButton)

            Picasso.get().load(item.graphicUrl).resize(120, 120).centerCrop().into(imageView)
            titleTextView.text = item.title
            descriptionTextView.text = item.description

            deleteButton.setOnClickListener {
                removeItemFromCart(item)
                Toast.makeText(requireContext(), "Film supprimé du panier", Toast.LENGTH_SHORT).show()
                refreshCartView(cartLayout, emptyCartMessage)
            }

            cartLayout.addView(itemView)
        }

        // Mettre à jour la visibilité du message en fonction du contenu du panier
        if (cartItems.isEmpty()) {
            emptyCartMessage.text = "Votre panier est vide"
            emptyCartMessage.visibility = View.VISIBLE
        } else {
            emptyCartMessage.visibility = View.GONE
        }
    }
}
