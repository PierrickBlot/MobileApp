package com.example.androidmobilempaepsi.vue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmobilemapepsi.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*
import android.content.Intent
import android.location.Geocoder
import android.util.Log
import com.example.androidmobilempaepsi.modele.CityCoordsManager
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        addListeners()
    }

    private fun addListeners() {
        onBtnSearchClick()
    }

    override fun onRestart() { // on back from activity search
        Log.d("TEST-DEBUG", CityCoordsManager.getLat().toString())
        if (CityCoordsManager.isFound()) {

        }
        super.onRestart()
    }


    private fun onBtnSearchClick() {
        btnSearch.setOnClickListener {
            val myIntent = Intent(this, SearchCityActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
        Log.d("TEST-DEBUG", "coucou")
        super.onTopResumedActivityChanged(isTopResumedActivity)
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
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

}
