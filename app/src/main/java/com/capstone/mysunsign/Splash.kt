package com.capstone.mysunsign

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences: SharedPreferences = getSharedPreferences("MySunSignPrefs", MODE_PRIVATE)
        val isFirstLaunch = sharedPreferences.getBoolean("isFirstLaunch", true)

        val nextActivity = if (isFirstLaunch) OnBoarding::class.java else MainActivity::class.java

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, nextActivity))
            finish()
        }, 2000)
    }
}