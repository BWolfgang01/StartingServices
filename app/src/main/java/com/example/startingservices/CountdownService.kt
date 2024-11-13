package com.example.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountdownService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d("CountdownService", "Service Created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val countdownValue = intent?.getIntExtra("COUNTDOWN_VALUE", 0) ?: 0


        Log.d("CountdownService", "Starting countdown from $countdownValue")


        GlobalScope.launch {
            for (i in countdownValue downTo 0) {
                Log.d("CountdownService", "Countdown: $i")
                delay(1000)
            }
            stopSelf()
        }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CountdownService", "Service Destroyed")
    }
}
