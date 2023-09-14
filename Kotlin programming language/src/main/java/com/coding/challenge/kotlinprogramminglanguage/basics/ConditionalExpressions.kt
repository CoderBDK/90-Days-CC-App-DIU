package com.coding.challenge.kotlinprogramminglanguage.basics

fun main(){
    println("Max of(4,6): ${maxOf(2,5)}")
    println("Abs(-23): ${absOf(-23)}")
}

fun maxOf(a: Int, b:Int): Int{
    if(a > b){
        return a
    }else{
       return b
    }
}

fun maxOf2(a: Int, b: Int) = if(a > b) a else b

fun absOf(a: Int) = if(a < 0){
    var b = a * -1
    b
} else a
