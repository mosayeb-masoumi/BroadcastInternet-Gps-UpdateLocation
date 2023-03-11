package com.example.broadcastinternetgps.gps_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

//class GpsStatusReceiver(locationCallBack: LocationCallBack?) : BroadcastReceiver() {
//
//    override fun onReceive(context: Context, intent: Intent) {
//        if (intent.action == LocationManager.PROVIDERS_CHANGED_ACTION) {
//            val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
//            val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
//
//            if (isGpsEnabled) {
//                // GPS is enabled
//                var a = 5;
//                Toast.makeText(context , "ON" , Toast.LENGTH_SHORT).show()
//            } else {
//                // GPS is disabled
//                var a = 5;
//                Toast.makeText(context , "OFF" , Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}

class GpsStatusReceiver(private val callback: (Boolean) -> Unit) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == LocationManager.PROVIDERS_CHANGED_ACTION) {
            // Check if GPS is enabled or disabled
            val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            callback.invoke(isGpsEnabled)
        }
    }
}