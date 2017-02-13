package com.grayherring.kotlintest.dagger

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * Created by davidmedina on 2/12/17 =).
 */
class Qualifiers private constructor() {

  init {
    throw AssertionError("No instances.")
  }

  @Qualifier @Retention(RUNTIME) annotation class API

  @Qualifier @Retention(RUNTIME) annotation class MockPref

  @Qualifier @Retention(RUNTIME) annotation class BookRelay
}
