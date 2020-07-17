package com.ly.mvvm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.google.gson.Gson
import com.ly.mvvm.mvp.MySimplePresenter
import com.ly.mvvm.mvvm.MainViewModel
import com.ly.mvvm.mvvm.bean.WCategory
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val mViewModel: MainViewModel by viewModel()
//    private val mViewModel: MainViewModel by lazy {
//        ViewModelProviders.of(this).get(MainViewModel::class.java)
//    }

    //    val firstPresenter by inject<MySimplePresenter>()
    val firstPresenter: MySimplePresenter by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvClick).setOnClickListener {
            mViewModel.getCodeCategories()
        }

        firstPresenter.sayHello()


//        startActivity(this, NewActivity::class.java)
//        startActivity<NewActivity>(this)

        // Caller
        val bundle: Bundle? = Bundle()
        bundle?.putSerializable("DATA_KEY", "Testing")
//        val strData: String? = bundle?.getDataOrNull(String::class.java)
//        val intData: Int? = bundle?.getDataOrNull(String::class.java) // Null

        val strData2: String? = bundle?.getDataOrNull()
        val intData2: Int? = bundle?.getDataOrNull()

//        val intValue: Int = resource.dpToPx(64)

//        var json=""
//        val wCategory: WCategory = Gson().fromJson(json)
//        val wCategory1 = Gson().fromJson<WCategory>(json)

    }





}