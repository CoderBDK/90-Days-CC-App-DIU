package com.coding.challenge.kotlinprogramminglanguage.basics

fun main() {
    var x = 118
    var y = 100

    if( x in 0.. y){
        println("fits in  range")
    }
    var list = listOf("a","b","c")

    if(-1 !in 0..list.lastIndex){
        println("-1 is out of range")
    }
    // list.size is the number of elements in the list
    // indices is range 0..size -1
    println("list size = ${list.size}, list indices= ${list.indices}")
    if(list.size !in list.indices){
        println("list size is out of valid indices range, too")
    }

    //Iterate over a range
    println("Iterate over a range:")
    for( i in 0..5){
        println("$i")
    }
    //Or over a progression.
    println("step 2 upTo")
    for (i in 0..10 step 2){
        println(i)
    }
    println("step 2 downTo")
    for (i in 10 downTo 0 step 2){
        println(i)
    }
}