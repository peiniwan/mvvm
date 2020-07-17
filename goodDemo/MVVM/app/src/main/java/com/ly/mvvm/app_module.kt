package com.ly.mvvm

import com.ly.mvvm.mvp.HelloRepository
import com.ly.mvvm.mvp.HelloRepositoryImpl
import com.ly.mvvm.mvp.MySimplePresenter
import com.ly.mvvm.mvvm.ApiService
import com.ly.mvvm.mvvm.MainViewModel
import com.ly.mvvm.mvvm.Repository
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val demoModule = module {
    // single instance of HelloRepository
    single<HelloRepository> { HelloRepositoryImpl() }
    // Simple Presenter Factory
    factory { MySimplePresenter(get()) }   //这调用
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val repoModule = module {
    single { Repository(get<ApiService>()) }
}


val remoteModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ApiService> { get<Retrofit>().create(
        ApiService::class.java) }
}




val appModule = listOf(viewModelModule,remoteModule, repoModule,demoModule)




