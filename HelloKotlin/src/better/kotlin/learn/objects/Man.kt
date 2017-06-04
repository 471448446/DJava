package better.kotlin.learn.objects

import better.kotlin.learn.bean.Car
import better.kotlin.log

/**
 * 一个类只能有一个主构造函数，父类有了，子类也可以再申明
 * 子类的构造函数，初始化时必须要初始化分类的某一个
 * Created by better on 2017/5/30.
 */
class Man(var ok: Boolean, /*这里为什么不能在此申明主构造函数？？*/name: String, sex: Int, age: Int) : Persion(name, sex, age), HunmanAction {
    /**
     * 车子可以没有
     */
    var car: Car? = null
        get() {
            log("检查man 有车没有")
            return field
        }
        set(value) {
            /**
             * 这样子会内存溢出，造成的递归构建？？
             */
            //            this.car=value
            /**
             * 这样子才对
             */
            field = value
            log("给man 买一个车==>$car")
        }

    constructor(name: String) : this(true, name, 1, 0)

    fun buyCar(newCar: Car) {
        this.car = newCar
    }

    override fun talk(msg: String) {
        println("man talk:" + msg)
    }
}