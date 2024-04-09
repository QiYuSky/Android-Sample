package com.sample.android.net

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Description:接口日志过滤器
 * Remark:
 */
internal class ApiLogInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        return response
    }
}