package com.coding.challenge.kotlinprogramminglanguage

/**
 * The for loop iterates through anything that provides an iterator.
 * This is equivalent to the foreach loop in languages like C#.
 * The syntax of for is the following:
 * Doc {https://kotlinlang.org/docs/control-flow.html#for-loops
 */
fun main(){
    for (i in 0..3) {
        println(i)
    }
    println("down to")
    for (i in 6 downTo 0 step 2) {
        println(i)
    }
    println("for loop in indices")
    var array= arrayOf(1,2,3)
    for (i in array.indices) {
        println(array[i])
    }
    // Alternatively, we can use the withIndex library function:
    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }
}