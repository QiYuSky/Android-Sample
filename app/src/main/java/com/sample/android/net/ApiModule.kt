package com.sample.android.net

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Description:接口提供模块
 * Remark:
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    const val BASE_URL = "https://empty.com"
    const val BASE_URL_DEBUG = "https://debug.empty.com"

    @Singleton
    @Provides
    fun createApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)
}