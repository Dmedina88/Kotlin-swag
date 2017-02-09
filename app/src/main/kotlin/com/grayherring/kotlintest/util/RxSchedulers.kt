package com.grayherring.kotlintest.util

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

val THROTTLE = 300L

fun <T> Observable<T>.applySchedulers(): Observable<T> =
        subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.applyThrottle(): Observable<T> =
        throttleFirst(THROTTLE, TimeUnit.MILLISECONDS)

fun <T> Observable<T>.doAll(): Observable<T> =
        applySchedulers().applyThrottle()

