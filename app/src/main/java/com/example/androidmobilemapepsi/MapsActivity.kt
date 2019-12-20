package com.example.androidmobilemapepsi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var pays1 = "France";
    private var ville1 = "Nantes";
    private var lat1 = 300.1;
    private var long1 = 300.1;
    private var ville2 = "Hong Kong";
    private var pays2 = "Tokyo";
    private var lat2 = 200.2;
    private var long2 = 200.2;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        button_id.setOnClickListener {
            var intent = Intent(this, TestActivity::class.java)
            intent.putExtra("PAYS_1", pays1)
            intent.putExtra("VILLE_1", ville1)
            intent.putExtra("LAT_1", lat1)
            intent.putExtra("LONG_1", long1)
            intent.putExtra("PAYS_2", pays2)
            intent.putExtra("VILLE_2", ville2)
            intent.putExtra("LAT_2", lat2)
            intent.putExtra("LONG_2", long2)
            startActivity(intent)
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}

