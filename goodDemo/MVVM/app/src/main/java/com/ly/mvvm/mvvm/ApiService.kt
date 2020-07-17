package com.ly.mvvm.mvvm

import com.ly.mvvm.mvvm.bean.BaseResponse
import com.ly.mvvm.mvvm.bean.WCategory
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    /**
     * 获取代码分类
     */
    @GET("project/tree/json")
    fun getCodeCategory():Single<BaseResponse<List<WCategory>>>
}