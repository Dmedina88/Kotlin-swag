package com.grayherring.kotlintest.ui.base

import android.os.Bundle
import android.view.KeyEvent
import com.grayherring.kotlintest.SwagApp
import com.grayherring.kotlintest.util.ErrorHandler
import com.grayherring.kotlintest.util.KeyUpListener
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : RxAppCompatActivity(), ErrorHandler {

  @Inject lateinit internal var keyUpListener: KeyUpListener
  @Inject lateinit internal var errorHandler: ErrorHandler

  private val lifeCycleBindables = arrayListOf<LifeCycleBindable>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initializeDependencyInjector()

    for (bindable in lifeCycleBindables) {
      bindable.onCreate()
    }
  }

  override fun logError(error: Throwable) {
    errorHandler.logError(Throwable())
  }

  protected abstract fun initializeDependencyInjector()

  override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
    keyUpListener.onKeyUp(this, keyCode, event)
    return super.onKeyUp(keyCode, event)
  }

  fun addBindable(lifeCycleBindable: LifeCycleBindable) {
    lifeCycleBindables.add(lifeCycleBindable)
  }

  fun getAppComponent() = (this.application as SwagApp).component

  override fun onResume() {
    for (bindable in lifeCycleBindables) {
      bindable.onResume()
    }
    super.onResume()
  }

  override fun onStart() {
    for (bindable in lifeCycleBindables) {
      bindable.onStart()
    }
    super.onStart()
  }

  override fun onPause() {
    for (bindable in lifeCycleBindables) {
      bindable.onPause()
    }
    super.onPause()
  }

  override fun onStop() {
    for (bindable in lifeCycleBindables) {
      bindable.onStop()
    }
    super.onStop()
  }

  override fun onDestroy() {
    for (bindable in lifeCycleBindables) {
      bindable.onResume()
    }
    super.onDestroy()
  }

}

