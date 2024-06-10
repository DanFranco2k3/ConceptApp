package com.example.conceptapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Launchscreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 5100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launchscreen)
        android.os.Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },  SPLASH_TIME_OUT)
    }
}