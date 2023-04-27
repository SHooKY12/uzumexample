package com.example.exampleuzum.screens

import com.kaspersky.components.kautomator.component.bottomnav.UiBottomNavigationView
import com.kaspersky.components.kautomator.screen.UiScreen

object BottomNavTest : UiScreen<BottomNavTest>(){
    override val packageName: String = "com.example.exampleuzum"
    val bottomNav = UiBottomNavigationView {withId(this@BottomNavTest.packageName, "bottom_navigation_view")}
}