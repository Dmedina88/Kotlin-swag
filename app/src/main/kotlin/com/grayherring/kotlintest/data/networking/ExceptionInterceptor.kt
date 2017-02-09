package com.grayherring.kotlintest

import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import java.io.IOException

class ExceptionInterceptor(val moshi: Moshi) : Interceptor {

  @Throws(IOException::class)
  override fun intercept(chain: Interceptor.Chain?): Response {
    val request = chain?.request()
    val response = chain?.proceed(request)
    Timber.i(response.toString())
    return response!!
  }

}