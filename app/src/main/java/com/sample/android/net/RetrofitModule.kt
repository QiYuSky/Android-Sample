package com.sample.android.net

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier

/**
 * Description:网络访问提供模块
 * Remark:
 */
@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun createRetrofit(@DebugOkHttpClient client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(ApiModule.BASE_URL_DEBUG)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build()


    @DebugOkHttpClient
    @Provides
    fun createDebugOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .retryOnConnectionFailure(true)                             //连接失败后是否重连
        .connectTimeout(60, TimeUnit.SECONDS)                       //链接超时时间
        .addInterceptor(ApiLogInterceptor())                        //日志过滤器
        .build()


    @ReleaseOkHttpClient
    @Provides
    fun createReleaseOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DebugOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ReleaseOkHttpClient
