package com.example.exampleuzum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import fragments_in_bottomMenu.Category_wishes_fragment

class MainPage : AppCompatActivity() {

    private lateinit var bottomNavView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.just_emty_activity)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainPageFragment.newInstance()).commit()
        // инициализация BottomNavigationView
        bottomNavView = findViewById(R.id.bottom_navigation_view)
        bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_wish -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, Category_wishes_fragment.newInstance()).commit()
                    true
                }
                R.id.menu_main -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, MainPageFragment.newInstance()).commit()
                    true
                }
                else -> false
            }
        }
    }
}