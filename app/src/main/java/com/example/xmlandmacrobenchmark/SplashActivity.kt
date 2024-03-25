package com.example.xmlandmacrobenchmark

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the layout for the splash screen
        setContentView(R.layout.activity_splash)

        // Delay for SPLASH_DURATION milliseconds and then launch the main activity
        Handler().postDelayed({ // Create an Intent to start the MainActivity
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)

            // Close the splash activity to prevent user from coming back to it
            finish()
        }, SPLASH_DURATION)
    }

    companion object {
        // Splash screen duration in milliseconds
        private const val SPLASH_DURATION: Long = 2000 // 2 seconds
    }
}
