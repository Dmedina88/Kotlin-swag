package com.grayherring.kotlintest

import android.app.Application
import com.grayherring.kotlintest.dagger.PerApp
import dagger.Module
import dagger.Provides

/**
 * Created by davidmedina on 2/5/17 =).
 */
@Module
class SwagModule(private val app: SwagApp) {

    @Provides @PerApp internal fun provideApplication(): Application {
        return app
    }

}