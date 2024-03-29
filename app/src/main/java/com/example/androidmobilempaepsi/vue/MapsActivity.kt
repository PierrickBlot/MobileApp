package com.example.androidmobilempaepsi.vue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import android.location.Location
import android.content.pm.PackageManager

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*
import android.content.Intent
import android.view.View
import com.example.androidmobilemapepsi.R
import com.google.android.gms.maps.model.Marker
import com.example.androidmobilempaepsi.modele.CityCoordsManager

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var map: GoogleMap
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }
        map.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->
            // Got last known location. In some rare situations this can be null.
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        addListeners()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    private fun addListeners() {
        onBtnSearchClick()
    }

    private fun onBtnSearchClick() {
        btnSearch.setOnClickListener {
            val myIntent = Intent(this, SearchCityActivity::class.java)
            startActivity(myIntent)
            finish()
        }
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
        map = googleMap

        map.uiSettings.isZoomControlsEnabled = true
        map.setOnMarkerClickListener(this)

        setUpMap()

        if (CityCoordsManager.isFound()) {
            val custom = LatLng(CityCoordsManager.getLat(), CityCoordsManager.getLong())
            map.addMarker(MarkerOptions().position(custom))
            map.moveCamera(CameraUpdateFactory.newLatLng(custom))

            fusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->
                // Got last known location. In some rare situations this can be null.
                if (location != null) {
                    lastLocation = location
                    val currentLatLng = LatLng(location.latitude, location.longitude)
                    button_id.visibility= View.VISIBLE
                    button_id.setOnClickListener {
                        var intent = Intent(this, TestActivity::class.java)
                        intent.putExtra("LAT_1", location.latitude)
                        intent.putExtra("LONG_1", location.longitude)
                        intent.putExtra("LAT_2", CityCoordsManager.getLat())
                        intent.putExtra("LONG_2", CityCoordsManager.getLong())
                        startActivity(intent)
                    }
                }
            }

        } else {
            button_id.visibility= View.INVISIBLE
        }
    }

    override fun onMarkerClick(p0: Marker?) = false

}

