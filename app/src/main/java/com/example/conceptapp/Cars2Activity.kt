package com.example.conceptapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton // Import ImageButton here

class Cars2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cars2_activity)

        // Set click listener for exit button
        findViewById<ImageButton>(R.id.back1Button)?.setOnClickListener {
            finish()
        }
    }
}
