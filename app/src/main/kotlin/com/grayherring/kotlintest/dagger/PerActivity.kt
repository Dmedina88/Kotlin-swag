package com.grayherring.kotlintest.dagger

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * Created by davidmedina on 2/12/17 =).
 */
@Scope
@Retention(RUNTIME)
annotation class PerActivity
