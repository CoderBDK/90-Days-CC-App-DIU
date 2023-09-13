package com.coding.challenge.kotlinprogramminglanguage.basics

// We can declare variables at the top level.
val PI = 3.14
var x = 0

fun main(){
    // Read-only local variables are defined using the keyword val.
    // They can be assigned a value only once.
    val a: Int = 10 //immediate assignment
    println("Val keyword Immediate assignment : $a")

    val b = 500 // `Int` type is inferred
    println("Val keyword Int Type is inferred : $b")

    val c: Int //Type required when no initializer is provided
    c = 100 // deferred assignment
    println("Val keyword Deferred assignment : $c")

    // Variables that can be reassigned use the var keyword.
    var d = 1000 // `Int` type is inferred
    d += 100
    println("var keyword inferred variable : $d")

    var e: Int = 100
    println("var keyword Immediate assignment : $e")

    println("Top Level Variables")
    println("Before increment the value of x is : $x")
    incrementX() // the function is called here
    println("After increment the value of x is : $x")

    println("Before decrement the value of x is : $x")
    decrementX() // the function is called here
    println("After decrement the value of x is : $x")

}

// the incrementX function is will increment the value of x by x = x + 1
fun incrementX(){
    x += 1 // The value of x is incremented by x = x + 1
    // invalid
    // x + = 2
}
// the decrementX function is will decrement the value of x by x = x - 1
fun decrementX(){
    x -= 1 // The value of x is decremented by x = x - 1
}
