package com.coding.challenge.kotlinprogramminglanguage

import kotlin.math.ceil

/**
 * The type Boolean represents boolean objects that can have two values: true and false.
 *
 * Boolean has a nullable counterpart Boolean? that also has the null value.
 * Built-in operations on booleans include:
 * || – disjunction (logical OR)
 * && – conjunction (logical AND)
 * ! – negation (logical NOT)
 * || and && work lazily.
 */
fun main(){
    val myTrue: Boolean = true
    val myFalse: Boolean = false
    val boolNull: Boolean? = null

    println(myTrue || myFalse)
    println(myTrue && myFalse)
    println(!myTrue)
    println(boolNull===null)

    var n = Math.random().toInt()
    var logic = (n > 100 || n < 200 && n!=0 )
    println(logic)


    var amount = ceil(Math.random() * 200).toInt()

    val isMoneyAvailable = amount !=0

    var price = 100
    println("Your balance : $amount")
    println("Product price : $price")

    if(isMoneyAvailable && amount >= price){
        println("You can buy it.")
    }else{
        println("You cannot buy it.")
    }



}