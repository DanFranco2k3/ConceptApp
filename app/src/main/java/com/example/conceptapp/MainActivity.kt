package com.example.conceptapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    // Variables
    private lateinit var editText: EditText
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var mcqueen: ImageButton
    private lateinit var sally: ImageButton
    private lateinit var tow: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Attributes
        editText = findViewById(R.id.username)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // ImageButtons
        mcqueen = findViewById(R.id.mcqueen)
        sally = findViewById(R.id.sally)
        tow = findViewById(R.id.tow)

        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.animate)

        mcqueen.setOnClickListener {
            it.startAnimation(scaleAnimation)
            saveProfileAndNavigate(R.id.mcqueen)
        }

        sally.setOnClickListener {
            it.startAnimation(scaleAnimation)
            saveProfileAndNavigate(R.id.sally)
        }

        tow.setOnClickListener {
            it.startAnimation(scaleAnimation)
            saveProfileAndNavigate(R.id.tow)
        }
    }

    private fun saveProfileAndNavigate(profileId: Int) {
        val inputText = editText.text.toString()
        val editor = sharedPreferences.edit()
        editor.putString("username", inputText)
        editor.putInt("profile", profileId)
        editor.apply()

        val intent = Intent(this, HomeScreen::class.java)
        startActivity(intent)
    }
}
