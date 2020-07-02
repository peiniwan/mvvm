package com.ly.mvvm

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {

    /**
     * 获取代码分类
     */
    @GET("project/tree/json")
    fun getCodeCategory():Single<BaseResponse<List<WCategory>>>
}