package com.coding.challenge.kotlinprogramminglanguage

/**
 * All programs need to be able store data and variables
 * read-only variables with : val
 * mutable variables with : var
 * To assign a value in variable using assignment operator : =
 */
fun main(){
    //mutable variable
    var time = 0 // when start the time is 0s

    println(time)

    println("---Mutable variable---")
    println("1-Current time is : $time")

    time = 10 //1: change the time reassign the value 10s
    println("2-Current time is : $time")

    time = 20 //2: at the end value 20s
    println("3-Current time is : $time")

    //read-only variable immutable
    //init the val
    val face = 1 // Humans have only one face
    //face = 7 //compilation error : "Val cannot be reassigned"

    println("---Read only variable---")
    println("Humans have only one face: $face")

    //string template

    println("Current time is : ${time + 1000}s")
    time = 99
    println("Current time is : ${time + 100}s")

    val name = "Mary"
    val age = 20

    println("$name is $age years old.")

}