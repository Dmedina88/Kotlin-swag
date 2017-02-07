package com.grayherring.kotlintest.util

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

fun <T> Observable<T>.applySchedulers(): Observable<T> =
     subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())


