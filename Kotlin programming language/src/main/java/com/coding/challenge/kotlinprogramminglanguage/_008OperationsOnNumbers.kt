package com.coding.challenge.kotlinprogramminglanguage

fun main(){
    // Kotlin supports the standard set of arithmetical operations over numbers: +, -, *, /, %.
    // They are declared as members of appropriate classes:
    println(1 + 2)
    println(2_500_000_000L - 1L)
    println(3.14 * 2.71)
    println(10.0 / 3)

    // Division of integers
    // Division between integers numbers always returns an integer number. Any fractional part is discarded.
    var x = 5 / 2
    // println(x == 2.5) // ERROR: Operator '==' cannot be applied to 'Int' and 'Double'
    println(x == 2)

    //This is true for a division between any two integer types:
    val xL = 5L / 2
    println(xL == 2L)

    //To return a floating-point type, explicitly convert one of the arguments to a floating-point type:

    val xDC = 5 / 2.toDouble()
    println(xDC == 2.5)

    // println(8/0) Error : java.lang.ArithmeticException: / by zero

    println(0 % 2)
    println( 8 % 2 == 0 && (7 % 3 != 0))

}