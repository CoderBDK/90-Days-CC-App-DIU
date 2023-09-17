package com.coding.challenge.kotlinprogramminglanguage

import java.util.Arrays


/**
 * Arrays in Kotlin are represented by the Array class.
 * It has get() and set() functions that turn into [] by operator overloading conventions,
 * and the size property, along with other useful member functions:
 */
fun main(){
    // Creates an Array<String> with values ["0", "1", "4", "9", "16"]
    // Another option is to use the Array constructor that takes the array size
    // and the function that returns values of array elements given its index:
    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { println(it) }

    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]

    println(x.contentToString())

    val v = byteArrayOf(0)
    // Array of int of size 5 with values [0, 0, 0, 0, 0]
    val arr1 = IntArray(5)

    // Example of initializing the values in the array with a constant
    // Array of int of size 5 with values [42, 42, 42, 42, 42]
    val arr2 = IntArray(5) { 42 }

    // Example of initializing the values in the array using a lambda
    // Array of int of size 5 with values [0, 1, 2, 3, 4] (values initialized to their index value)
    var arr3 = IntArray(5) { it * 1 }

    println(arr1.contentToString())
    println(arr2.contentToString())
    println(arr3.contentToString())

    val arr4 = IntArray(5){99}
    println(arr4.contentToString())

    var arrObj = Array(5){i->
        intArrayOf(i+1,i+2,i+3)
    }
    arrObj.onEach {
        println(it.contentToString())
    }
    for(i in arrObj.indices){
        println(arrObj[i].contentToString())
    }


}