package com.example.conceptapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton // Import ImageButton here


class Cars1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cars1_activity)

        // Set click listener for exit button
        findViewById<ImageButton>(R.id.back1Button)?.setOnClickListener {
            finish()
        }
    }
}
