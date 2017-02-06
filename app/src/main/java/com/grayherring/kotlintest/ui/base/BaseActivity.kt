package com.grayherring.kotlintest.ui.base

import android.os.Bundle
import com.grayherring.kotlintest.util.ErrorHandler
import com.grayherring.kotlintest.util.KeyUpListener
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

abstract class BaseActivity : RxAppCompatActivity(), ErrorHandler {


    //@Inject internal var keyUpListener: KeyUpListener? = null
    //@Inject internal var errorHandler: ErrorHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeDependencyInjector()

    }

    override fun logError(error: Throwable) {
        Timber.e(error.message)
    }

    protected abstract fun initializeDependencyInjector()

}
