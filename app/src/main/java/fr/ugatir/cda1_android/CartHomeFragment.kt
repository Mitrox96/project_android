import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import fr.ugatir.cda1_android.R

class CartHomeFragment : Fragment() {
    companion object {

        @JvmStatic
        fun newInstance() =
            CartHomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart_home, container, false)
        val cartLayout = view.findViewById<LinearLayout>(R.id.cartLayout)


        val sharedPreferences = requireContext().getSharedPreferences("panier", Context.MODE_PRIVATE)
        val cartItemsJson = sharedPreferences.all.values
        val gson = Gson()

        if (cartItemsJson.isEmpty()) {
            val messageTextView = TextView(requireContext())
            messageTextView.text = "Votre panier est vide"
            messageTextView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
            cartLayout.addView(messageTextView)
        } else {
            cartItemsJson.forEach { itemJson ->
                val item = gson.fromJson(itemJson.toString(), Movie::class.java)

                val itemView = inflater.inflate(R.layout.cart_item_layout, cartLayout, false)

                val imageView = itemView.findViewById<ImageView>(R.id.imageViewCartItem)
                val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
                val descriptionTextView = itemView.findViewById<TextView>(R.id.descriptionTextView)

                Picasso.get().load(item.graphicUrl).resize(120, 120).centerCrop().into(imageView)

                titleTextView.text = item.title
                descriptionTextView.text = item.description

                cartLayout.addView(itemView)
            }
        }

        return view
    }
}
