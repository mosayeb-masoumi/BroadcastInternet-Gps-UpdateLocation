package com.example.broadcastinternetgps.internet_broadcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.broadcastinternetgps.R
import com.google.android.material.snackbar.Snackbar

class InternetBroadcastActivity : AppCompatActivity(), NetworkManager.ConnectivityListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet_broadcast)

        NetworkManager.registerConnectivityListener(this, this)
    }

    override fun onDestroy() {
        super.onDestroy()

        NetworkManager.unregisterConnectivityListener(this)
    }

    override fun onConnectivityChanged(isConnected: Boolean) {
        if (isConnected) {
            // Internet is available
            onSNACK(this.findViewById(android.R.id.content) , "internet ON")
        } else {
            // Internet is not available
            onSNACK(this.findViewById(android.R.id.content) , "internet OFF")
        }
    }


    fun onSNACK(view: View, title:String){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, title,
            Snackbar.LENGTH_LONG).setAction("Action", null)
        snackbar.show()
    }
}