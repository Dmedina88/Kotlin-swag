package com.grayherring.kotlintest.ui.home

import android.app.Activity
import android.content.Context
import com.grayherring.kotlintest.dagger.PerActivity
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val activity: HomeActivity) {

    @Provides @PerActivity internal fun provideContext(): Context {
        return activity
    }

    @Provides @PerActivity internal fun provideActivity(): Activity {
        return activity
    }

}