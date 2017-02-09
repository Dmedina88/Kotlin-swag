package com.grayherring.kotlintest.util

import android.content.SharedPreferences

/**
 * Created by David Medina.
 */
class StringPreferences(val preferences: SharedPreferences,
                        val key: String,
                        val defaultValue: String = "") {

  fun delete() {
    preferences.edit().remove(key).apply()
  }

  fun isIt(): String {
    return preferences.getString(key, defaultValue)
  }

  fun isSet(): Boolean {
    return preferences.contains(key)
  }

  fun set(value: Boolean) {
    preferences.edit().putBoolean(key, value).apply()
  }
}