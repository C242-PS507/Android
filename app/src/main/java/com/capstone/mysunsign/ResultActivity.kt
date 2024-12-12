package com.capstone.mysunsign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.mysunsign.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil skor dan total soal dari Intent
        val score = intent.getIntExtra("score", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)

        // Menampilkan hasil skor
        binding.tvResult.text = "Result"
        binding.tvScore.text = "Your Score is $score out of $totalQuestions"

        // Tombol Finish
        binding.btnFinish.setOnClickListener {
            finish()  // Menutup Activity
        }

        // Tombol Back
        binding.btnBack.setOnClickListener {
            onBackPressed()  // Kembali ke activity sebelumnya
        }
    }
}

