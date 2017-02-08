package com.grayherring.kotlintest.ui.util

import android.app.Activity
import android.content.Intent
import android.view.KeyEvent
import com.grayherring.kotlintest.util.KeyUpListener

/**
 * Created by davidmedina on 2/8/17 =).
 */
class DebugKeyUpListener : KeyUpListener {
    var index = 0

    override fun onKeyUp(activity: Activity, keyCode: Int, event: KeyEvent) {
        if (keyCode == SEQUENCE[index] && index == SEQUENCE.lastIndex) {
            if (!activity.javaClass.name.equals(DebugViewActivity::class.java.name)) {
                val intent = Intent(activity, DebugViewActivity::class.java)
                activity.startActivity(intent)
            }
        } else if (keyCode == SEQUENCE[index]) {
            index++
        } else {
            index = 0
        }

    }
}

private val SEQUENCE = intArrayOf(
        KeyEvent.KEYCODE_VOLUME_DOWN,
        KeyEvent.KEYCODE_VOLUME_DOWN,
        KeyEvent.KEYCODE_VOLUME_DOWN
)


