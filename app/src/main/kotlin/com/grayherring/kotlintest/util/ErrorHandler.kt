package com.grayherring.kotlintest.util

import timber.log.Timber

/**
 * Created by David Medina.
 */
interface ErrorHandler {
  companion object : ErrorHandler {
    override fun logError(error: Throwable) {
      Timber.e(error.toString(), error)
    }
  }

  fun logError(error: Throwable)
}
