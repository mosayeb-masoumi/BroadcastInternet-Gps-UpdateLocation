package com.example.broadcastinternetgps.gps_broadcast

import android.content.IntentFilter
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.broadcastinternetgps.R
import com.google.android.material.snackbar.Snackbar

class GPSbroadcastActivity : AppCompatActivity() {


    private var gpsStatusReceiver: GpsStatusReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gpsbroadcast)


        // Initialize the GPS status receiver
        gpsStatusReceiver = GpsStatusReceiver { isGpsEnabled ->
            // Handle the GPS status update here
            if (isGpsEnabled) {
                // GPS is enabled
                onSNACK(this.findViewById(android.R.id.content) , "ON")
            } else {
                // GPS is disabled
                onSNACK(this.findViewById(android.R.id.content) , "OFF")

            }
        }

        // Register the GPS status receiver to receive the GPS status updates broadcast
        val intentFilter = IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION)
        registerReceiver(gpsStatusReceiver, intentFilter)




//        val intentFilter = IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION)
//        val gpsStatusReceiver = GpsStatusReceiver().
//        registerReceiver(gpsStatusReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(gpsStatusReceiver)
    }



    fun onSNACK(view: View , title:String){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, title,
            Snackbar.LENGTH_LONG).setAction("Action", null)
        snackbar.show()
    }
}