package com.example.benchmark

import android.content.Context
import android.content.res.Resources
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * This is an example startup benchmark.
 *
 * It navigates to the device's home screen, and launches the default activity.
 *
 * Before running this benchmark:
 * 1) switch your app's active build variant in the Studio (affects Studio runs only)
 * 2) add `<profileable android:shell="true" />` to your app's manifest, within the `<application>` tag
 *
 * Run this benchmark from Studio to see startup measurements, and captured system traces
 * for investigating your app's performance.
 */
@RunWith(AndroidJUnit4::class)
class ExampleStartupBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startup() = benchmarkRule.measureRepeated(
        packageName = "com.example.xmlandmacrobenchmark",
        metrics = listOf(StartupTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD
    ) {
        pressHome()
        startActivityAndWait()
    }
    @Test

    fun scrollAndNavigate() = benchmarkRule.measureRepeated(
        packageName = "com.example.xmlandmacrobenchmark",

        //  packageName = "com.plcoding.baselineprofilemacrobenchmark",

        metrics = listOf(FrameTimingMetric()),

        iterations = 1,

        startupMode = StartupMode.COLD

    ) {

        pressHome()

        startActivityAndWait()
        addElementsAndScrollDown()

    }
    private fun MacrobenchmarkScope.addElementsAndScrollDown() {
        //find button by text
        val button = device.findObject(By.text("Click-Me"))

        //find list by tag

        val list = device.findObject(By.res("itemArray"))
        repeat(30){

            button.click()

        }

        device.waitForIdle()
        list.setGestureMargin(device.displayWidth / 5)// for sling down gesture margin
        list.fling(Direction.DOWN)
        device.findObject(By.text("5")).click()


        device.wait(Until.hasObject(By.text("Detail: Element-29")),5000)

    }



}