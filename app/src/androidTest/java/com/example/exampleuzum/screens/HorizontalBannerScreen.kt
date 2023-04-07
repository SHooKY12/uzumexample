package com.example.exampleuzum.screens

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.exampleuzum.MainPage
import com.kaspersky.kaspresso.screens.KScreen
import com.example.exampleuzum.R
import fragmentsPages.FrangmentPopularInMainPage
import io.github.kakaocup.kakao.recycler.KRecyclerView

object HorizontalBannerScreen : KScreen<HorizontalBannerScreen>() {
    override val layoutId = R.layout.activity_main_page
    override val viewClass: Class<*> = MainPage::class.java

    val recyclerHorizontalBanner = KRecyclerView(builder = { withId(R.id.rvBanners) }, {})

}