package com.coding.challenge.kotlinprogramminglanguage

/**
 * while and do-while loops execute their body continuously while their condition is satisfied.
 * The difference between them is the condition checking time:
 *
 * while checks the condition and, if it's satisfied, executes the body
 * and then returns to the condition check.
 *
 * do-while executes the body and then checks the condition. If it's satisfied, the loop repeats.
 * So, the body of do-while executes at least once regardless of the condition.
 */

fun main(){
    var x = 0
    while (x < 10) {
        x++
    }

    var y = 0
    do {
       y++
    } while (y < 10) // y is visible here!

    println("x is $x , y is $y")

}