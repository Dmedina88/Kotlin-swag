package com.grayherring.kotlintest.util

import android.app.Activity
import android.view.KeyEvent

/**
 * Created by davidmedina on 2/5/17 =).
 */
interface KeyUpListener {

    abstract fun onKeyUp(activity: Activity, keyCode: Int, event: KeyEvent)

}