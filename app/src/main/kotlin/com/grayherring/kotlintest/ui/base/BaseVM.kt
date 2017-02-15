package com.grayherring.kotlintest.ui.base;

import android.databinding.BaseObservable
import com.grayherring.kotlintest.util.ErrorHandler

abstract class BaseVM(errorHandler: ErrorHandler) : ErrorHandler by errorHandler, LifeCycleBindable, BaseObservable()