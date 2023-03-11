package com.example.broadcastinternetgps.update_location.example2

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.os.Bundle

import android.location.LocationManager


object LocationUpdateManager {
    private var locationManager: LocationManager? = null
    private var locationListener: LocationListener? = null

    @SuppressLint("MissingPermission")
    fun startLocationUpdates(context: Context, locationCallback: (Location) -> Unit) {
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                locationCallback(location)
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}

            override fun onProviderEnabled(provider: String) {}

            override fun onProviderDisabled(provider: String) {}
        }

        locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0f, locationListener!!)
    }

    fun stopLocationUpdates() {
        locationManager?.removeUpdates(locationListener!!)
        locationManager = null
        locationListener = null
    }
}