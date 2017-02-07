package com.grayherring.kotlintest

import okhttp3.Interceptor
import okhttp3.Response

class ExceptionInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain?): Response {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}