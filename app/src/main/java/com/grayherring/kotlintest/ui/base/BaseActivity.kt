package com.grayherring.kotlintest.ui.base

import android.os.Bundle
import android.view.KeyEvent
import com.grayherring.kotlintest.util.ErrorHandler
import com.grayherring.kotlintest.util.KeyUpListener
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : RxAppCompatActivity(), ErrorHandler {


    @Inject lateinit internal var keyUpListener: KeyUpListener
    @Inject lateinit internal var errorHandler: ErrorHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeDependencyInjector()
    }

    override fun logError(error: Throwable) {
        errorHandler.logError(Throwable())
    }

    protected abstract fun initializeDependencyInjector()

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        keyUpListener.onKeyUp(this, keyCode, event)
        return super.onKeyUp(keyCode, event)
    }

    //protected abstract fun layoutId(): Int

}
