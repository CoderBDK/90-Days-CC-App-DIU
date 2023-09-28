package com.coding.challenge.kotlinprogramminglanguage

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Delegate{
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}
class ExampleDelegateProperties{
    var p: String by Delegate()
}

val lazyValue: String by lazy {
    println("computed!")
    "Hello"

}
class UserDLObservable {
    var name: String by Delegates.observable("<no name>") {
            _, old, new ->
        println("$old -> $new")
    }
}


var topLevelInt: Int = 0
class ClassWithDelegate(val anotherClassInt: Int)

class MyClassDLP(var memberInt: Int, val anotherClassInstance: ClassWithDelegate) {
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt

    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt

    var newName: Int = 0
    @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
    var oldName: Int by this::newName
}
var MyClass.extDelegated: Int by ::topLevelInt

class UserDLP(map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

class FooDLP{
    private var someCondition = true
    fun doSomething(){
        println("Foo do something")
    }
    fun isValid(): Boolean {
        return someCondition
    }
}
fun exampleDlp(computeFoo: () -> FooDLP) {
    val memoizedFoo by lazy(computeFoo)
    val someCondition = true
    if (someCondition && memoizedFoo.isValid()) {
        memoizedFoo.doSomething()
    }
}

private fun conCate(main: ()-> String){
    val call by lazy(main)
    println(call)
}

fun main() {
    val e = ExampleDelegateProperties()
    e.p = "Hello"
    println(e.p)

    println(lazyValue)
    println(lazyValue)
    println(lazyValue)

    val userdlo = UserDLObservable()
    userdlo.name = "first1"
    userdlo.name = "second2"
    userdlo.name = "first3"
    userdlo.name = "second4"
    println("OK")

    var mMyClassDLP = MyClassDLP(4, ClassWithDelegate(19))

    println(mMyClassDLP.memberInt)
    println(mMyClassDLP.delegatedToMember)
    println(mMyClassDLP.delegatedToAnotherClass)
    println(mMyClassDLP.delegatedToTopLevel)

    println(mMyClassDLP.newName)

    val user = UserDLP(mapOf(
        "name" to "John Doe",
        "age"  to 25
    ))

    println(user.name) // Prints "John Doe"
    println(user.age)  // Prints 25

    exampleDlp {
        FooDLP()
    }
    conCate {
        "gfg"
    }
}