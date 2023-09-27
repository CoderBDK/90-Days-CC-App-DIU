package com.coding.challenge.kotlinprogramminglanguage

import java.lang.reflect.Constructor

open class AOED(val x:Int){
    public open var y: Int = x
}
interface BOED{
}
interface AOED2 {
    fun funFromA() {}
}
class COED {
    private fun getObject() = object {
        val x: String = "x"
    }

    fun printX() {
        println(getObject().x)
    }
    // The return type is AOED2; x is not accessible
    fun getObjectA() = object: AOED2 {
        override fun funFromA() {}
        val x: String = "x"
    }

    // The return type is B; funFromA() and x are not accessible
    fun getObjectB(): B = object: AOED2, B { // explicit return type is required
        override fun funFromA() {}
        val x: String = "x"
    }
}

data class DataProvider(val name: String)
object DataProviderManager {
    fun registerDataProvider(provider: DataProvider) {

    }

    val allDataProviders: Collection<DataProvider>
        get() = arrayListOf()
}

object DIProvider: AOED2{
    override fun funFromA() {
        super.funFromA()
    }
}
data object MyDataObject {
    var x: Int = 3
}

data object MySingleton
sealed interface ReadResult
data class NumberOED(val number: Int) : ReadResult
data class Text(val text: String) : ReadResult
data object EndOfFile : ReadResult

fun printReadResult(r: ReadResult) {
    when(r) {
        is NumberOED -> println("Num(${r.number}")
        is Text -> println("Txt(${r.text}")
        is EndOfFile -> println("EOF")
    }
}
fun main() {
    var helloworld = object {
       val hello = "Hello"
        val world = "World"
        override fun toString(): String {
            return "$hello $world"
        }
    }
    println(helloworld.toString())

    var obj = object : AOED(10){
        override var y: Int = 100
    }

    println(obj.y)

    var coed = COED()
    coed.printX()
    coed.getObjectA().funFromA()
    coed.getObjectB()

    DataProviderManager.registerDataProvider(DataProvider(("data_provider-10.1v")))
    MyDataObject.x = 45
    println(MyDataObject.x)


    val evilTwin = createInstanceViaReflection()

    println(MySingleton) // MySingleton
    println(evilTwin) // MySingleton

    // Even when a library forcefully creates a second instance of MySingleton, its `equals` method returns true:
    println(MySingleton == evilTwin) // true

    // Do not compare data objects via ===.
    println(MySingleton === evilTwin) // false

    printReadResult(EndOfFile)
    printReadResult(Text("hello"))
    printReadResult(NumberOED(120))

    var myClassOED = MyClassOED.create()
    val f = MyClassOED2.create()

}

fun createInstanceViaReflection(): MySingleton {
    // Kotlin reflection does not permit the instantiation of data objects.
    // This creates a new MySingleton instance "by force" (i.e. Java platform reflection)
    // Don't do this yourself!
    return (MySingleton.javaClass.declaredConstructors[0].apply { isAccessible = true } as Constructor<MySingleton>).newInstance()
}
class MyClassOED {
    companion object Factory {
        fun create(): MyClassOED = MyClassOED()
    }

}

interface FactoryOED<T> {
    fun create(): T
}

class MyClassOED2 {
    companion object : FactoryOED<MyClass> {
        override fun create(): MyClass = MyClass()
    }
}

