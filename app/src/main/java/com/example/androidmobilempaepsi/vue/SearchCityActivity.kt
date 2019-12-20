package com.example.androidmobilempaepsi.vue

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmobilemapepsi.R
import com.example.androidmobilempaepsi.modele.CityCoordsManager

import kotlinx.android.synthetic.main.activity_search_city.*

class SearchCityActivity : AppCompatActivity() {

    private val addressList: List<Address> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_city)
        addListeners()
    }

    private fun addListeners() {
        onTxtSearchType()
        onBtnValiderSearchClick()
    }


    fun onTxtSearchType() {
        txtSearchLocation.setOnEditorActionListener { textView: TextView, _: Int, _: KeyEvent ->
            Log.d("TEST-DEBUG", textView.text.toString())
            true
        }
    }

    fun onBtnValiderSearchClick() {
        btnValiderSearch.setOnClickListener {
            getLatAndLongFromString(txtSearchLocation.text.toString())
            val myIntent = Intent(this, MapsActivity::class.java)
            startActivity(myIntent)
        }
    }

    private fun getLatAndLongFromString(location: String) {
        if (!location.equals("")) {
            setCoordsFromAdressList(getAdressListFromString(location))
        }
    }

    private fun getAdressListFromString(location: String): List<Address> {
        return Geocoder(this).getFromLocationName(location, 1)
    }

    private fun setCoordsFromAdressList(addressList: List<Address>) {
        if (addressList.size.equals(0)) {
            return
        }
        val address = addressList.get(0)
        CityCoordsManager.setAddress(address)
    }
}
