package com.example.androidmobilemapepsi.vue

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmobilemapepsi.R


class TestActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState:Bundle?){

        var ville1 = intent.getStringExtra("VILLE_1")
        var pays1 = intent.getStringExtra("PAYS_1")
        var lat1:Double = intent.getDoubleExtra("LAT_1",0.0)
        var long1:Double = intent.getDoubleExtra("LONG_1",0.0)
        var ville2 = intent.getStringExtra("VILLE_2")
        var pays2 = intent.getStringExtra("PAYS_2")
        var lat2:Double = intent.getDoubleExtra("LAT_2",0.0)
        var long2:Double = intent.getDoubleExtra("LONG_2",0.0)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        fun degreesToRadians(degrees: Double): Double{
            return (degrees * Math.PI / 180)
        }

        fun distanceInKmBetweenEarthCoordinates(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double{
            var earthRadiusKm = 6371
            var dLat = degreesToRadians(lat2-lat1)
            var dLon = degreesToRadians(lon2-lon1)

            var lati1 = degreesToRadians(lat1)
            var lati2 = degreesToRadians(lat2)

            var a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lati1) * Math.cos(lati2)
            var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a))
            return (earthRadiusKm * c)

        }

        //var oui = distanceInKmBetweenEarthCoordinates(100.1, 100.1, 200.2, 200.2)
        var oui = distanceInKmBetweenEarthCoordinates(lat1, long1, lat2, long2)
        var disp = String.format("%.1f", oui).plus(" Km")
        findViewById<TextView>(R.id.citiesTextView).text = "Paris (France) - Tokyo (Japon)"
        findViewById<TextView>(R.id.distTextView).text = disp

    }
}

/**/

