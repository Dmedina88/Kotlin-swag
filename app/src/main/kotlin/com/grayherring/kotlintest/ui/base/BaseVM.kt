package com.grayherring.kotlintest.ui.base;

import android.databinding.BaseObservable
import com.grayherring.kotlintest.util.ErrorHandler
import javax.inject.Inject

abstract class BaseVM : ErrorHandler, LifeCycleBindable, BaseObservable() {

  @Inject lateinit internal var errorHandler: ErrorHandler

  override fun logError(error: Throwable) {
    errorHandler.logError(Throwable())
  }

}