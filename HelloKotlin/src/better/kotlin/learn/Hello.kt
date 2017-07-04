package better.kotlin.learn

import better.kotlin.learn.bean.Car
import better.kotlin.learn.objects.*
import better.kotlin.log
import better.kotlin.logEnd
import better.kotlin.logStart

/**
 * 可以直接定义一个main函数运行而
 * 在java中我们是需要定义一个类，再在里面申明main函数才行。
 * 1、所以一个kotlin文件是表示的什么，一堆函数的集合？？
 * Created by better on 2017/5/29.
 */
fun main(args: Array<String>) {
    println("Hello Kotlin")
    println("结果=" + sum(1, 2))
    testBoolean()
    testArray()
    testString()
    testIf()
    testWhen()
    testPersion()
}

private fun Man.runExtend(mileal: Double): Unit {
    log("扩展方法 man peopleRun " + mileal)
}

private fun Person.runExtend(mileal: Double): Unit {
    log("扩展方法 Person peopleRun " + mileal)
}

/**
 * 扩展不支持多态
 */
private fun peopleRun(p: Person, mileal: Double) {
    p.runExtend(mileal)
}

fun testPersion() {
    logStart("Person")

    var person: Person = Person("张三", Sex.man, 10)
    var man: Man = Man("李四")

    man.addTalkListener(object : TalkListener {
        override fun onTalk(msg: String) {
            log("接收到回调：" + msg)
        }

    })

    var car: Car = Car("宝马", 10.0)
    log("准备了一个车子：" + car.toString())
    man.buyCar(car)
    man.talk("我刚刚买了一个车")
    peopleRun(man, 1.0)
    log(person.toString())

    logEnd("Person")
}

fun testWhen() {
    logStart("testWhen")
    var all = 3
    while (all > 0) {
        log("while 循环," + all)
        all--
    }
    var b = when (all) {
        1 -> {
            log(" when 1")
            10
        }
        else -> {
            log("when else")
            20
        }
    }
    log("b=$b")
    logEnd("testWhen")
}

fun testIf() {
    var a = 10
    var b = 20
    var c = if (a > b) {
        a
    } else {
        b
    }
    var d = if (a > b) a else b
    logStart("testIf")
    log("c=$c,d等于20？=${d == b}")
    logEnd("testIf")
}

fun testString() {
    var s = "hello 换行\n"
    var orignale = """ 没有转义字符串的就 是原生字符串
"""
    logStart("字符串字面值")
    log(s)
    log(s.trim())
    log(orignale)
    log(orignale.trim())
    logEnd("字符串字面值")
}

fun testArray() {
    /**
     * 创建数组
     */
    var array: Array<Int> = arrayOf(1, 2, 3)
    /**
     * 穿件一个3个长度的空数组
     */
    var array2 = arrayOfNulls<Int>(3)
    /**
     * 指定大小，并指定每个位置的初始值
     */
    var array3 = Array<Int>(5, { i -> (i + 2) })

    array2.set(0, 10)
    array2[0] = 10
    log("数组start")
    log(array.toString())
    log(array2.toString())
    log(array3.toString())
    log("数组end")

}

fun testBoolean() {
    var isSuccess = true
    var isFail = false
    var res = isFail and isSuccess
    if (!isSuccess) {
        log("没有成功")
    }
    log("boolean结果：" + res)
}

fun sum(a: Int, b: Int): Int {
    log("加法")
    /**
     * 这两种写法都可以？
     */
    var r: Int = a + b;
    var result = a + b;
    return r;
}

