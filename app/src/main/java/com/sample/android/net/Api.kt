package com.sample.android.net

import com.sample.android.bean.NetResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Description:接口
 * Remark:
 */
interface Api {
    @GET("/{id}/info")
    suspend fun getApi(
        @Path("id") userId: String,
        @Query("type") type: Int = 1
    ): NetResponse

    @POST("/{id}/info")
    suspend fun postApi(
        @Path("id") userId: String,
        @Body requestBody: RequestBody
    ): NetResponse
}