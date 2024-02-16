package fr.ugatir.cda1_android

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyCardHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyCardHomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var textViewLastName: TextView
    private lateinit var textViewFirstName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_card_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        textViewLastName = view.findViewById(R.id.textViewLastName)
        textViewFirstName = view.findViewById(R.id.textViewFirstName)

        val firstName = readSharedPref("firstName")
        val lastName = readSharedPref("lastName")
        val email = readSharedPref("email")
        val address = readSharedPref("address")
        val zipCode = readSharedPref("zipcode")
        val city = readSharedPref("city")
        val cardRef = readSharedPref("cardRef")

        val jsonData = createJsonData(firstName, lastName, email, address, zipCode, city, cardRef)

        textViewLastName.text = firstName
        textViewFirstName.text = lastName

        val imageViewQrCode: ImageView = view.findViewById(R.id.imageViewMyCard)
        try {
            val bitmap = generateQrCode(jsonData)
            imageViewQrCode.setImageBitmap(bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun generateQrCode(data: String): Bitmap {
        val barcodeEncoder = BarcodeEncoder()
        return barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, 500, 500)
    }
    private fun createJsonData(firstName: String, lastName: String, email: String, address: String, zipCode: String, city: String, cardRef: String): String {
        val jsonObject = JSONObject()
        jsonObject.put("firstName", firstName)
        jsonObject.put("lastName", lastName)
        jsonObject.put("email", email)
        jsonObject.put("address", address)
        jsonObject.put("zipcode", zipCode)
        jsonObject.put("city", city)
        jsonObject.put("cardRef", cardRef)

        return jsonObject.toString()
    }
    private fun readSharedPref(key: String): String {
        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences("account", Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, "") ?: ""
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyCardHomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                MyCardHomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}