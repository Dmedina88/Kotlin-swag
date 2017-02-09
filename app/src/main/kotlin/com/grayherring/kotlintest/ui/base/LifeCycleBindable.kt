package com.grayherring.kotlintest.ui.base

/**
 * Created by davidmedina on 2/9/17 =).
 */
interface LifeCycleBindable {
    fun onCreate(){}
    fun onStart(){}
    fun onResume(){}
    fun onPause(){}
    fun onStop(){}
    fun onDestroy(){}
}