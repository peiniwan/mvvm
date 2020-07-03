package com.ly.mvvm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mViewModel: MainViewModel by viewModel()
//    private val mViewModel: MainViewModel by lazy {
//        ViewModelProviders.of(this).get(MainViewModel::class.java)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvClick).setOnClickListener {
            mViewModel.getCodeCategories()

        }

    }
}