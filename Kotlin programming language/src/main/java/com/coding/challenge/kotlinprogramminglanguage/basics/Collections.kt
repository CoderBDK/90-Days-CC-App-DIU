package com.coding.challenge.kotlinprogramminglanguage.basics

import java.util.Locale

fun main(){
    //collections of array
    var items = arrayOf('A','E','I','O','U')
    print("Vowels : ")
    // Iterate over a collection.
    for (vowel in items){
        print("$vowel ")
    }
    // print a new line
    println()

    // Check if a collection contains an object using in operator.
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit","mango")
    when{
        "apple" in fruits->{
            println("Apple is fine too")
        }
        "mango" in fruits->{
            println("Looking beautiful, juicy and yummy test")
        }
        "orange" in fruits->{
            println("Juicy")
        }
    }

    print("Filtering and Mapping : ")
    fruits.filter { it.contains("a") && it.startsWith("b") || it.startsWith("m") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { print("$it ") }

    println()

    // Nullable values and null check
    printProduct("10","10")
    printProductNullCheck("10","10")




}

fun printProduct(arg1: String, arg2: String){
    val x = Integer.parseInt(arg1)
    val y = Integer.parseInt(arg2)

    //using x * y yields error because they may be holds nulls
    if(x !=null && y!=null){
        // x and y automatically cast to not nullable after null check
        println(x * y)
    }else{
        println("'$arg1' and '$arg2' is not a number")
    }
}
fun isValidNumber(value: String) : Boolean{
    for (v in value){
        if(!Character.isDigit(v))return false
    }
    return true
}
fun printProductNullCheck(arg1: String, arg2: String){

    if ( arg1.isNullOrEmpty() || arg2.isNullOrEmpty()) {
        println("Null or empty value not accepted")
        return
    }
    if ( !isValidNumber(arg1) || !isValidNumber(arg2)){
        println("Value should be must a number")
        return
    }
    val x = Integer.parseInt(arg1)
    val y = Integer.parseInt(arg2)

    println(x * y)
}