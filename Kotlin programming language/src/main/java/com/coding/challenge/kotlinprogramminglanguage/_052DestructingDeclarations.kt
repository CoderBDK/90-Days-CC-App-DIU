package com.coding.challenge.kotlinprogramminglanguage

import com.coding.challenge.kotlinprogramminglanguage.Result

object g{
    var h = 0
    operator fun component1(): Any {

        return 10
    }

    operator fun component2(): Any {
        return 10
    }

    var i = 0
}
data class Result(val result: Int, val status: Int)
fun function2(): Result {
    // computations

    return Result(0,1)
}

fun main() {
    var (name,roll) = g

    var c1 = g.component1()
    var c2 = g.component2()
    println(name)
    println(roll)
    val collection = arrayListOf(
        Pair(1,43),
        Pair(1,43),
    )
    for ((a, b) in collection) {
        println("<$a,$b>")
    }
    // Now, to use this function:
    val (result, status) = function2()
    println("$result, $status")

    val map = mapOf(
        "hel" to "hhh",
        "go" to "ok",
        "ni" to "ee"
    )
    for ((key, value) in map) {
        // do something with the key and the value
        println("$key and $value")
    }


}
/*
operator fun <K, V> Map<K, V>.iterator(): Iterator<Map.Entry<K, V>> = entrySet().iterator()
operator fun <K, V> Map.Entry<K, V>.component1() = getKey()
operator fun <K, V> Map.Entry<K, V>.component2() = getValue()
 */