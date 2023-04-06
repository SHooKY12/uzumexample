package com.example.exampleuzum.screens

import android.view.View
import com.example.exampleuzum.MainPage
import com.example.exampleuzum.R
import com.kaspersky.kaspresso.screens.KScreen
import fragmentsPages.FrangmentPopularInMainPage
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object RecyclerScreen : KScreen<RecyclerScreen>() {
        override val layoutId = R.layout.fragment_frangment_popular_in_main_page
        override val viewClass: Class<*> = FrangmentPopularInMainPage::class.java

       val recycler = KRecyclerView(builder = { withId(R.id.recycler_view_in_frgpopular) }, {})

       val element0 = KTextView { withText("Infinix INBOOK") }
       val element14 = KTextView { withText("Fog Scent Xpressio Perfume") }
       val element29 = KTextView { withText("iPhone 9") }

}


