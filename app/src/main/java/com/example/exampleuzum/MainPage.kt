package com.example.exampleuzum

import android.R.attr
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.SearchView
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dataclassesForUse.ImgForBanner
import fragmentsPages.FragmentNewestInMainPage
import fragmentsPages.FragmentSales
import fragmentsPages.FrangmentPopularInMainPage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.internal.http.RetryAndFollowUpInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MainPage : AppCompatActivity() {
    // Список фрагментов, используемых в ViewPager2
    private val tableItems =
        listOf(
            FragmentSales.newInstance(),
            FrangmentPopularInMainPage.newInstance(),
            FragmentNewestInMainPage.newInstance()
        )
    private lateinit var recyclerView: RecyclerView

    // Список названий для каждого таба в TabLayout
    private var listForTablayoutText = listOf<String>("Распродажа", "Популярные", "Новинки")
    private lateinit var viewPage2: ViewPager2
    private lateinit var swiperRefresher: SwipeRefreshLayout
    private lateinit var tableLayoit: TabLayout
    private var imgList = mutableListOf<ImgForBanner>()

    // Адаптер для RecyclerView с баннерами
    private val adapter = RecylerInMainPageSalesAdapter()
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        // Добавления картинов в список для баннера
        initArrayImgs()
        // Инициализация RecyclerView для баннеров
        recyclerView = findViewById(R.id.rvBanners)
        adapter.setImages(imgList)
        bindRecycler()
        // Инициализация SwipeRefreshLayout и установка Listener
        swiperRefresher = findViewById(R.id.swiperRefresher)
        instalListenerOnSwipeRefresh()
        // Инициализация ViewPager2 и TabLayout
        viewPage2 = findViewById(R.id.placeHolder)
        viewPage2.isUserInputEnabled = false
        tableLayoit = findViewById(R.id.tableLayoutInMainPage)
        initTablayout()
    }

    private fun instalListenerOnSwipeRefresh() {
        swiperRefresher.setOnRefreshListener {
            // Выполнить действия для обновления вашего View
            // Например, загрузить новые данные из сети и обновить список
            swiperRefresher.isRefreshing = false
        }

    }

    // Инициализация TabLayout и ViewPager2
    private fun initTablayout() {
        // Создание адаптера для ViewPager2
        val adapterTabl = TableLayoutAdapter(this, tableItems)
        viewPage2.adapter = adapterTabl

        // Установка настроек TabLayout
        tableLayoit.tabGravity = TabLayout.GRAVITY_FILL

        // Привязка TabLayout к ViewPager2
        TabLayoutMediator(tableLayoit, viewPage2) { tab, pos ->
            tab.text = listForTablayoutText[pos]
        }.attach()
    }

    // Привязка RecyclerView для баннеров
    private fun bindRecycler() {
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        // Установка LinearSnapHelper для плавной прокрутки баннеров
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        // Установка onFlingListener для плавной прокрутки баннеров
        recyclerView.onFlingListener = (object : RecyclerView.OnFlingListener() {
            override fun onFling(velocityX: Int, velocityY: Int): Boolean {
                if (velocityX > 0) recyclerView.smoothScrollBy(700, 0)
                else recyclerView.smoothScrollBy(-700, 0)
                return true
            }
        })
    }
    // Инициализация списка изображений для баннеров
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initArrayImgs() {
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img1), "img1"))
        imgList.add(ImgForBanner(resources.getDrawable(R.drawable.img2), "img2"))
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