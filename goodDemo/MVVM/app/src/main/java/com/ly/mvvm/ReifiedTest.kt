package com.ly.mvvm

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import com.google.gson.Gson

private fun <T : Activity> Activity.startActivity(context: Context, clazz: Class<T>) {
    startActivity(Intent(context, clazz))
}


inline fun <reified T : Activity> Activity.startActivity(context: Context) {
    startActivity(Intent(context, T::class.java))
}

//    fun <T> Bundle.getDataOrNull(): T? {
//        return getSerializable("DATA_KEY") as? T
//    }

fun <T> Bundle.getDataOrNull(clazz: Class<T>): T? {
    val data = getSerializable("DATA_KEY")
    return if (clazz.isInstance(data)) {
        data as T
    } else {
        null
    }
}


inline fun <reified T> Bundle.getDataOrNull(): T? { //简化泛型参数和保证 as? 类型转换安全性
    return getSerializable("DATA_KEY") as? T
}

//实现一个函数计算 DP 到像素，并返回一个 Int 或 Float
//函数重载方式只能根据参数计数和类型不同，而不能根据返回类型。
//    fun Resources.dpToPx(value: Int): Float {
//        return TypedValue.applyDimension(
//            TypedValue.COMPLEX_UNIT_DIP,
//            value.toFloat(), displayMetrics)
//    }
//
//    fun Resources.dpToPx(value: Int): Int {
//        val floatValue: Float = dpToPx(value)
//        return floatValue.toInt()
//    }

inline fun <reified T> Resources.dpToPx(value: Int): T {
    val result = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value.toFloat(), displayMetrics
    )

    return when (T::class) {
        Float::class -> result as T
        Int::class -> result.toInt() as T
        else -> throw IllegalStateException("Type not supported")
    }
}


inline fun <reified T> Gson.fromJson(json: String) =
    fromJson(json, T::class.java)

// fun <T> Gson.fromJson2(json: String) :T=
//    fromJson(json, T.class.java)

//fun newInstance(param: Int): ActyFragment {
//    val fragment = ActyFragment()
//    val args = Bundle()
//    args.putInt(PARAMS, param)
//    fragment.arguments = args
//    return fragment
//}


inline fun <reified F : Fragment> Context.newFragment(vararg args: Pair<String, String>): F {
    val bundle = Bundle()
    args.let {
        for (arg in args) {
            bundle.putString(arg.first, arg.second)
        }
    }
    return Fragment.instantiate(this, F::class.java.name, bundle) as F
}



