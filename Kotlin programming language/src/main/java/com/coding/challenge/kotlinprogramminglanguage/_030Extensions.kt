package com.coding.challenge.kotlinprogramminglanguage

open class Shape3
class Rectangle7: Shape3()

fun Shape3.getName() = "Shape"
fun Shape3.getSum(a: Int,b: Int) = a + b
fun Rectangle7.getName() = "Rectangle"

fun printClassName(s: Shape3) {
    println(s.getName())
}
fun printSum(s: Shape3){
    println(s.getSum(1,5))
}

class Example {
    fun printFunctionType() { println("Class method") }
}

fun Example.printFunctionType() { println("Extension function") }
fun Example.printFunctionType(i: Int) { println("Extension function #$i") }


fun MutableList<Int>.swap(a:Int, b: Int){
    val temp= this[a]
    this[a] = this[b]
    this[b] = temp
}
fun main() {
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2)

    println(list)
    println(Shape3().getName())
    println(Rectangle7().getName())
    printClassName(Rectangle7())
    printSum(Rectangle7())
    Example().printFunctionType()
    Example().printFunctionType(1)

    var size = ArrayList<Int>(1).lastIndex
    MyClass.printCompanion()
    MyClass.printCompanion2()

    val alist = listOf("red", "green", "blue")
    println( alist.getLongestString())

    Connection(Host("kotl.in"), 443).connect()

    BaseCaller().call(Base3())   // "Base extension function in BaseCaller"
    DerivedCaller().call(Base3())  // "Base extension function in DerivedCaller" - dispatch receiver is resolved virtually
    DerivedCaller().call(Derived3())  // "Base extension function in DerivedCaller" - extension receiver is resolved statically

}

fun Any?.toString(): String {
    if (this == null) return "null"
    // After the null check, 'this' is autocast to a non-nullable type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}
val <T> List<T>.lastIndex: Int get() = size - 1
class MyClass {
    companion object { }  // will be called "Companion"
}

fun MyClass.Companion.printCompanion() { println("companion") }
fun MyClass.Companion.printCompanion2() { println("companion2") }

fun List<String>.getLongestString() { /*...*/}

class Host(val hostname: String) {
    fun printHostname() { print(hostname) }
}

class Connection(val host: Host, val port: Int) {
    fun printPort() { print(port) }

    fun Host.printConnectionString() {
        printHostname()   // calls Host.printHostname()
        print(":")
        printPort()   // calls Connection.printPort()
    }

    fun connect() {
        /*...*/
        host.printConnectionString()   // calls the extension function
    }
}
open class Base3 { }

class Derived3 : Base3() { }

open class BaseCaller {
    open fun Base3.printFunctionInfo() {
        println("Base extension function in BaseCaller")
    }

    open fun Derived3.printFunctionInfo() {
        println("Derived extension function in BaseCaller")
    }

    fun call(b: Base3) {
        b.printFunctionInfo()   // call the extension function
    }
}

class DerivedCaller: BaseCaller() {
    override fun Base3.printFunctionInfo() {
        println("Base extension function in DerivedCaller")
    }

    override fun Derived3.printFunctionInfo() {
        println("Derived extension function in DerivedCaller")
    }
}

