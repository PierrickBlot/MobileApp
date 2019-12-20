package com.example.androidmobilempaepsi.modele

object CityCoordsManager {
    private var long: Double = 0.0
    private var lat: Double = 0.0

    private var found = false

    fun setIsFound(found: Boolean) {
        this.found = found
    }

    fun isFound(): Boolean {
        val f = found
        found = false
        return f
    }

    fun getLong(): Double {
        return long
    }

    fun getLat(): Double {
        return lat
    }

    fun setLong(Long: Double) {
        this.long = long
    }

    fun setLat(lat: Double) {
        this.lat = lat
    }
}