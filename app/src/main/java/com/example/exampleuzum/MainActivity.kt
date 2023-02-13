package com.example.exampleuzum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    val SPLASH_SCREEN = 5000
    private lateinit var bottomAnim: Animation
    private lateinit var topAnim: Animation
    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams
                .FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim)
        progressBar = findViewById(R.id.progresssBar)
        progressBar.visibility = View.GONE
        imageView = findViewById(R.id.uzum_logo)
        imageView.animation = topAnim

        Handler(Looper.getMainLooper()).postDelayed({
            progressBar.visibility = View.VISIBLE
        }, 1000)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this, MainPage::class.java))
                finish()
            }, SPLASH_SCREEN.toLong()
        )
    }
}