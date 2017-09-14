package better.kotlin.learn

import better.kotlin.learn.objects.bean.Car
import better.kotlin.learn.delegation.showDelegationClassTest
import better.kotlin.learn.delegation.showDelegationProperty
import better.kotlin.learn.objects.*
import better.kotlin.log
import better.kotlin.logEnd
import better.kotlin.logStart
import better.kotlin.learn.extenion.*

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
    testVarVal()
    testArray()
    testString()
    testIf()
    testWhen()
    testPersion()
    testExtendMethod()
    testOther_Equal()
    testOther_Cast(null)
    testOther_Null(null)
    testObject_Delegation()
}

fun testObject_Delegation() {
    log("testObject_Delegation")
    showDelegationClassTest()
    showDelegationProperty()
}

fun testExtendMethod() {
    log("testExtend___")
    testExtendFun()
}

/**
 * 定义的时候指定可不可以null。
 * 访问访问null的对象
 *
 */
fun testOther_Null(nothing: Nothing?) {
    logStart("testOther_Null_____")

    var a: String = "a"
    /*
    * a = null
    *
    * null cannot be a value of non-null type String
    * a定义的时候就明确表示不能为null
     */
    var b: String?
    b = null
    // 1 判断b是否null
    if (null != b) {
        log(b)
    }
    //2 ?. delegationB 如果null就返回null
    log("delegationB length=" + b?.length)
    //3 ?.let只有b不null的时候执行
    b?.let {
        log(it)
        /*
         * 这样是不行的。因为b是变量，可以被其他地方改变
         * Kotlin: Smart cast to 'String' is impossible, because 'delegationB' is a local variable that is captured by a changing closure
         * https://stackoverflow.com/questions/34498562/in-kotlin-what-is-the-idiomatic-way-to-deal-with-nullable-values-referencing-o
         */
        //        log(delegationB)
    }
    // 4 ?: 条件执行
    val c = b?.length ?: -1
    log("delegationB length=" + c)
    //5 b要是null就抛异常
    try {
        var a = nothing!!
        log("得到a="+a)
        val bCopy = b!!.length
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

/**
 * 判断类型：is、!is
 * 类型转换：as、as?
 */
fun testOther_Cast(p: Any?) {
    logStart("testOther_Cast____")

    when (p) {
        null -> log("输入 参数 null")
    }

    var a: Int = 1
    try {
        val str: String = a as String
        log("__" + str)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    val str: String? = p as String?
    log("2__" + str)

    val str3: Int? = p as? Int?
    log("3__" + str3)

}

/**
 * null cannot be cast to non-null type
 */
fun testOther_Equal() {
    var a: Int? = null
    var b: Int? = null
    var c = 1
    var d2 = 2
    var d1 = 1
    log("引用相等 null vs null:" + (a === b))
    log("引用相等 null vs 1:" + (a === c))
    log("引用相等 1 vs 1:" + (c === d1))
    log("引用相等 1 vs 2:" + (c === d2))
    log("结构相等 null vs null:" + (a == b))
    log("结构相等 null vs 1:" + (a == c))
    log("结构相等 1 vs 1:" + (c === d1))
    log("结构相等 1 vs 2:" + (c == d2))
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
    log("delegationB=$b")
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

fun testVarVal() {

    log("testVarVal___")
    var a = 1
    val aVal = 1
// 不能修改
//    aVal =2
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
