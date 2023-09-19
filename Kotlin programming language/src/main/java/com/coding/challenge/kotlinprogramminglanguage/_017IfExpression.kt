package com.coding.challenge.kotlinprogramminglanguage

fun main() {
    // If expression
    // In Kotlin, if is an expression: it returns a value.
    // Therefore, there is no ternary operator (condition ? then : else)
    // because ordinary if works fine in this role.

    var a = 8
    var b = 9
    var max = a
    if (a < b) max = b

    // With else
    if (a > b) {
        max = a
    } else {
        max = b
    }

    // As expression
    max = if (a > b) a else b

    // You can also use `else if` in expressions:
    val maxLimit = 1
    val maxOrLimit = if (maxLimit > a) maxLimit else if (a > b) a else b


    var isTrue = if (a > b) a != b else if (a > b && a < 10 || b > 10) true else a < b

    println(max)
    println(maxOrLimit)
    println(isTrue)

    // If we're using if as an expression, for example,
    // for returning its value or assigning it to a variable, the else branch is mandatory.
    // a = if ( x > y) //here the else branch is mandatory
}