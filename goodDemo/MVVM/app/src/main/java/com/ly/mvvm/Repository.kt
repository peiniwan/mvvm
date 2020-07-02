package com.ly.mvvm

class Repository (private val remote: ApiService){

    fun getCodeCategory() = remote.getCodeCategory()

}