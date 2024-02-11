package fr.ugatir.cda1_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import fr.ugatir.cda1_android.R
import fr.ugatir.cda1_android.TabbarActivity
import fr.ugatir.cda1_android.ApiClient
import fr.ugatir.cda1_android.ApiService
import fr.ugatir.cda1_android.VotreModele // Assurez-vous que cette importation est présente

class Tab1Fragment : Fragment() {
    private val apiService = ApiClient.buildService(ApiService::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonLogin = view.findViewById<Button>(R.id.buttonLogin)
        val editTextTextEmailAddress = view.findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextTextPassword = view.findViewById<EditText>(R.id.editTextTextPassword)

        buttonLogin.setOnClickListener {
            val call: Call<VotreModele> = apiService.getDonnees()

            call.enqueue(object : Callback<VotreModele> {
                override fun onResponse(call: Call<VotreModele>, response: Response<VotreModele>) {
                    if (response.isSuccessful) {
                        val modele: VotreModele? = response.body()
                        // Faites quelque chose avec les données
                        Toast.makeText(
                            activity,
                            "${editTextTextEmailAddress.text.toString()}/${editTextTextPassword.text.toString()}",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        // Gérez les erreurs ici
                    }
                }

                override fun onFailure(call: Call<VotreModele>, t: Throwable) {
                    // Gérez les erreurs de réseau ici
                }
            })
        }
    }
}
