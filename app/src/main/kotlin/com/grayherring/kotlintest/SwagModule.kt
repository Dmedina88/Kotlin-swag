package com.grayherring.kotlintest

import android.app.Application
import com.grayherring.kotlintest.dagger.PerApp
import com.grayherring.kotlintest.ui.util.DebugKeyUpListener
import com.grayherring.kotlintest.util.ErrorHandler
import com.grayherring.kotlintest.util.KeyUpListener
import dagger.Module
import dagger.Provides

/**
 * Created by davidmedina on 2/5/17 =).
 */
@Module
class SwagModule(private val app: SwagApp) {

    @Provides @PerApp fun provideApplication(): Application {
        return app
    }

    @Provides @PerApp fun provideKeyUpListener(): KeyUpListener {
        if (BuildConfig.DEBUG) {
            return DebugKeyUpListener()
        } else {
            return KeyUpListener
        }
    }

    @Provides @PerApp fun provideErrorHandler(): ErrorHandler = ErrorHandler
}