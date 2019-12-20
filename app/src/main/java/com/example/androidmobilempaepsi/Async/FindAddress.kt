package com.example.androidmobilempaepsi.Async

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.os.AsyncTask
import com.example.androidmobilempaepsi.modele.CityCoordsManager

class FindAddress(val context: Context)  : AsyncTask<String, Void, List<Address>>() {

    private var addressList: List<Address>? = null

    fun setAddressList(addressList: List<Address>) {
        this.addressList = addressList
    }

    override fun doInBackground(vararg p: String?): List<Address> {
        if (p.size == 0) {
            return ArrayList()
        }
        this.addressList = getAdressListFromString(p.get(0)!!)
         return this.addressList!!
    }

    private fun getAdressListFromString(location: String): List<Address> {
        return Geocoder(this.context).getFromLocationName(location, 1)
    }

}