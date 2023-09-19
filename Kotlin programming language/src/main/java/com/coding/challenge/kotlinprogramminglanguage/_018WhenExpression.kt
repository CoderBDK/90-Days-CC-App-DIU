package com.coding.challenge.kotlinprogramminglanguage

fun main(){

    //When expression
    // when defines a conditional expression with multiple branches.
    // It is similar to the switch statement in C-like languages. Its simple form looks like this.

    var x = 2
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        3 -> print("x == 3")
        4 -> print("x == 4")
        5 -> {
            println("x == $x")
        }

        else -> {
            println("x is neither 1 nor 2")
        }
    }

    println()
    val numericValue = when (getRandomBit()) {
        Bit.ZERO -> 0
        Bit.ONE -> 1
        // 'else' is not required because all cases are covered
    }
    println("Numeric values is $numericValue")


    when (getColor()) {
        Color.RED -> println("red")
        Color.GREEN -> println("green")
        Color.BLUE -> println("blue")
        // 'else' is not required because all cases are covered
    }

    when (getColor()) {
        Color.RED -> println("red") // no branches for GREEN and BLUE
        else -> println("not red") // 'else' is required
    }

    // To define a common behavior for multiple cases,
    // combine their conditions in a single line with a comma:

    x= 3
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        1,3 -> println("x == 1 or x == 3")
        else -> print("otherwise")
    }

    x=1
    var s = "1"
    var e = "123"
    when (x) {
        s.toInt() -> println("s encodes x")
        e.toInt() -> println("e encode x")
        else -> println("s does not encode x")
    }
    // We can also check a value for being in or !in a range or a collection:

    val validNumbers = 0..5
    when (x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }
    fun hasPrefix(x: Any) = when(x) {
        is String -> x.startsWith("prefix")
        is String -> x.startsWith("good")
        else -> false
    }
    fun hasExists(v: Int) = when(v){
        1 -> true
        4 -> true
        else -> false
    }
    println()
    println("Is it true or false :${hasPrefix("prefix")}")
    println("Is it true or false :${hasPrefix("good")}")
    println("Is it true or false :${hasExists(12)}")

    // when can also be used as a replacement for an if-else if chain.
    // If no argument is supplied, the branch conditions are simply boolean expressions, and a branch is executed when its condition is true:
    var y = 10

    x = 99
    when {
        (x % 2 != 0) -> print("x is odd")
        (y % 2 == 0) -> print("y is even")
        else -> print("x+y is odd")
    }

    //You can capture when subject in a variable using following syntax:



    fun getBody() =
        when (val response = executeRequest()) {
            is Any -> Any()
            is Any -> throw Exception()
            else -> {
                println("unknown")
            }
        }
    //The scope of variable introduced in when subject is restricted to the body of this when.
    println(getBody())
}
fun executeRequest(): Any {
    return Any()
}

fun getRandomBit(): Bit {
    return Bit.values()[(0 until Bit.values().size).random()]
}

enum class Bit {
    ZERO, ONE
}

enum class Color {
    RED, GREEN, BLUE
}

fun getColor(): Color{
    return Color.values()[(0 until Color.values().size).random()]
}