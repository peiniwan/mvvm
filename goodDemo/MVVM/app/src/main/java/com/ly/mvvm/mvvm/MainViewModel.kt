package com.ly.mvvm.mvvm

import android.arch.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainViewModel(private val repo: Repository) : ViewModel() {
    private lateinit var disposable: Disposable
    fun getCodeCategories() {
//        var retrofit = Retrofit.Builder()
//            .baseUrl("https://www.wanandroid.com/")
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        var apiService = retrofit.create(ApiService::class.java)
//        var repo=Repository(apiService)

        disposable = repo.getCodeCategory().async().subscribe { result ->
            result.data
        }
    }

    fun <T> Single<T>.async(withDelay: Long = 0): Single<T> =
        this.subscribeOn(Schedulers.io()).apply {
            if (withDelay > 0) {
                delay(withDelay, TimeUnit.MILLISECONDS)
            }
        }.observeOn(AndroidSchedulers.mainThread())

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}