package better.kotlin.learn.delegation

import better.kotlin.log
import better.kotlin.logPart
import kotlin.properties.Delegates

/**
 * Created by better on 2017/8/2.
 */
/**
 * 被代理类接口
 */
interface Base {
    fun display()
}

/**
 * 被代理类
 */
open class BaseImpl : Base {
    override fun display() = log("just display me.")
}

/**
 * 代理类，使用:以及by关键词进行声明
 */
class Drived(base: Base) : Base by base {
    /**
     * 复写了代理类的方法后，调用时以复写的为准。即不会输出 just display me.
     */
    override fun display() = log("有何意思")
}

class A {
    val delegationA: String by lazy {
        log("by:延迟属性。初始化lazy->delegationA")
        "我是最终的名字"
    }
    var delegationB: String by Delegates.notNull<String>()

    var A: String? = null
}

class User(map: Map<String, Any>) {
    val name by map
    val psw by map
    override fun toString(): String = "name=$name,psw=$psw"
}

fun main(args: Array<String>) {
    showDelegationClassTest()
    showDelegationProperty()
}

fun showDelegationClassTest() {
    var b = BaseImpl()
    var drived = Drived(b) //代理b对象
    drived.display() //直接使用b中的public方法
}

fun showDelegationProperty() {
    val a = A()
    log(a.delegationA)
    log("---")
    log(a.delegationA)
    a.delegationB = "必须先赋值，在get，不然就抛异常,注释掉赋值代码看效果"
    log("delegationB：" + a.delegationB)
    a.delegationB = "第二次赋值b值"
    log("delegationB:" + a.delegationB)
    a.A = ""
    logPart("map")
    //Exception in thread "main" java.util.NoSuchElementException: Key psw is missing in the map.
    val user = User(mapOf("name" to "Hello", "psw" to "123"))
    log("user:" + user.toString())
}