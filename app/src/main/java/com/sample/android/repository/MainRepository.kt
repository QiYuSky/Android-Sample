package com.sample.android.repository

import com.sample.android.net.Api
import javax.inject.Inject

/**
 * Description:数据仓库
 * Remark:
 */
class MainRepository @Inject constructor(
    private val mApi: Api
) {
    suspend fun getInfo(userId: String, type: Int) {
        mApi.getApi(userId, type)
    }
}