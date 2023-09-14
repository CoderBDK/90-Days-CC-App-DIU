package com.coding.challenge.kotlinprogramminglanguage.basics

fun main() {
    val items = listOf("apple","banana","mango","kiwifruit")
    // For loop : 1
    for (item in items){
        println(item)
    }
    // For loop : 2
    for(index in items.indices){
        println("item at $index is ${items[index]}")
    }
    // While loop
    var index = 0
    while (index < items.size){
        println("item at $index is ${items[index]}")
        index++
    }
    //when expression
    println(describe(1))
    println(describe("Hello"))
    println(describe(1L))
    println(describe(10u))
    println(describe(0.0))
}
// when expression
fun describe(obj: Any): String =
    when(obj){
        1           -> "One"
        "Hello"     -> "Greeting"
        is Long     -> "long"
        !is String  -> "Not a String"
        else -> "Unknown"

    }