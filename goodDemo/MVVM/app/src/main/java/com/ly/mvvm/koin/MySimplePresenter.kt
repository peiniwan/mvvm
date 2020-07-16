package com.ly.mvvm.koin

import android.widget.Toast
import com.ly.mvvm.MyApp

class MySimplePresenter(val repo: HelloRepository) {

    fun sayHello()  {
        Toast.makeText(MyApp.appContext,"${repo.giveHello()} from MySimplePresenter",Toast.LENGTH_LONG).show()
    }
}