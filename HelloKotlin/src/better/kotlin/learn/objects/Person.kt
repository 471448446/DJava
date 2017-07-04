package better.kotlin.learn.objects

/**
 * 主构造函数，相当于申明了类的属性
 * Created by better on 2017/5/30.
 */
open class Person constructor(var name: String, var sex: Sex, age: Int) : HunmanAction {


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

    var talkListener: MutableList<TalkListener> = mutableListOf()

    constructor(name: String, sex: Int, age: Int, tag: String) : this(name, Sex.man, age)

    constructor(tag: String) : this("default", Sex.man, 0)

    override fun toString(): String {
        return "name:$name,sex:$sex"
    }

    override fun talk(msg: String) {
        for (talkListenerItem in talkListener) {
            talkListenerItem.onTalk("talkListener"+msg)
        }
    }

    fun addTalkListener(talk: TalkListener) {
        talkListener.add(talk)
    }

}