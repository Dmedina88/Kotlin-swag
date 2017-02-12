
package com.grayherring.kotlintest.ui.base

import android.content.Context
import android.widget.Toast

/**
 * Created by davidmedina on 2/10/17 =).
 */
fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()