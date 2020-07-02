package com.ly.mvvm

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val repoModule = module {
    single { Repository(get()) }
}


val remoteModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }
}

val appModule = listOf(remoteModule, repoModule, viewModelModule)




