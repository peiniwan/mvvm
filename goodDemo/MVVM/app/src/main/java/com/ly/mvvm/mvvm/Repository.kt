package com.ly.mvvm.mvvm

import com.ly.mvvm.mvvm.ApiService

class Repository (private val remote: ApiService){

    fun getCodeCategory() = remote.getCodeCategory()

}