package better.kotlin.learn.extenion

/**
 * Created by better on 2017/7/31.
 */
// 直接引用官方例子
open class D {
}
class D1 : D() {
}
open class C {
    open fun D.foo() {
        println("D.foo in C")
    }
    open fun D1.foo() {
        println("D1.foo in C")
    }
    fun caller(d: D) {
        d.foo() // call the extension function
    }
}
class C1 : C() {
    override fun D.foo() {
        println("D.foo in C1")
    }
    override fun D1.foo() {
        println("D1.foo in C1")
    }
}

/**
 * 扩展是静态解析的，只跟当前对象调用的方法申明处的类型有关
 */
public fun testExtendFun() {
    C().caller(D())  // prints "D.foo in C"
    C1().caller(D()) // prints "D.foo in C1" - dispatch receiver is resolved virtually
    C().caller(D1()) // prints "D.foo in C" - extension receiver is resolved statically
}