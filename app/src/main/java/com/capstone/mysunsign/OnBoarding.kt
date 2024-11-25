package com.capstone.mysunsign

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.mysunsign.databinding.ActivityOnBoardingBinding

class OnBoarding : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonContinue.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("MySunSignPrefs", MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putBoolean("isFirstLaunch", false)
                apply()
            }

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}