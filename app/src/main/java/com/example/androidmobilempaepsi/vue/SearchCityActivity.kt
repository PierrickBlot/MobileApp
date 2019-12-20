package com.example.androidmobilempaepsi.vue

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmobilemapepsi.R
import com.example.androidmobilempaepsi.modele.CityCoordsManager

import kotlinx.android.synthetic.main.activity_search_city.*

class SearchCityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_city)
        addListeners()
    }

    private fun addListeners() {
        onBtnValiderSearchClick()
    }

    fun onBtnValiderSearchClick() {
        getLatAndLongFromString()
        btnValiderSearch.setOnClickListener {
            CityCoordsManager.setLat(5.5)
            CityCoordsManager.setLat(4.4)
            finish()
        }
    }

    private fun getLatAndLongFromString() {
        setCoordsFromAdressList(Geocoder(this).getFromLocationName("France", 1))
    }

    private fun setCoordsFromAdressList(addressList: List<Address>) {
        if (addressList.size.equals(0)) {
            CityCoordsManager.setIsFound(false)
            return
        }
        val address = addressList.get(0)
        CityCoordsManager.setLat(address.latitude)
        CityCoordsManager.setLong(address.longitude)
    }
}
