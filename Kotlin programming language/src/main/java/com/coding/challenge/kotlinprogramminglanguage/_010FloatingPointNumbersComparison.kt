package com.coding.challenge.kotlinprogramminglanguage

/**
 * The operations on floating-point numbers discussed in this section are:
 * Equality checks: a == b and a != b
 * Comparison operators: a < b, a > b, a <= b, a >= b
 * Range instantiation and range checks: a..b, x in a..b, x !in a..b
 *
 * @Doc https://kotlinlang.org/docs/numbers.html#floating-point-numbers-comparison
 */
fun main(){
    println(Double.NaN == Double.NaN)                 // false
    println(listOf(Double.NaN) == listOf(Double.NaN)) // true

    println(0.0 == -0.0)                              // true
    println(listOf(0.0) == listOf(-0.0))              // false

    println(listOf(Double.NaN, Double.POSITIVE_INFINITY, 0.0, -0.0).sorted())
    // [-0.0, 0.0, Infinity, NaN]

    println(100 == 100) // true
    println(100 === 100) // true
    println(10.0 == 10.0) // true

}
