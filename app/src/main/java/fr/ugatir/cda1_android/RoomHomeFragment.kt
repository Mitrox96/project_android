package fr.ugatir.cda1_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.OverlayItem
import java.io.IOException
import org.json.JSONArray
import android.preference.PreferenceManager
import org.osmdroid.tileprovider.tilesource.TileSourceFactory

class RoomHomeFragment : Fragment() {

    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_room_home, container, false)

        mapView = view.findViewById(R.id.map) as MapView
        initializeMap()

        fetchJsonFromUrl("https://ugarit-online.000webhostapp.com/epsi/films/salles.json")

        return view
    }

    private fun fetchJsonFromUrl(url: String) {
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val responseBody = response.body?.string()
                    if (responseBody != null) {
                        addMarkersToMap(responseBody)
                    }
                }
            }
        })
    }

    private fun addMarkersToMap(json: String) {
        val jsonArray = JSONArray(json)
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val latitude = jsonObject.getDouble("latitude")
            val longitude = jsonObject.getDouble("longitude")
            val name = jsonObject.getString("name")
            activity?.runOnUiThread {
                val point = GeoPoint(latitude, longitude)
                val marker = Marker(mapView)
                marker.position = point
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                marker.title = name
                mapView.overlays.add(marker)
            }
        }
    }

    private fun initializeMap() {
        Configuration.getInstance().load(activity, PreferenceManager.getDefaultSharedPreferences(activity))
        mapView.setTileSource(TileSourceFactory.MAPNIK)
        mapView.isTilesScaledToDpi = true
        mapView.setBuiltInZoomControls(true)
        mapView.setMultiTouchControls(true)

        val mapController = mapView.controller
        mapController.setZoom(9.5)
        val startPoint = GeoPoint(48.8534, 2.3488) // Paris, France
        mapController.setCenter(startPoint)
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume() // needed for compass, my location overlays, v6.0.0 and up
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    companion object {

        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RoomHomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
