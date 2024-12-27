package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tvStatus: TextView
    private lateinit var airplaneModeReceiver: AirplaneModeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tvStatus = findViewById(R.id.tvStatus)
        //Create the BroadcastReceiver instance
        airplaneModeReceiver = AirplaneModeReceiver { isAirplaneModeOn ->
            tvStatus.text = if (isAirplaneModeOn) {
                "Airplane Mode: Enabled"
            } else {
                "Airplane Mode: Disabled"
            }
        }

        // Register the receiver for airplane mode changes
        val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(airplaneModeReceiver, intentFilter)
    }


        override fun onDestroy() {
            super.onDestroy()
            // Unregister the receiver to avoid memory leaks
            unregisterReceiver(airplaneModeReceiver)
        }
    }

