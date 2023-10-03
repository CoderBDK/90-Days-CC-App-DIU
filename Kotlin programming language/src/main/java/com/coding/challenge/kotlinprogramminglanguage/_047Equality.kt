package com.coding.challenge.kotlinprogramminglanguage

fun main() {
    var a = 9
    var b = 7
    // structure equality
    println(if(a == b) "true" else "false")
    println(if(a === b) "true" else "false")

    a = 9
    b = 9
    println(if(a == b) "true" else "false")
    println(if(a === b) "true" else "false")

    // referential equality
    var c = String("22".toCharArray())
    var d:String = String("21".toCharArray())

    println(if(c == d) "true" else "false")
    println(if(c === d) "true" else "false")

    c = String("22".toCharArray())
    d = String("22".toCharArray())

    println(if(c == d) "true" else "false") // true
    println(if(c != d) "true" else "false") // false
    println(if(c === d) "true" else "false") // false // reference not matched
    println(if(c !== d) "true" else "false") // true
    c = "22"
    d = "22"
    println()
    println(if(c == d) "true" else "false") // true
    println(if(c != d) "true" else "false") // false
    println(if(c === d) "true" else "false") // true // reference matched
    println(if(c !== d) "true" else "false") // false
}