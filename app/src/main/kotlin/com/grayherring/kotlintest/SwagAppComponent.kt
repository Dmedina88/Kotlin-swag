package com.grayherring.kotlintest

import com.grayherring.kotlintest.dagger.PerApp
import com.grayherring.kotlintest.data.networking.ApiModule
import com.grayherring.kotlintest.ui.home.HomeComponent
import com.grayherring.kotlintest.ui.home.HomeModule
import com.grayherring.kotlintest.ui.util.DebugViewActivity
import dagger.Component

@PerApp
@Component(modules = arrayOf(SwagModule::class, DataModule::class, ApiModule::class))
interface SwagAppComponent {

  fun inject(app: SwagApp)

  operator fun plus(module: HomeModule): HomeComponent

  class Initializer private constructor() {
    init {
      throw AssertionError("No instances.")
    }

    companion object {
      fun init(app: SwagApp): SwagAppComponent {
        return DaggerSwagAppComponent.builder()
            .swagModule(SwagModule(app))
            .dataModule(DataModule())
            .apiModule(ApiModule())
            .build()
      }
    }
  }

  fun inject(app: DebugViewActivity)

}

