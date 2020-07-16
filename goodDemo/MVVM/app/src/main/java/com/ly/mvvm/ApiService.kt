package com.ly.mvvm

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    /**
     * 获取代码分类
     */
    @GET("project/tree/json")
    fun getCodeCategory():Single<BaseResponse<List<WCategory>>>
}