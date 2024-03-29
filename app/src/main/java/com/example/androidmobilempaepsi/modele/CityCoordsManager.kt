package com.example.androidmobilempaepsi.modele

import android.location.Address

object CityCoordsManager {

    private var address: Address? = null

    fun setAddress(address: Address) {
        this.address = address
    }

    fun isFound(): Boolean {
        return address != null
    }

    fun getAddress(): Address? {
        return address
    }

    fun getLong(): Double {
        if (address != null) {
            return address!!.longitude
        }
        return 0.0
    }

    fun getLat(): Double {
        if (address != null) {
            return address!!.latitude
        }
        return 0.0
    }
}