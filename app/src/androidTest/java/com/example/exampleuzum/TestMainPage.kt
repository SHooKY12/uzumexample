package com.example.exampleuzum

import android.Manifest
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.example.exampleuzum.screens.ClickHeartForSave
import com.example.exampleuzum.screens.HorizontalBannerScreen
import com.example.exampleuzum.screens.RecyclerScreen
import com.kaspersky.components.alluresupport.interceptors.testrun.DumpLogcatTestInterceptor
import com.kaspersky.components.alluresupport.interceptors.testrun.ScreenshotTestInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.annotations.ScreenShooterTest
import com.kaspersky.kaspresso.interceptors.watcher.testcase.impl.views.DumpViewsInterceptor
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.ScreenshotParams
import com.kaspersky.kaspresso.params.VideoParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import java.util.*

class TestMainPage : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport(
        customize = {
            videoParams = VideoParams(bitRate = 10_000_000)
            screenshotParams = ScreenshotParams(quality = 1)
        }
    ).apply {
        testRunWatcherInterceptors.addAll(
            listOf(
                DumpLogcatTestInterceptor(logcatDumper),
                ScreenshotTestInterceptor(screenshots),
                DumpViewsInterceptor(viewHierarchyDumper)
            )
        )
    }
) {

    @get:Rule

    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

//    @get:Rule
//    val ef = AllureMapperStepInterceptor()
//    val testCaseRule = TestCaseRule(
//        testClassName = javaClass.simpleName,
//        kaspressoBuilder = Kaspresso.Builder.withAllureSupport {
//            videoParams = VideoParams(bitRate = 10_000_000)
//            screenshotParams = ScreenshotParams(quality = 1)
//        }
//    )

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainPage>()

    @ScreenShooterTest
    @Test
    fun beginTest() = run {
        step("test1") {
            ContinuouslyScreen {
                startButton {
                    selectTab(1)
                    isVisible()
                    // captureScreenshot("First step")
                    Thread.sleep(2000)
                }
            }
        }

        step("Check RecyclerView Elements") {
            RecyclerScreen {
                recycler { scrollTo(10) }
                Thread.sleep(5000)
                element0 { isDisplayed() }

                recycler { scrollTo(14) }
                Thread.sleep(5000)
                element14 { isDisplayed() }

                recycler { scrollTo(1) }
                Thread.sleep(5000)
                element29 { isDisplayed() }
            }
        }


        step("SelectWish and check isSelected ?") {
            ClickHeartForSave {
                recyclerForWish {
                    childAt<ClickHeartForSave.RecyclerItem>(2) {
                        wishButton.setChecked(true)
                        wishButton.isChecked()
                        Thread.sleep(5000)
                        wishButton.setChecked(false)
                        wishButton.isNotChecked()
                        Thread.sleep(5000)
                    }
                }

            }
        }



        step("Change locale to russian") {
            device.language.switchInApp(Locale("uz", "UZ"))
              // it's so important to reload current active Activity
            // you can do it recreating the activity or manipulating in the Application through great Kaspresso
            activityScenarioRule.scenario.onActivity { activity ->
                activity.recreate()
            }
            Thread.sleep(2000)
        }

        step("вЫБОР ПОСЛЕДНЕГО ПУНКТА ") {
            ContinuouslyScreen {
                startButton {
                    selectTab(2)
                    //captureScreenshot("Second step")
                    Thread.sleep(2000)
                    isDisplayed()
                }
            }
        }

        step("Swipe Banners") {
            HorizontalBannerScreen {
                val RANGE = 0..2
                recyclerHorizontalBanner {
                    RANGE.forEach { _ ->
                        swipeLeft()
                        Thread.sleep(2000)
                    }
                }
            }
        }
    }
}

