package com.grayherring.kotlintest.ui.base

import android.view.View
import com.grayherring.kotlintest.util.applyThrottle
import com.jakewharton.rxbinding.view.clicks

fun View.throttleClick()=
    clicks().applyThrottle()
