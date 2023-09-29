package com.coding.challenge.kotlinprogramminglanguage

import kotlin.math.pow

fun double(x: Int): Int{
    return  2 * x
}

fun read(
    b: ByteArray,
    off: Int = 0,
    len: Int = b.size,
){

}

open class AFunc {
    open fun foo(i: Int = 10) { /*...*/ }
}

class BFunc : AFunc() {
    override fun foo(i: Int) {
        println(i) // No default value is allowed.
    }
}

fun foo(
    bar: Int = 0,
    baz: Int = 1,
    qux: () -> Unit,
) {
    println(bar)
    println(baz)
    println(qux)
}
fun foo(vararg strings: String) {
   for(p in strings){
       println(p)
   }
}
fun double2(x: Int): Int = x * 2

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}

infix fun Int.ishl(x: Int): Int {
    return x + 55
}

infix fun Boolean.bshl(x: Int): Int {
    return x + 55
}
class MyStringCollection {
    infix fun add(s: String) { /*...*/ }

    fun build() {
        this add "abc"   // Correct
        add("abc")       // Correct
        //add "abc"        // Incorrect: the receiver must be specified
    }
}
fun main() {
    var result = double(10)
    println(result)

    var bFunc = BFunc()
    bFunc.foo(1000) // 1000
    bFunc.foo() // default value : 10


    foo(1,4){
        println("Hello")
    }
    foo {
        println("Hello")
    }
    foo(1) { println("hello") }     // Uses the default value baz = 1
    foo(qux = { println("hello") }) // Uses both default values bar = 0 and baz = 1
    foo { println("hello") }        // Uses both default values bar = 0 and baz = 1


    foo(strings = arrayOf("a", "b", "c"))
    val list = asList(ts= arrayOf(1, 2, 3))
    val list2 = asList(1, 2, 3)

    println(list.toString())
    println(list2.toString())

    val a = intArrayOf(1, 2, 3) // IntArray is a primitive type array
    val list3 = asList(-1, 0, *a.toTypedArray(), 4)

    // infix notation
    1 ishl 2
    2.ishl(3)
    // calling the function using the infix notation
    1 shl 2
    // is the same as
    1.shl(2)
    true bshl 2
    val b = true.bshl(1)

    alloc()
}
fun alloc(){
    fun free(space:Unit){

    }
}

/// A member function is a function that is defined inside a class or object:
class Sample {
    fun foo() { print("Foo") }
}

fun <T> singletonList(item: T): List<T> {
    return arrayListOf(item)
}

val eps = 1E-10 // "good enough", could be 10^-15

tailrec fun findFixPoint(x: Double = 1.0): Double =
    if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))

private fun findFixPoint(): Double {
    var x = 1.0
    while (true) {
        val y = Math.cos(x)
        if (Math.abs(x - y) < eps) return x
        x = Math.cos(x)
    }
}