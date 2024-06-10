package com.example.conceptapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeScreen : AppCompatActivity() {

    private lateinit var greetingTextView: TextView
    private lateinit var profileImageView: ImageView
    private lateinit var infoButton: ImageButton
    private lateinit var backButton: ImageButton
    private lateinit var cars1Button: ImageButton
    private lateinit var cars2Button: ImageButton
    private lateinit var cars3Button: ImageButton
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        // Initialize views
        greetingTextView = findViewById(R.id.greetingTextView)
        profileImageView = findViewById(R.id.profileImageView)
        infoButton = findViewById(R.id.infoButton)
        backButton = findViewById(R.id.backButton)
        cars1Button = findViewById(R.id.cars1Button)
        cars2Button = findViewById(R.id.cars2Button)
        cars3Button = findViewById(R.id.cars3Button)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Retrieve data from SharedPreferences
        val username = sharedPreferences.getString("username", "User")
        val profileId = sharedPreferences.getInt("profile", R.id.mcqueen)

        // Set the greeting text
        greetingTextView.text = "Hello, $username."

        // Set the profile image
        when (profileId) {
            R.id.mcqueen -> profileImageView.setImageResource(R.drawable.mcqueen)
            R.id.sally -> profileImageView.setImageResource(R.drawable.sally)
            R.id.tow -> profileImageView.setImageResource(R.drawable.tow)
        }

        // Set click listeners
        setClickListener(infoButton) { showPopup(infoButton) }
        setClickListener(backButton) { onBackPressed() }
        setClickListener(cars1Button) {
            startActivity(Intent(this, Cars1Activity::class.java))
            animateButton(cars1Button)
        }
        setClickListener(cars2Button) {
            startActivity(Intent(this, Cars2Activity::class.java))
            animateButton(cars2Button)
        }
        setClickListener(cars3Button) {
            startActivity(Intent(this, Cars3Activity::class.java))
            animateButton(cars3Button)
        }
    }

    private fun setClickListener(view: View, onClick: () -> Unit) {
        view.setOnClickListener {
            onClick()
        }
    }

    private fun showPopup(anchorView: View) {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_info, null)

        val popupWidth = ViewGroup.LayoutParams.WRAP_CONTENT
        val popupHeight = ViewGroup.LayoutParams.WRAP_CONTENT

        val popupWindow = PopupWindow(popupView, popupWidth, popupHeight, true)

        popupWindow.elevation = 10.0f

        popupWindow.showAsDropDown(anchorView, 0, 10)
    }

    private fun animateButton(button: ImageButton) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.button_scale_animation)
        button.startAnimation(animation)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
