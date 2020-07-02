package com.ly.mvvm

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.android.logger.AndroidLogger

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, appModule, logger = AndroidLogger(showDebug = BuildConfig.DEBUG))
    }


}