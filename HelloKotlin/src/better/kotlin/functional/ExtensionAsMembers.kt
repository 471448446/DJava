package better.kotlin.functional

/**
 * Created by better on 2019/6/16.
 */

// extension as parameter
class C

class D
open class God {
    open fun C.speck() = "C speck() from God"
    fun D.speck() = " D speck() from God"
    fun talk(c: C) = "God talk with C = ${c.speck()}"
    fun talk(d: D) = "God talk with D = ${d.speck()}"
}

class Jesus : God() {
    override fun C.speck() = "Jesus C.speck() "
}

fun main(args: Array<String>) {
    // extension inheritance

    // extension as parameter
    val c = C()
    val d = D()
    val god = God()
    val jesus = Jesus()
    System.out.println("1.1" + god.talk(c))
    System.out.println("1.2" + god.talk(d))
    System.out.println("2.1" + jesus.talk(c))
    System.out.println("2.2" + jesus.talk(d))
}