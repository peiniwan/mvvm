package com.ly.mvvm.mvvm.bean


open class BaseResponse<T> {
    /**
     * sucess : 1
     * message : 成功登录
     * data :
     */

    var errorCode: Int = 0
    var errorMsg: String? = null
    var data: T? = null
}