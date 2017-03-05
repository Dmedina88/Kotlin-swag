package com.grayherring.kotlintest

import android.app.Activity
import android.app.Application
import io.palaima.debugdrawer.timber.data.LumberYard
import timber.log.Timber


class SwagApp : Application() {
  companion object{
    fun get(activity: Activity): SwagApp {
      return activity.application as SwagApp
    }
  }

  val component = initComponent()

  override fun onCreate() {
    super.onCreate()
    component.inject(this)

    val lumberYard = LumberYard.getInstance(this)
    lumberYard.cleanUp()
    Timber.plant(lumberYard.tree())
    Timber.plant(Timber.DebugTree())
  }

  private fun initComponent(): SwagAppComponent {
    return SwagAppComponent.Initializer.init(this)
  }



}

