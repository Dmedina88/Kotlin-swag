package com.grayherring.kotlintest

import android.app.Activity
import android.app.Application
import android.content.Context
import io.palaima.debugdrawer.timber.data.LumberYard
import timber.log.Timber

/**
 * Created by davidmedina on 2/5/17 =).
 */

class SwagApp : Application() {
     private lateinit var component: SwagAppComponent

    override fun onCreate() {
        super.onCreate()
        component = initComponent()
        component.inject(this)

        val lumberYard = LumberYard.getInstance(this)
        lumberYard.cleanUp()
        Timber.plant(lumberYard.tree())
        Timber.plant(Timber.DebugTree())
    }

    fun getComponent(): SwagAppComponent {
        return component
    }

    private fun initComponent(): SwagAppComponent {
        return SwagAppComponent.Initializer.init(this)
    }

    operator fun get(activity: Activity): SwagApp {
        return activity.application as SwagApp
    }

}

