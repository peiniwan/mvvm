package com.ly.mvvm

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.android.logger.AndroidLogger

class MyApp : Application() {
    companion object {
        lateinit var appContext: Application
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        startKoin(this, appModule, logger = AndroidLogger(showDebug = BuildConfig.DEBUG))
    }


}