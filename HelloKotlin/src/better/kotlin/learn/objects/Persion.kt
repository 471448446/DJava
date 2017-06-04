package better.kotlin.learn.objects

/**
 * 主构造函数，相当于申明了类的属性
 * Created by better on 2017/5/30.
 */
open class Persion constructor(var name: String, var sex: Int, age: Int) {
    /**
     * 申明可变属性，还必须要初始化,否则就abstract
     */
    var age: Int = age
        set(value) {
            age = value
        }
    /**
     * 申明不可变属性,在构造函数中初始化
     */
    val id: Int?

    init {
        id = 10
    }

    /**
     * 申明不可变属性
     */
    val id2 = 10
    /**
     * 只能自己看到
     */
    private var tag: Long = 10

    constructor(name: String, sex: Int, age: Int, tag: String) : this(name, sex, age)

    constructor(tag: String) : this("default", 1, 0)

    override fun toString(): String {
        return "name:$name,sex:$sex"
    }
}