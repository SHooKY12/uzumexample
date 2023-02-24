package com.example.exampleuzum

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnFlingListener
import androidx.recyclerview.widget.SnapHelper
import dataclassesForUse.ImgForBanner

class MainPage : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var imgList = mutableListOf<ImgForBanner>()
    private val adapter = RecylerInMainPageSalesAdapter()
    private lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        recyclerView = findViewById(R.id.rvBanners)
        initArrayImgs()
        adapter.setImages(imgList)
        bindRecycler()
        searchView = findViewById(R.id.SearchViewInMainPage)
        searchView.isFocusable = false
        searchView.setOnQueryTextFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                searchView.setBackgroundResource(R.drawable.search_view_background_focused)
            } else {
                searchView.setBackgroundResource(R.drawable.searchview_background)
            }
        }

    }

    private fun bindRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        recyclerView.onFlingListener = (object: RecyclerView.OnFlingListener(){
            override fun onFling(velocityX: Int, velocityY: Int): Boolean {
                recyclerView.smoothScrollBy(5,0)
               return true
            }
        })
    }


//        recyclerView.addOnScrollListener()





    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initArrayImgs() {

        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img1), "img1"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img6), "img2"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img3), "img3"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img4), "img4"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img5), "img5"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img7), "img1"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img8), "img2"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img9), "img3"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img10), "img4"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img11), "img5"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img12), "img1"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img13), "img2"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img3), "img3"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img4), "img4"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img5), "img5"))
    }
}