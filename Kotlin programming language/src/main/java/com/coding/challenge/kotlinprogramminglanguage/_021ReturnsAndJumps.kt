package com.coding.challenge.kotlinprogramminglanguage

/**
 * Kotlin has three structural jump expressions:
 * return by default returns from the nearest enclosing function or anonymous function.
 * break terminates the nearest enclosing loop.
 * continue proceeds to the next step of the nearest enclosing loop.
 * All of these expressions can be used as part of larger expressions:
 */

fun main(){

    loop@ for (i in 0..3){
        for (j in 1..10) {
            if (i + j > 100) break@loop
        }
    }

   // foo1(); foo2() // valid exp: inline call
    // foo1() foo2() // invalid
    foo1()
    println("not reached")
    foo2()
    foo3()
    foo4()
    foo5()
    println("Done")



}

fun foo1() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return // non-local return directly to the caller of foo()
        println(it)
    }
    println("this point is unreachable")
}
fun foo2() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda - the forEach loop
        println(it)
    }
    print(" done with explicit label")
}
fun foo3() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
        println(it)
    }
    print(" done with implicit label")
}
fun foo4() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return  // local return to the caller of the anonymous function - the forEach loop
        println(value)
    })
    print(" done with anonymous function")
}
fun foo5() {
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // non-local return from the lambda passed to run
            println(it)
        }
    }
    println(" done with nested loop")
}