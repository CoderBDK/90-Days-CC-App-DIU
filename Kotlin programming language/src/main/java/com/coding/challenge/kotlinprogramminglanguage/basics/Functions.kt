package com.coding.challenge.kotlinprogramminglanguage.basics

fun main(){
    println("Two int parameter " + sum(5,7))
    println("A Function body can be an Expression : ${sumInferred(5,7)}")
    sumUnit(5,7)
    sumOmitted(5,7)
}

// A function with two Int parameters and Int return type.
fun sum(a: Int, b: Int): Int{
    return a + b
}
// A function body can be an expression. Its return type is inferred.
fun sumInferred(a: Int, b: Int) = a + b

// A function that returns no meaningful value.
fun sumUnit(a: Int, b: Int): Unit{
    println("Unit function return no meaningful value: sum of $a and $b is ${a + b}")
}

// Unit return type can be omitted.
fun sumOmitted(a: Int, b: Int){
    println("Unit return type can be omitted : sum of $a and $b is ${a + b}")
}