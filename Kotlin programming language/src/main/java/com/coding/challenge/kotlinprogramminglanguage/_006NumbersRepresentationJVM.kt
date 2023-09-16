package com.coding.challenge.kotlinprogramminglanguage

/**
 * On the JVM platform, numbers are stored as primitive types: int, double, and so on.
 * Exceptions are cases when you create a nullable number reference such as Int? or use generics.
 * In these cases numbers are boxed in Java classes Integer, Double, and so on.
 *
 * Nullable references to the same number can refer to different objects:
 */
fun main(){

    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 1000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b



    println(boxedA === anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false

    // All nullable references to a are actually the same object because of the
    // memory optimization that JVM applies to Integers between -128 and 127.
    // It doesn't apply to the b references, so they are different objects.
    // On the other hand, they are still equal:

    println(boxedB == anotherBoxedB) // true

    println(boxedB)
    println(anotherBoxedB)

}