package com.example.broadcastinternetgps.update_location.example1

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.broadcastinternetgps.R

class UpdateBroadcastLocationEvery5sec : AppCompatActivity() {

    lateinit var locationManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        // Check for location permission
        if (ActivityCompat.checkSelfPermission(this,  ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(ACCESS_FINE_LOCATION), 1)
        } else {

            startLocationUpdates()
        }


    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        // Request location updates
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0f, locationListener)
    }

    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            // Handle location change
            val latitude = location.latitude
            val longitude = location.longitude
            // Do something with the latitude and longitude

            Toast.makeText(this@UpdateBroadcastLocationEvery5sec,"$latitude  $longitude",Toast.LENGTH_LONG).show()
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            // Handle location provider status change
            var a = 5;
        }

        override fun onProviderEnabled(provider: String) {
            // Handle location provider enabled
            var a = 5
            Toast.makeText(this@UpdateBroadcastLocationEvery5sec,"ON",Toast.LENGTH_LONG).show()
            startLocationUpdates()
        }

        override fun onProviderDisabled(provider: String) {
            // Handle location provider disabled
            var a = 5;
            Toast.makeText(this@UpdateBroadcastLocationEvery5sec,"OFF",Toast.LENGTH_LONG).show()
        }
    }
}