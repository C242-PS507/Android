package com.capstone.mysunsign.view.signup

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.capstone.mysunsign.R
import com.capstone.mysunsign.view.login.LoginActivity

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup) // Ganti dengan nama file XML Anda

        // Inisialisasi elemen UI
        val btnBack: ImageView = findViewById(R.id.btnBack)
        val edtEmail: EditText = findViewById(R.id.edtEmail)
        val edtPassword: EditText = findViewById(R.id.edtPassword)
        val edtConfirmPassword: EditText = findViewById(R.id.edtConfirmPassword)
        val btnSignUp: Button = findViewById(R.id.btnSignUp)
        val btnGoogle: ImageButton = findViewById(R.id.btnGoogle)
        val tvSignIn: TextView = findViewById(R.id.tvSignIn)

        // Tombol kembali
        btnBack.setOnClickListener {
            onBackPressed() // Menutup aktivitas dan kembali ke halaman sebelumnya
        }

        // Tombol Sign Up
        btnSignUp.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            val confirmPassword = edtConfirmPassword.text.toString()

            // Validasi input pengguna
            when {
                email.isEmpty() -> {
                    edtEmail.error = "Email is required"
                }
                password.isEmpty() -> {
                    edtPassword.error = "Password is required"
                }
                confirmPassword.isEmpty() -> {
                    edtConfirmPassword.error = "Please confirm your password"
                }
                password != confirmPassword -> {
                    edtConfirmPassword.error = "Passwords do not match"
                }
                else -> {
                    // Lakukan proses registrasi (Tambahkan logika Anda di sini)
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

                    // Navigasi ke halaman utama atau login
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }

        // Tombol Sign In (navigasi ke halaman login)
        tvSignIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Tombol Google (Tambahkan logika untuk login dengan Google)
        btnGoogle.setOnClickListener {
            Toast.makeText(this, "Google Sign-In is not implemented yet", Toast.LENGTH_SHORT).show()
        }
    }
}
