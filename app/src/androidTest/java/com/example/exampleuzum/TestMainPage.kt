package com.example.exampleuzum
import android.Manifest
 import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.components.alluresupport.addAllureSupport
import com.kaspersky.components.alluresupport.files.attachViewHierarchyToAllureReport
import com.kaspersky.components.alluresupport.interceptors.step.AllureMapperStepInterceptor
import com.kaspersky.components.alluresupport.withAllureSupport
import com.kaspersky.kaspresso.annotations.ScreenShooterTest
import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.ScreenshotParams
import com.kaspersky.kaspresso.params.VideoParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.testcases.api.testcaserule.TestCaseRule
import com.kaspersky.kaspresso.testcases.models.info.TestInfo

import org.junit.Rule
import org.junit.Test
import java.io.File
import java.util.*

class TestMainPage : TestCase(
    kaspressoBuilder = Kaspresso.Builder.simple(
        customize = {
            videoParams = VideoParams(bitRate = 10_000_000)
            screenshotParams = ScreenshotParams(quality = 1)
        }
    ).addAllureSupport().apply {
        testRunWatcherInterceptors.apply {
            add(object : TestRunWatcherInterceptor {
                override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
                    viewHierarchyDumper.dumpAndApply("ViewHierarchy") { attachViewHierarchyToAllureReport() }
                }
            })
        }
        }
            ){

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
        step("test1"){
           ContinuouslyScreen {
               startButton {
                   selectTab(1)
                   isVisible()
                  // captureScreenshot("First step")
                   Thread.sleep(2000)
               }
           }
       }


        step("Change locale to russian") {
            device.language.switchInApp(Locale("uz","UZ"))
            // it's so important to reload current active Activity
            // you can do it recreating the activity or manipulating in the Application through great Kaspresso
            activityScenarioRule.scenario.onActivity { activity ->
                activity.recreate()
            }
            Thread.sleep(2000)
        }

        step("вЫБОР ПОСЛЕДНЕГО ПУНКТА "){
        ContinuouslyScreen {
            startButton {
                selectTab(4)
                //captureScreenshot("Second step")
                Thread.sleep(2000)
                isDisplayed()
            }
        }
    }
    }
}

