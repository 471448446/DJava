package better.kotlin.functional

/**
 * Created by better on 2019/6/13.
 */
// extension inheritance
open class A {
    private val name = "AA"
    private fun fuck() = "AA"
    val age = 20
    open fun name() = "super call A()"
}

// 不能访问private的members
fun A.speak() = "A extension$age"

open class B : A() {
    override fun name() = "child call A()"
}

fun B.speak() = "BBB extension"

fun method1(a: A) = a.name()
fun method2(a: A) = a.speak()

// extension as parameter

fun main(args: Array<String>) {
    // extension inheritance
    val a = A()
    val b = B()
    System.out.println("override function")    // 多态
    System.out.println(method1(a))
    System.out.println(method1(b))
    System.out.println("inheritance extension")
    System.out.println(method2(a))
    System.out.println(method2(b))
    // extension as parameter

}