package com.example.androidmobilemapepsi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TestActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        println("test")
    }

    /*fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        button_id.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
        }

    }*/
}

