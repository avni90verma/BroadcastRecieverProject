package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeReceiver(private val onStatusChanged :(Boolean) ->Unit):BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
      if(intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED){
          val isAirplaneModeon = intent.getBooleanExtra("state",false)


          onStatusChanged(isAirplaneModeon)
          Toast.makeText(context, "Airplane Mode: $isAirplaneModeon", Toast.LENGTH_SHORT).show()
      }
    }
}