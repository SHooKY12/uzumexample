package com.example.exampleuzum

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton

object ContinuouslyScreen : KScreen<ContinuouslyScreen>() {
    override val layoutId = R.layout.activity_main_page
    override val viewClass = MainPage::class.java

    val startButton = KTabLayout {
        withId(R.id.tableLayoutInMainPage)
    }
}
