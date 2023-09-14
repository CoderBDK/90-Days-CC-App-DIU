package com.coding.challenge.kotlinprogramminglanguage.basics

fun main(){
    var a = 100
    // simple name in template
    var s1 = "a is $a"
    a = 20
    // arbitrary expression in template
    var s2 = "${s1.replace("is","was")}, but now $a"
    println(s2)
}