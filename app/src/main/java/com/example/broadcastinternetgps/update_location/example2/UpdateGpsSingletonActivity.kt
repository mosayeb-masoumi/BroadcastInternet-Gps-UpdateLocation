package com.example.broadcastinternetgps.update_location.example2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.broadcastinternetgps.R

class UpdateGpsSingletonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_gps_singleton)

        LocationUpdateManager.startLocationUpdates(this) { location ->
//            Log.d("LocationUpdate", "Latitude: ${location.latitude}, Longitude: ${location.longitude}")

            Toast.makeText(this@UpdateGpsSingletonActivity,"LocationUpdate\", \"Latitude: ${location.latitude}, Longitude: ${location.longitude}",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        LocationUpdateManager.stopLocationUpdates()
    }
}