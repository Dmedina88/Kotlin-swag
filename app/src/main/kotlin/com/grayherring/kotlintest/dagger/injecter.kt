package com.grayherring.kotlintest.dagger

import android.content.Context

/**
 * Created by davidmedina on 2/12/17 =).
 */
object Injector {

  // Explicitly doing a custom service.
  fun <T> obtain(context: Context, componentClass: Class<T>): T {
    return context.getSystemService(componentClass.name) as T
  }

  fun <T> matchesService(name: String, componentName: Class<T>): Boolean {
    return componentName.name == name
  }
}