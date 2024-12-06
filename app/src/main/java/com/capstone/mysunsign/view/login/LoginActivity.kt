package com.capstone.mysunsign.view.login

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.capstone.mysunsign.MainActivity
import com.capstone.mysunsign.R
import com.capstone.mysunsign.view.signup.SignupActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // Ganti dengan nama file XML Anda

        // Inisialisasi elemen UI
        val btnBack: ImageView = findViewById(R.id.btnBack)
        val edtEmail: EditText = findViewById(R.id.edtEmail)
        val edtPassword: EditText = findViewById(R.id.edtPassword)
        val tvForgotPassword: TextView = findViewById(R.id.tvForgotPassword)
        val btnSignIn: Button = findViewById(R.id.btnSignIn)
        val btnGoogle: ImageButton = findViewById(R.id.btnGoogle)
        val tvSignUp: TextView = findViewById(R.id.tvSignUp)

        // Tombol kembali
        btnBack.setOnClickListener {
            onBackPressed() // Menutup aktivitas dan kembali ke halaman sebelumnya
        }

        // Tombol Login
        btnSignIn.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            // Validasi input pengguna
            when {
                email.isEmpty() -> {
                    edtEmail.error = "Email is required"
                }
                password.isEmpty() -> {
                    edtPassword.error = "Password is required"
                }
                else -> {
                    // Lakukan proses login (Tambahkan logika autentikasi Anda di sini)
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                    // Navigasi ke halaman utama atau dashboard
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }

        // Tombol Sign Up (navigasi ke halaman registrasi)
        tvSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Tombol Forgot Password
        tvForgotPassword.setOnClickListener {
            // Logika untuk reset password atau navigasi ke halaman terkait
            Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
        }

        // Tombol Google (Tambahkan logika untuk login dengan Google)
        btnGoogle.setOnClickListener {
            Toast.makeText(this, "Google Sign-In is not implemented yet", Toast.LENGTH_SHORT).show()
        }
    }
}
