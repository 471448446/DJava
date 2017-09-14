package better.kotlin.learn.`object`

import better.kotlin.log
import better.kotlin.logPart

interface CallBackOne {

    fun onClick(msg: String)
}

/**
 * 对象表达式
 * Created by better on 2017/8/8.
 */
abstract class CallBackOneAbs(var name: String) {
    abstract fun onClick(msg: String, name: String)
}

open class View {
    //也是一个object
    companion object:Any() {
        var tag = "View"
    }

    fun setOnClick(l: CallBackOne) {
        log("设置回调")
        l.onClick("回调")
    }

    fun setOnClickPlus(l: CallBackOneAbs) {
        log("设置回调Plus")
        l.onClick("回调Plus", l.name)
    }

    fun setOnClickInJava(l: CallBackOneInJava) {
        log("设置Java的ASM接口")
        l.OnClick("Hello")
    }

    fun setOnClickAbsInJava(l: CallBackOneAbdInJava) {
        log("设置Java的抽象函数")
        l.OnClick("Hello")
    }

    fun setOnClickAll(l: (s: String) -> Unit) {
        log("设置高阶函数")
        l.invoke("Hello")
    }
}

object Singleton {
    init {
        log("初始化单列对象")
    }

    var A: String = "default value"
}

fun main(args: Array<String>) {
    logPart("对象表达式")
    var v = SingletonView
    v.setOnClick(object : CallBackOne {
        override fun onClick(msg: String) {
        }
    })
    v.setOnClickPlus(object : CallBackOneAbs("Name") {
        override fun onClick(msg: String, name: String) {
        }
    })
    v.setOnClickInJava(object : CallBackOneInJava {
        override fun OnClick(msg: String?) {
        }
    })
    v.setOnClickAbsInJava(object : CallBackOneAbdInJava() {
        override fun OnClick(msg: String?) {

        }
    })
    //lambda
//    v.setOnClick(CallBackOne { view: String -> log("") })
//    v.setOnClickPlus(CallBackOneAbs { view: String, name: String -> log("") })
    v.setOnClickInJava(CallBackOneInJava { msg -> log("接受回调 Lambda$msg") })
    v.setOnClickInJava(CallBackOneInJava { msg -> log("接受回调 Lambda$msg") })
//    v.setOnClickAbsInJava(CallBackOneAbdInJava {})
    logPart("单列")
    val a = Singleton
    log("__" + a.A)
    val b = Singleton
    b.A = "改变值B"
    log("__" + b.A)
}