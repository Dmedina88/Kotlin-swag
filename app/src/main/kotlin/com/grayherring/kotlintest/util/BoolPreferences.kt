package com.grayherring.kotlintest.util

import android.content.SharedPreferences

/**
 * Created by David Medina.
 */
class BoolPreferences(val preferences: SharedPreferences,
                      val key: String,
                      val defaultValue: Boolean = false) {

  fun delete() {
    preferences.edit().remove(key).apply()
  }

  fun isIt(): Boolean {
    return preferences.getBoolean(key, defaultValue)
  }

  fun isSet(): Boolean {
    return preferences.contains(key)
  }

  fun set(value: Boolean) {
    preferences.edit().putBoolean(key, value).apply()
  }
}