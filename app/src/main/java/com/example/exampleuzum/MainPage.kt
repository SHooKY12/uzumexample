package com.example.exampleuzum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.coordinatorlayout.widget.CoordinatorLayout

class MainPage : AppCompatActivity() {
    private lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        searchView = findViewById(R.id.SearchViewInMainPage)
        searchView.isFocusable = false
        searchView.setOnQueryTextFocusChangeListener { v, hasFocus ->
            if (hasFocus){
                searchView.setBackgroundResource(R.drawable.search_view_background_focused)
            }
             else{
                 searchView.setBackgroundResource(R.drawable.searchview_background)
             }
        }

    }
}