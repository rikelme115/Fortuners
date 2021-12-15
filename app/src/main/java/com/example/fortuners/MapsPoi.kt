package com.example.fortuners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fortuners.databinding.ActivityMapsPoiBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsPoi : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsPoiBinding

    private var latitud1 : Double? = 0.0
    private var longitud1 : Double? = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsPoiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*var latitud = intent.getStringExtra("lat")
        var longitud= intent.getStringExtra("lon")

        latitud1 = latitud?.toDouble()
        longitud1 = longitud?.toDouble()*/


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        /*val intent = this.intent
        val extra = intent.extras*/



        /*var lat : Double = latitud1!!
        var lon :  Double = longitud1!!*/

        /*var latitud = -34.0//extra!!.getDouble("latitud")
        var longitud = 151.0//extra!!.getDouble("longitud")*/

        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}

