package com.capstone.mysunsign

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.mysunsign.databinding.ActivityOnBoardingBinding
import com.capstone.mysunsign.view.login.LoginActivity
import com.capstone.mysunsign.view.signup.SignupActivity

class OnBoarding : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Periksa apakah OnBoarding sudah pernah dilewati
        val sharedPreferences: SharedPreferences = getSharedPreferences("MySunSignPrefs", MODE_PRIVATE)
        val isFirstLaunch = sharedPreferences.getBoolean("isFirstLaunch", true)

        if (!isFirstLaunch) {
            // Jika bukan pertama kali, langsung ke MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        // Jika pertama kali, tampilkan OnBoarding
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navigasi ke LoginActivity
        binding.buttonLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // Navigasi ke RegisterActivity
        binding.buttonRegister.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        // Simpan status bahwa onboarding sudah dilewati
        with(sharedPreferences.edit()) {
            putBoolean("isFirstLaunch", false)
            apply()
        }
    }
}
